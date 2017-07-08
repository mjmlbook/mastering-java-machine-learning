package org.mjml.ch7.expts;

import org.deeplearning4j.api.storage.StatsStorage;
import org.deeplearning4j.datasets.iterator.impl.MnistDataSetIterator;
import org.deeplearning4j.eval.Evaluation;
import org.deeplearning4j.nn.api.OptimizationAlgorithm;
import org.deeplearning4j.nn.conf.GradientNormalization;
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.Updater;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.deeplearning4j.nn.conf.layers.RBM;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.nn.weights.WeightInit;
import org.deeplearning4j.optimize.api.IterationListener;
import org.deeplearning4j.optimize.listeners.ScoreIterationListener;
import org.deeplearning4j.ui.api.UIServer;
import org.deeplearning4j.ui.stats.StatsListener;
import org.deeplearning4j.ui.storage.InMemoryStatsStorage;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
import org.nd4j.linalg.lossfunctions.LossFunctions.LossFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;

/**
 * Created by agibsonccc on 9/11/14.
 */
public class DBNMnistExample {

    private static Logger log = LoggerFactory.getLogger(DBNMnistExample.class);

    public static void main(String[] args) throws Exception {
        final int numRows = 28;
        final int numColumns = 28;
        int outputNum = 10;
        int numSamples = 60000;
        int minibatchSize = 128;
        int iterations = 1;
        int seed = 12345;
        int listenerFreq = minibatchSize / 5;
        int nEpochs = 10;

        log.info("Load data....");
        DataSetIterator trainIter = new MnistDataSetIterator(minibatchSize, numSamples, true, true, false, seed);

        log.info("Build model....");
        MultiLayerConfiguration conf = new NeuralNetConfiguration.Builder()
           .seed(seed)
           .gradientNormalization(GradientNormalization.ClipElementWiseAbsoluteValue)
           .gradientNormalizationThreshold(1.0)
           .iterations(iterations)
           .learningRate(0.9)
           .momentum(0.5)
           .updater(Updater.NESTEROVS)
           .momentumAfter(Collections.singletonMap(3, 0.9))
           .optimizationAlgo(OptimizationAlgorithm.CONJUGATE_GRADIENT)
           .list()
           .layer(0, new RBM.Builder().nIn(numRows*numColumns).nOut(500)
                         .weightInit(WeightInit.XAVIER).lossFunction(LossFunction.KL_DIVERGENCE)
                         .visibleUnit(RBM.VisibleUnit.BINARY)
                         .hiddenUnit(RBM.HiddenUnit.BINARY)
                         .build())
           .layer(1, new RBM.Builder().nIn(500).nOut(500)
                         .weightInit(WeightInit.XAVIER).lossFunction(LossFunction.KL_DIVERGENCE)
                         .visibleUnit(RBM.VisibleUnit.BINARY)
                         .hiddenUnit(RBM.HiddenUnit.BINARY)
                         .build())
           .layer(2, new RBM.Builder().nIn(500).nOut(2000)
                         .weightInit(WeightInit.XAVIER).lossFunction(LossFunction.KL_DIVERGENCE)
                         .visibleUnit(RBM.VisibleUnit.BINARY)
                         .hiddenUnit(RBM.HiddenUnit.BINARY)
                         .build())
           .layer(3, new OutputLayer.Builder(LossFunction.NEGATIVELOGLIKELIHOOD).activation(Activation.SOFTMAX)
                         .nIn(2000).nOut(outputNum).build())
           .pretrain(true).backprop(true)
           .build();

        MultiLayerNetwork model = new MultiLayerNetwork(conf);
        model.init();
        model.setListeners(Collections.singletonList((IterationListener) new ScoreIterationListener(listenerFreq)));

        //Initialize the user interface backend
        UIServer uiServer = UIServer.getInstance();

        //Configure where the network information (gradients, activations, score vs. time etc) is to be stored
        //Then add the StatsListener to collect this information from the network, as it trains
        StatsStorage statsStorage = new InMemoryStatsStorage();             //Alternative: new FileStatsStorage(File) - see UIStorageExample
        int listenerFrequency = 1;
        model.setListeners(new StatsListener(statsStorage, listenerFrequency));

        //Attach the StatsStorage instance to the UI: this allows the contents of the StatsStorage to be visualized
        uiServer.attach(statsStorage);

        //Test data
        DataSetIterator testdataIter = new MnistDataSetIterator(minibatchSize, 10000, true, false, false, seed);

        //Perform training
        for (int i = 0; i < nEpochs; i++) {
            log.info("Starting epoch {} of {}",(i+1),nEpochs);
            while (trainIter.hasNext()) {
                DataSet ds = trainIter.next();
                model.fit(ds);

            }

            trainIter.reset();
        }

        log.info("Evaluate model....");
        Evaluation eval = new Evaluation(10); //create an evaluation object with 10 possible classes

        while(testdataIter.hasNext()){
            DataSet next = testdataIter.next();
            INDArray output = model.output(next.getFeatures()); //get the networks prediction
            eval.eval(next.getLabels(), output); //check the prediction against the true class
        }

        log.info(eval.stats());
        log.info("****************Example finished********************");

    }

}
