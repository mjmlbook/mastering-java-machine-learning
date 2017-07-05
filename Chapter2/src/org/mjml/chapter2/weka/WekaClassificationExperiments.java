package org.mjml.chapter2.weka;

import weka.attributeSelection.InfoGainAttributeEval;
import weka.attributeSelection.Ranker;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.functions.LinearRegression;
import weka.classifiers.functions.Logistic;
import weka.classifiers.meta.AttributeSelectedClassifier;
import weka.classifiers.meta.ClassificationViaRegression;
import weka.classifiers.meta.FilteredClassifier;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.ReplaceMissingValues;

public class WekaClassificationExperiments {
	Instances trainingData;
	Instances testingData;

	public void initDataSets(String trainingFile, String testingFile) throws Exception {
		DataSource source = new DataSource(trainingFile);
		Instances data = source.getDataSet();
		if (data.classIndex() == -1)
			data.setClassIndex(data.numAttributes() - 1);
		// set the trainingfile
		trainingData = data;
		source = new DataSource(testingFile);
		data = source.getDataSet();
		if (data.classIndex() == -1)
			data.setClassIndex(data.numAttributes() - 1);
		// set the testingfile
		testingData = data;
	}

	public Filter getReplaceMissingValuesFilter() {
		return new ReplaceMissingValues();
	}

	public FilteredClassifier getFilteredClassifier(Filter f, Classifier c) {
		FilteredClassifier fc = new FilteredClassifier();
		fc.setFilter(f);
		fc.setClassifier(c);
		return fc;
	}

	public AttributeSelectedClassifier getUnivariateAttributeSelectedClassifier(Classifier baseClassifier) {
		AttributeSelectedClassifier attributeSelectionClassifier = new AttributeSelectedClassifier();
		//wrap the classifier
		attributeSelectionClassifier.setClassifier(baseClassifier);
		//univariate information gain based feature evaluation
		InfoGainAttributeEval evaluator = new InfoGainAttributeEval();
		//rank the features
		Ranker ranker = new Ranker();
		//set the threshold to be 0, less than that is rejected
		ranker.setThreshold(0.0);
		attributeSelectionClassifier.setEvaluator(evaluator);
		attributeSelectionClassifier.setSearch(ranker);
		return attributeSelectionClassifier;
	}

	public Classifier getNaiveBayes() {
		// create a bayesian classifier
		NaiveBayes naiveBayes = new NaiveBayes();
		// use supervised discretization
		naiveBayes.setUseSupervisedDiscretization(true);
		return naiveBayes;
	}
	
	public Classifier getLinearRegression(){
		//create a meta classifier to wrap regression
		ClassificationViaRegression c = new ClassificationViaRegression();
		//linear regression
		LinearRegression regression = new LinearRegression();
		//eliminate collinear features
		regression.setEliminateColinearAttributes(true);
		//ridge parameter
		regression.setRidge(1.0e-8);
		c.setClassifier(regression);
		return c;
	}
	
	public Classifier getLogisticRegression(){
		return new Logistic();
	}
	
	public Classifier getDecisionTree(){
		//C4.5 with its pruning 
		J48 decisionTree = new J48();
		decisionTree.setNumFolds(3);
		return decisionTree;
	}
	

	public static void main(String[] args) throws Exception {
		WekaClassificationExperiments experiments = new WekaClassificationExperiments();
		experiments.initDataSets(args[0], args[1]);
		// create a missing value filter
		Filter missingValueReplacements = experiments.getReplaceMissingValuesFilter();
		//get naive bayes
		Classifier naiveBayes = experiments.getNaiveBayes();
		//get linear regression
		Classifier linearRegression = experiments.getLinearRegression();
		//get logistic regression
		Classifier logisticRegression = experiments.getLogisticRegression();
		//create a filtered classifier
		Classifier fc = experiments.getFilteredClassifier(missingValueReplacements, logisticRegression);
		// set fc to attribute selection
		Classifier as = experiments.getUnivariateAttributeSelectedClassifier(fc);
		as.buildClassifier(experiments.trainingData);
		// evaluate classifier and print some statistics
		Evaluation eval = new Evaluation(experiments.trainingData);
		eval.evaluateModel(as, experiments.testingData);
		System.out.println(as.toString());
		System.out.println(eval.toSummaryString());
		
		System.out.println(eval.toMatrixString());
	}

}
