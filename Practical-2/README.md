# Practical-2
## Directory Structure
  * /main/
    * In.java
    * ThreeSumA.java
    * ThreeSumB.java
  * /assets/
    * 8ints.txt
    * 1Kints.txt
    * 2Kints.txt
    * 4Kints.txt
    * 8Kints.txt
    * 16Kints.txt
    * 32Kints.txt
  * /out/
    * /main/
      * In.class
      * ThreeSumA.class
      * ThreeSumB.class
    * Makefile
  * ALGO\_P2\_ogara18379576.pdf
  * README.md

---
### /main/
This directory is the main java package for all of the code written and used for this practical.
#### IN.java
This java file contains i/o depdendencies provided via the github repo.
#### ThreeSumA.java
This java file contains the less efficient of the algorithm being tested during this practical. The main() method was altered so as to measure and output the running time of the algorithm for the provided input.
#### ThreeSumB.java
This java file contains the more efficient implementation of the algorithm being tested during this practical. The main() method was altered so as to measure and output the running time of the algorithm for the provided input.

---
### /assets/
This directory contains all test files provided for the practical.
### /out/
This directory contains the compiled main package, as well as the Makefile used to streamline testing.
#### /main/
This directory contains all of the compiled java bytecode for the main package.
#### Makefile
This is a simple makefile, used to streamline the testing process. It will systematically test ThreeSumA and ThreeSumB for all input files provided using simple commands ("make ThreeSumA", and "make ThreeSumB" respectively).

---
### ALGO_P2_ogara18379576.pdf
This is a pdf file containing my attempt at all questions for this practical.

---
### README.md
See: this
