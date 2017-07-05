# Chapter 3 - Unsupervised Learning

## Instructions for running SMILE experiments

1. Install [SMILE from github](https://github.com/haifengl/smile)
2. Add the MNIST sample file to SMILE at /shell/src/universal/data/classification as mnist-sample.txt 
3. Change the source for  ManifoldDemo, MDSDemo and ProjectionDemo to load the MNIST Datasets (sampled) for visualization and run using the user interface so parameters like K can be changed.
4. Run each visualization. As an example:
```sh
java smile.demo.manifold.LaplacianEigenmapDemo 
```
