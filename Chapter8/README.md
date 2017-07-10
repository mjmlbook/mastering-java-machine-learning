# Chapter 8 - Text Mining and Natural Language Processing

**Reuters-21578** is the dataset used in the experiments in Chapter 8. A zipped copy is available in the *data* folder.

**KNIME** workflows for performing text mining and NLP are presented in schematics here. Workflows can be assembled by replicating the flows depicted in the screenshots.  

## KNIME Workflow
Once you have installed  **KNIME**, aopen the application and from the File menu, import the KNIME workflow *02_Document_Classification_BIN.knwf*  into the LOCAL KNIME repository.

Normally, you can open the Configure dialog by double-clicking any node, but for that to work for all nodes, you must first make sure the first node, **File  Reader**, is configured with the right location of the ARFF data file.  

![NLP2](expt/FileReader_configure_dialog.png)

After the **File Reader** is configured, you scan execute the workflow upto any node you wish and examine the intermediate outputs of the nodes.  To run any of the classification tasks to completion, you can execute the corresponding **Scorer** node.

In the workflow below, note that the *Transformation* block uses **Binary Term Vector** node.  Only the **Term Filtering** and **Document Vector** nodes need to be re-configured to use __Relative TF Vector__ or __Relative TF Vector with Threshold Filtering__ .


![NLP2](expt/KNIME_Workflow_BitVector.png)

## Configuring Relative TF Vector with Threshold Filtering
The screenshot below shows the nested workflow within the Document Vector unit for configuring __Relative TF Vector with Threshold Filtering__

![NLP2](expt/RelativeTFVectorWithThreshold.png)


## Configuring the Decision Tree Learner
The **X-Partitioner** node is used to configure number of cross-validation samples and sampling method.



![NLP2](expt/DecisionTreeLearner.png)

## Configuring AdaBoost for Training

![NLP2](expt/AdaBoostNaiveBayesTraining.png)


## Configuring AdaBoost for Testing

![NLP2](expt/AdaBoostNaiveBayesTesting.png)


## Configuring the LIBSVM Learner

![NLP2](expt/LIBSVMLearner.png)
