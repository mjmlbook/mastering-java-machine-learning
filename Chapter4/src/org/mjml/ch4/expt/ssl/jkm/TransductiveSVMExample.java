package org.mjml.ch4.expt.ssl.jkm;

import net.jkernelmachines.type.TrainingSample;
import net.jkernelmachines.kernel.typed.DoubleGaussL2;
import net.jkernelmachines.type.TrainingSample;
import net.jkernelmachines.classifier.transductive.S3VMLight;
import net.jkernelmachines.io.ArffImporter;
import java.io.IOException;
import java.util.List;

public class TransductiveSVMExample {

	public static void main(String[] args) {
		try {
		    //load the labeled training data
		    List<TrainingSample<double[]>> labeledTraining = ArffImporter.importFromFile("data/breast-labeled.arff");
		    //load the unlabeled data
		    List<TrainingSample<double[]>> unlabeledData = ArffImporter.importFromFile("data/breast-unlabeled.arff");
		    //create a kernel with Gaussian and gamma set to 1.0
		    DoubleGaussL2 k = new DoubleGaussL2(1.0);
		    //create transductive SVM with SVM light
		    S3VMLight<double[]> svm = new S3VMLight<double[]>(k);
		    //send the training labeled and unlabeled data
		    svm.train(labeledTraining, unlabeledData);
		    //calls to validate, test and predict go here
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
