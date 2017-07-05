# Chapter 2 - Practical Approach to Real-world Supervised Learning
## Instructions to run experiment with Weka
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
java org.mml.chapter1.weka.WekaClassificationExperiments ./data/colic-train.arff ./data/colic-test.arff
```
