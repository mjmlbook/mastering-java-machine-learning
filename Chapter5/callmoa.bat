::call java -cp moa.jar -javaagent:sizeofag-1.0.0.jar moa.DoTask  "EvaluatePrequential -l trees.HoeffdingTree -s (ArffFileStream -f (data\elecNormNew.arff)) -e BasicClassificationPerformanceEvaluator" > "expt\prequential\HoeffdingTree-W1000.txt"

::call java -cp moa.jar -javaagent:sizeofag-1.0.0.jar moa.DoTask  "EvaluatePrequential -l trees.HoeffdingTree -s (ArffFileStream -f (data\elecNormNew.arff)) -e BasicClassificationPerformanceEvaluator -w 5000" > "expt\prequential\HoeffdingTree-W5000.txt"

::call java -cp moa.jar -javaagent:sizeofag-1.0.0.jar moa.DoTask  "EvaluatePrequential -l trees.HoeffdingTree -s (ArffFileStream -f (data\elecNormNew.arff)) -e BasicClassificationPerformanceEvaluator -w 100" > "expt\prequential\HoeffdingTree-W100.txt"

::call java -cp moa.jar -javaagent:sizeofag-1.0.0.jar moa.DoTask  "EvaluatePrequential -l trees.HoeffdingTree -s (ArffFileStream -f (data\elecNormNew.arff)) -e BasicClassificationPerformanceEvaluator -w 500" > "expt\prequential\HoeffdingTree-W500.txt"

::call java -cp moa.jar -javaagent:sizeofag-1.0.0.jar moa.DoTask  "EvaluatePrequential -l (meta.OzaBag -l bayes.NaiveBayes) -s (ArffFileStream -f (data\elecNormNew.arff)) -e BasicClassificationPerformanceEvaluator -w 5000" > "expt\prequential\OzaBag-NaiveBayes-W5000.txt"

::call java -cp moa.jar -javaagent:sizeofag-1.0.0.jar moa.DoTask  "EvaluatePrequential -l (meta.OzaBag -l bayes.NaiveBayes) -s (ArffFileStream -f (data\elecNormNew.arff)) -e BasicClassificationPerformanceEvaluator -w 1000" > "expt\prequential\OzaBag-NaiveBayes-W1000.txt"

::call java -cp moa.jar -javaagent:sizeofag-1.0.0.jar moa.DoTask  "EvaluatePrequential -l (meta.OzaBag -l bayes.NaiveBayes) -s (ArffFileStream -f (data\elecNormNew.arff)) -e BasicClassificationPerformanceEvaluator -w 500" > "expt\prequential\OzaBag-NaiveBayes-W500.txt"

::call java -cp moa.jar -javaagent:sizeofag-1.0.0.jar moa.DoTask  "EvaluatePrequential -l (meta.OzaBag -l bayes.NaiveBayes) -s (ArffFileStream -f (data\elecNormNew.arff)) -e BasicClassificationPerformanceEvaluator -w 100" > "expt\prequential\OzaBag-NaiveBayes-W100.txt"

::call java -cp moa.jar -javaagent:sizeofag-1.0.0.jar moa.DoTask  "EvaluatePrequential -l meta.OzaBagAdwin -s (ArffFileStream -f (data\elecNormNew.arff)) -e AdwinClassificationPerformanceEvaluator -w 5000" > "expt\prequential\OzaBagAdwin-HoeffdingTree-W5000.txt"

::call java -cp moa.jar -javaagent:sizeofag-1.0.0.jar moa.DoTask  "EvaluatePrequential -l meta.OzaBagAdwin -s (ArffFileStream -f (data\elecNormNew.arff)) -e AdwinClassificationPerformanceEvaluator -w 1000" > "expt\prequential\OzaBagAdwin-HoeffdingTree-W1000.txt"

::call java -cp moa.jar -javaagent:sizeofag-1.0.0.jar moa.DoTask  "EvaluatePrequential -l meta.OzaBagAdwin -s (ArffFileStream -f (data\elecNormNew.arff)) -e AdwinClassificationPerformanceEvaluator -w 500" > "expt\prequential\OzaBagAdwin-HoeffdingTree-W500.txt"

