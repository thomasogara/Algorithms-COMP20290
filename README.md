# Thomas O'Gara's Algorithms Portfolio
Algorithms, eh?

## Getting Started
To begin, please `git clone` the repository onto your local machine.

### Prerequisutes
There are a number of prerequisites if you aim to **build and/or run** this project on your local machine.
 
 * A Java Development Kit (JDK) for Java version 8.
 * A bash script interpreter.

##### JDK 
The official Oracle JDK can be found at [oracle.com](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html).
  
**Please ensure that the JDK installed on your system is added to the PATH environment variable.
You must be able to run the 'java' and 'javac' tools from the terminal in order to build and/or run this project.**

##### Bash
Almost all modern terminals will be based on a shell which supports the running of bash scripts. You can test this by simply typing `bash` into the terminal. If there is no output, then bash in installed. Windows releases prior to Windows10 will not support bash scripting out of the box. The recommended alternative shell, for Windows versions prior to Windows10, is the [git bash](https://gitforwindows.org/) shell.

### Installation
Now that you have a JDK installed and available via the terminal, as well as the ability to run bash scripts, you are now ready to install the project from source.
##### Navigation into the root directory
The first step in the installation process is to navigate to the root directory of the repository. This is the folder into which the repository was cloned. For example, if you cloned the repository into your `Documents` folder, then the root directory should be at `Documents/algorithm-portfolio-20290-thomasogara`

To navigate to the root directory, the `cd` command can be used on all systems. On a *nix system, the process might be something like the example below.

        example@arch:~$ pwd
        /home/example
        example@arch:~$ cd Documents
        example@arch:~/Documents:$ cd algorithm-portfolio-20290-thomasogara
        example@arch:~/Documents/algorithm-portfolio-20290-thomasogara$ 

On a Windows system, the process might be something similar to the example below.

        C:\Users\example> cd
        C:\Users\example
        C:\Users\example> cd Documents
        C:\Users\example\Documents> cd algorithm-portfolio-20290-thomasogara
        C:\Users\example\Documents\algorithm-portfolio-20290-thomasogara> 

##### Building the project from source
With the terminal session now runnning from within the root directory of the repository, the next step is running the included installation scripts, in order to get the project up and running on your system. To do this, simple run the `bash install` command from the terminal.

In a *nux terminal:

        example@arch:~/Documents/algorithm-portfolio-20290-thomasogara$ bash install

In a Windows terminal:

        C:\Users\example\Documents\algorithm-portfolio-20290-thomasogara> bash install

After running this command, the `/out/` directory will be populated with the compiled Java class files from each of the Practical sessions. Each of the Practical sessions has its code. The build process is now complete.

### Executing the Project code
##### Launching the run script
Now that you have build the project locally, you can execute the project code. To do this, simply type `bash run` into the terminal.

On a *nix terminal:

        example@arch:~/Documents/algorithm-portfolio-20290-thomasogara$ bash run
        
On a Windows terminal:

        C:\Users\example\Documents\algorithm-portfolio-20290-thomasogara> bash run
        
This will execute a script which begins executing the project code. If all goes well, you will be greeted by the message "Hello and welcome to my algorithms portfolio!" THis message indicates build and execution success.

##### Navigating through the program
Once the program has begun execution, it will invite you to choose which Practical session you would like to inspect the code for. You can enter any number between 1 and 8 to run the code associated with the relevant Practical session. Once a practical's code has been executed, the program will invite you to continue testing the code of other Practical sessions. Once finished, enter 'N', when prompted by the program, and the program will quit.


         