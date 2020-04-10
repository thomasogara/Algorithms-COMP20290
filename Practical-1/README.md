# Practical 1
##Directory Structure
  * /main/
    * Main.java
    * RussianPeasant.java
    * Test.java
  * ALGO_P1_ogara18379576.pdf
  * test_out.txt
  * README
###/main/
/main/ is the main java package used to write solutions for this practical. It contains 3 java files.
  * RussianPeasant.java is the file containing the implementation of the Russian Peasant's multiplication algorithm.
  * Main.java is the file containing the driver code for interactively working with the algorithm. It invites the user
    to input 2 integer numbers, and will print the result of multiplying these two numbers, using the Russian Peasant's
    algorithm, to the screen.
  * Test.java is the file containing the driver code for the testing of the algorithm, specifically accuracy and also
    runtime testing. The file will output the results of running the algorithm on a variety of numbers to the file
    test_out.txt (more on this later)
    
###ALGO_P1_ogara18379576.pdf
This is a pdf file, containing my attempt at the questions contained in the worksheet provided for this practical
session.

###test_out.txt
This is simply a text file, containing the runtime figures for the test inputs found in Test.java. Unfortunately,
because the Russian Peasant's algorithm is so simple, it is almost impossible to find a difference between the runtime
of russianPeasant(0, 0) and and russianPeasant(Integer.MAX_VALUE, Integer.MAX_VALUE). This is largely due to the fact
that the Russian Peasant algorithm is logarithmic, running in O(logn) time, where n represents the length of the binary
representation of the greater of a and b. However, most modern systems only support integers of up to 64 bits in
length, meaning the difference between the theoretical max runtime and the theoretical min is negligible on a modern
system, since the runtime is measured in the ten's of nanoseconds.

###README
See: this   