::call java -cp moa.jar -javaagent:sizeofag-1.0.0.jar moa.DoTask  "EvaluatePrequential -l meta.OzaBagAdwin -s (ArffFileStream -f (data\elecNormNew.arff)) -e AdwinClassificationPerformanceEvaluator -w 100" > "expt\prequential\OzaBagAdwin-HoeffdingTree-W100.txt"

::call java -cp moa.jar -javaagent:sizeofag-1.0.0.jar moa.DoTask  "EvaluatePrequential -l trees.HoeffdingAdaptiveTree -s (ArffFileStream -f (data\elecNormNew.arff)) -e AdwinClassificationPerformanceEvaluator -w 5000" > "expt\prequential\HoeffdingAdaptiveTree-W5000.txt"

::call java -cp moa.jar -javaagent:sizeofag-1.0.0.jar moa.DoTask  "EvaluatePrequential -l trees.HoeffdingAdaptiveTree -s (ArffFileStream -f (data\elecNormNew.arff)) -e AdwinClassificationPerformanceEvaluator -w 1000" > "expt\prequential\HoeffdingAdaptiveTree-W1000.txt"

::call java -cp moa.jar -javaagent:sizeofag-1.0.0.jar moa.DoTask  "EvaluatePrequential -l trees.HoeffdingAdaptiveTree -s (ArffFileStream -f (data\elecNormNew.arff)) -e AdwinClassificationPerformanceEvaluator -w 500" > "expt\prequential\HoeffdingAdaptiveTree-W500.txt"

::call java -cp moa.jar -javaagent:sizeofag-1.0.0.jar moa.DoTask  "EvaluatePrequential -l trees.HoeffdingAdaptiveTree -s (ArffFileStream -f (data\elecNormNew.arff)) -e AdwinClassificationPerformanceEvaluator -w 100" > "expt\prequential\HoeffdingAdaptiveTree-W100.txt"

::call java -cp moa.jar -javaagent:sizeofag-1.0.0.jar moa.DoTask  "EvaluatePrequential -l meta.OzaBagAdwin -s (ArffFileStream -f (data\elecNormNew.arff)) -e BasicClassificationPerformanceEvaluator -w 5000" > "expt\prequential\OzaBagAdwin-HoeffdingTree-W5000.txt"

::call java -cp moa.jar -javaagent:sizeofag-1.0.0.jar moa.DoTask  "EvaluatePrequential -l meta.OzaBagAdwin -s (ArffFileStream -f (data\elecNormNew.arff)) -e BasicClassificationPerformanceEvaluator -w 1000" > "expt\prequential\OzaBagAdwin-HoeffdingTree-W1000.txt"

::call java -cp moa.jar -javaagent:sizeofag-1.0.0.jar moa.DoTask  "EvaluatePrequential -l meta.OzaBagAdwin -s (ArffFileStream -f (data\elecNormNew.arff)) -e BasicClassificationPerformanceEvaluator -w 500" > "expt\prequential\OzaBagAdwin-HoeffdingTree-W500.txt"

::call java -cp moa.jar -javaagent:sizeofag-1.0.0.jar moa.DoTask  "EvaluatePrequential -l meta.OzaBagAdwin -s (ArffFileStream -f (data\elecNormNew.arff)) -e BasicClassificationPerformanceEvaluator -w 100" > "expt\prequential\OzaBagAdwin-HoeffdingTree-W100.txt"

::call java -cp moa.jar -javaagent:sizeofag-1.0.0.jar moa.DoTask  "EvaluatePrequential -l trees.HoeffdingAdaptiveTree -s (ArffFileStream -f (data\elecNormNew.arff)) -e BasicClassificationPerformanceEvaluator -w 5000" > "expt\prequential\HoeffdingAdaptiveTree-W5000.txt"

