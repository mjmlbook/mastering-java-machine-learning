# Chapter 9 - Big Data Machine Learning - The Final Frontier

## CovType dataset
The normalized dataset is available as a zip archive in the *data* directory.

## Tools
Three separate Big Data ML frameworks were introduced in the chapter.
- H20
- Spark MLLib
- SAMOA

### H2O
Download [H20]().

You can run H2O in local mode:
```sh
java –Xmx6g –jar h2o.jar
```
The [Flow GUI](http://192.168.1.7:54321/) should now be accessible in your browser.

### Spark MLlib
The code for the experiments that produced the results presented in the Spark MLLib part of the case study in Chapter 9 can be found in the *expt/src* folder.

### SAMOA
Apache SAMOA can be cloned from [GitHub](https://github.com/apache/incubator-samoa).

The command line to train using Bagging, for example, is:
```sh
bin/samoa local target/SAMOA-Local-0.3.0-SNAPSHOT.jar "PrequentialEvaluation -l classifiers.ensemble.Bagging -s (ArffFileStream -f covtype-train.csv.arff) -f 10000"
```
