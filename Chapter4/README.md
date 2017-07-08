# Chapter 4 - Semi-supervised and Active Learning

## Semi-supervised Learning experiments
All experiments for SSL use the [Wisconsin Breast Cancer Dataset](https://archive.ics.uci.edu/ml/datasets/Breast+Cancer+Wisconsin+(Original).
### JKernelMachines
The example uses TransductiveSVM to train on 10% of the labeled data, treating the remainder as unlabeled data.  Validation, test and evaluation are omitted from the example.
JKernelMachines source has been compiled into the library *jkernelmachines-3.0.jar*.

### KEEL
Download [KEEL software](http://sci2s.ugr.es/keel/download.php).
Using hyperparameters specified in Table 2 of the chapter, try to reproduce the results.

## Active Learning
The dataset used for AL is [Abalone](https://archive.ics.uci.edu/ml/datasets/Abalone).
### JCLAL
Download the software from [SourceForge](https://sourceforge.net/p/jclal/git/ci/master/tree/) or [GitHub](https://github.com/ogreyesp/JCLAL). JCLAL documentation has instructions on installing the software.  For the active learning experiments in the book, the configuration files in these directories were used:
```sh
expt/PoolBased
expt/StreamBased
```
Run the experiments with:
```sh
java -jar jclal-1.1.jar -cfg <config-file>
```