::call java -cp moa.jar -javaagent:sizeofag-1.0.0.jar moa.DoTask  "EvaluatePrequential -l trees.HoeffdingAdaptiveTree -s (ArffFileStream -f (data\elecNormNew.arff)) -e BasicClassificationPerformanceEvaluator -w 1000" > "expt\prequential\HoeffdingAdaptiveTree-W1000.txt"

::call java -cp moa.jar -javaagent:sizeofag-1.0.0.jar moa.DoTask  "EvaluatePrequential -l trees.HoeffdingAdaptiveTree -s (ArffFileStream -f (data\elecNormNew.arff)) -e BasicClassificationPerformanceEvaluator -w 500" > "expt\prequential\HoeffdingAdaptiveTree-W500.txt"

::call java -cp moa.jar -javaagent:sizeofag-1.0.0.jar moa.DoTask  "EvaluatePrequential -l trees.HoeffdingAdaptiveTree -s (ArffFileStream -f (data\elecNormNew.arff)) -e BasicClassificationPerformanceEvaluator -w 100" > "expt\prequential\HoeffdingAdaptiveTree-W100.txt"

call java -cp moa.jar -javaagent:sizeofag-1.0.0.jar moa.DoTask  "EvaluatePrequential -l (meta.LeveragingBag -l bayes.NaiveBayes) -s (ArffFileStream -f (data\elecNormNew.arff)) -e BasicClassificationPerformanceEvaluator -w 5000" > "expt\prequential\LB-NaiveBayes-W5000.txt"

call java -cp moa.jar -javaagent:sizeofag-1.0.0.jar moa.DoTask  "EvaluatePrequential -l (meta.LeveragingBag -l bayes.NaiveBayes) -s (ArffFileStream -f (data\elecNormNew.arff)) -e BasicClassificationPerformanceEvaluator -w 1000" > "expt\prequential\LB-NaiveBayes-W1000.txt"

call java -cp moa.jar -javaagent:sizeofag-1.0.0.jar moa.DoTask  "EvaluatePrequential -l (meta.LeveragingBag -l bayes.NaiveBayes) -s (ArffFileStream -f (data\elecNormNew.arff)) -e BasicClassificationPerformanceEvaluator -w 500" > "expt\prequential\LB-NaiveBayes-W500.txt"

call java -cp moa.jar -javaagent:sizeofag-1.0.0.jar moa.DoTask  "EvaluatePrequential -l (meta.LeveragingBag -l bayes.NaiveBayes) -s (ArffFileStream -f (data\elecNormNew.arff)) -e BasicClassificationPerformanceEvaluator -w 100" > "expt\prequential\LB-NaiveBayes-W100.txt"

call java -cp moa.jar -javaagent:sizeofag-1.0.0.jar moa.DoTask  "EvaluatePrequential -l (meta.LeveragingBag -l functions.SGD) -s (ArffFileStream -f (data\elecNormNew.arff)) -e BasicClassificationPerformanceEvaluator -w 5000" > "expt\prequential\LB-SGD-W5000.txt"

call java -cp moa.jar -javaagent:sizeofag-1.0.0.jar moa.DoTask  "EvaluatePrequential -l (meta.LeveragingBag -l functions.SGD) -s (ArffFileStream -f (data\elecNormNew.arff)) -e BasicClassificationPerformanceEvaluator -w 1000" > "expt\prequential\LB-SGD-W1000.txt"

call java -cp moa.jar -javaagent:sizeofag-1.0.0.jar moa.DoTask  "EvaluatePrequential -l (meta.LeveragingBag -l functions.SGD) -s (ArffFileStream -f (data\elecNormNew.arff)) -e BasicClassificationPerformanceEvaluator -w 500" > "expt\prequential\LB-SGD-W500.txt"

call java -cp moa.jar -javaagent:sizeofag-1.0.0.jar moa.DoTask  "EvaluatePrequential -l (meta.LeveragingBag -l functions.SGD) -s (ArffFileStream -f (data\elecNormNew.arff)) -e BasicClassificationPerformanceEvaluator -w 100" > "expt\prequential\LB-SGD-W100.txt"

