# Chapter 2 - Practical Approach to Real-world Supervised Learning

## HorseColic data files

The data files for train and test are available from https://archive.ics.uci.edu/ml/machine-learning-databases/horse-colic/.

For the RapidMiner experiments, the files were converted to comma-separated CSV data files prior to loading.
```sh
horse-colic.train.csv
horse-colic.test.csv
```

## Instructions for running experiments with Weka
1. Install Weka 3.8
2. Create the following dependency to Weka:
```xml
<?xml version="1.0" encoding="UTF-8"?>
<classpath>
	<classpathentry kind="src" path="src"/>
	<classpathentry kind="con" path="org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/JavaSE-1.7"/>
	<classpathentry combineaccessrules="false" kind="src" path="/weka-3-8-0"/>
	<classpathentry kind="lib" path="/weka-3-8-0/weka.jar"/>
	<classpathentry combineaccessrules="false" kind="src" path="/Smile"/>
	<classpathentry kind="output" path="bin"/>
</classpath>
```
3. Run code with:
```sh
java org.mml.chapter1.weka.WekaClassificationExperiments ./data/horse-colic.train.csv ./data/horse-colic.test.csv
```

## Instructions for running experiments in RapidMiner
### Initial setup
1. Download __RapidMiner Studio__ *version 7.2* or later.
2. Create a blank *New Process*.
3. Create a local repository on your file system.
4. Add data - locate train and test data files.
    1. Select *Replace errors with missing values* in the __Format your columns__ dialog.
    2. Store the data in a sub-directory of your RapidMiner repository.
5. *Import process* from expt directory.
6. Make sure the *repository entry* parameter of the __Retrieve__ operator is correctly set to the training data file.
