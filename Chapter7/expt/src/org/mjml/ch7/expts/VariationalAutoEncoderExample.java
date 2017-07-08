package org.mjml.ch7.expts;

import org.deeplearning4j.datasets.iterator.impl.MnistDataSetIterator;
import org.deeplearning4j.eval.Evaluation;
import org.deeplearning4j.nn.api.OptimizationAlgorithm;
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.Updater;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.deeplearning4j.nn.conf.layers.variational.BernoulliReconstructionDistribution;
import org.deeplearning4j.nn.conf.layers.variational.VariationalAutoencoder;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.nn.weights.WeightInit;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.api.DataSet;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.lossfunctions.LossFunctions.LossFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;


/**
 * A simple example of training a variational autoencoder on MNIST.
 *
 * @author Alex Black
 */
public class VariationalAutoEncoderExample {
    private static final Logger log = LoggerFactory.getLogger(VariationalAutoEncoderExample.class);

    public static void main(String[] args) throws IOException {
        int minibatchSize = 128;
        int rngSeed = 12345;
        int nEpochs = 20;                   //Total number of training epochs

        //MNIST data for training
        DataSetIterator trainIter = new MnistDataSetIterator(minibatchSize, true, rngSeed);

        //Neural net configuration
        Nd4j.getRandom().setSeed(rngSeed);
        MultiLayerConfiguration conf = new NeuralNetConfiguration.Builder()
            .seed(rngSeed)
            .iterations(1).optimizationAlgo(OptimizationAlgorithm.STOCHASTIC_GRADIENT_DESCENT)
            .learningRate(1e-2)
            .updater(Updater.RMSPROP).rmsDecay(0.95)
            .weightInit(WeightInit.XAVIER)
            .regularization(true).l2(1e-4)
            .list()
            .layer(0, new VariationalAutoencoder.Builder()
                .activation(Activation.LEAKYRELU)
                .encoderLayerSizes(256, 256)        //2 encoder layers, each of size 256
                .decoderLayerSizes(256, 256)        //2 decoder layers, each of size 256
                .pzxActivationFunction("identity")  //p(z|data) activation function
                .reconstructionDistribution(new BernoulliReconstructionDistribution(Activation.SIGMOID.getActivationFunction()))     //Bernoulli distribution for p(data|z) (binary or 0 to 1 data only)
                .nIn(28 * 28)                       //Input size: 28x28
                .nOut(128)                          //Size of the latent variable space: p(z|x).
                .build())
            .layer(1, new OutputLayer.Builder(LossFunction.NEGATIVELOGLIKELIHOOD).activation(Activation.SOFTMAX)
                .nIn(128).nOut(10).build())
            .pretrain(true).backprop(true).build();

        MultiLayerNetwork net = new MultiLayerNetwork(conf);
        net.init();

        //Test data
        DataSetIterator testdataIter = new MnistDataSetIterator(minibatchSize, false, rngSeed);

        //Perform training
        for (int i = 0; i < nEpochs; i++) {
            log.info("Starting epoch {} of {}",(i+1),nEpochs);
            while (trainIter.hasNext()) {
                DataSet ds = trainIter.next();
                net.fit(ds);

            }

            trainIter.reset();
        }

        log.info("Evaluate model....");
        Evaluation eval = new Evaluation(10); //create an evaluation object with 10 possible classes

        while(testdataIter.hasNext()){
            DataSet next = testdataIter.next();
            INDArray output = net.output(next.getFeatures()); //get the networks prediction
            eval.eval(next.getLabels(), output); //check the prediction against the true class
        }

        log.info(eval.stats());
        log.info("****************Example finished********************");
    }
}
