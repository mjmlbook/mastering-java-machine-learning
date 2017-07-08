# Chapter 5 - Real-time Stream Machine Learning

### Instructions for running experiments with [MOA](https://github.com/Waikato/moa)

1. Download the dataset  [Electricity](http://downloads.sourceforge.net/project/moa-datastream/Datasets/Classification/elecNormNew.arff.zip?r=http%3A%2F%2Fmoa.cms.waikato.ac.nz%2Fdatasets%2F&ts=1483128450&use_mirror=cytranet). It is also availed as a zip archive in the data folder.

2. [Download MOA](https://sourceforge.net/projects/moa-datastream/).

3. Unzip data/elecNormNew.arff.zip
4. Run from command line using, for example:
```sh
java -cp moa.jar -javaagent:sizeofag-1.0.0.jar moa.DoTask  "EvaluatePrequential -l trees.HoeffdingTree -s (ArffFileStream -f (data/elecNormNew.arff)) -e BasicClassificationPerformanceEvaluator -w 5000" > "expts\Prequential\HoeffdingTree-W5000.txt"
```

Note all continuous data values have been normalized to lie between 0 and 1.

The command line options specify all the settings for the experiments.  The file callmoa.bat contains the commands used for each experiment in  a separate line.
