# Thomas O'Gara's Algorithms Portfolio
> Algorithms, eh?

## Getting Started
To begin, please `git clone` the repository onto your local machine.

### Prerequisutes
There are a number of prerequisites if you aim to **build and/or run** this project on your local machine.
 
 * A Java Development Kit (JDK) for Java version 8.
 * A bash script interpreter.

#### JDK 
The official Oracle JDK can be found at [oracle.com](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html).
  
**Please ensure that the JDK installed on your system is added to the PATH environment variable.
You must be able to run the 'java' and 'javac' tools from the terminal in order to build and/or run this project.**

#### Bash
Almost all modern terminals will be based on a shell which supports the running of bash scripts. You can test this by simply typing `bash` into the terminal. If there is no output, then bash in installed. Windows releases prior to Windows10 will not support bash scripting out of the box. The recommended alternative shell, for Windows versions prior to Windows10, is the [git bash](https://gitforwindows.org/) shell.

### Installation
Now that you have a JDK installed and available via the terminal, as well as the ability to run bash scripts, you are now ready to install the project from source.
#### Navigation into the root directory
The first step in the installation process is to navigate to the root directory of the repository. This is the folder into which the repository was cloned. For example, if you cloned the repository into your `Documents` folder, then the root directory should be at `Documents/algorithm-portfolio-20290-thomasogara`

To navigate to the root directory, the `cd` command can be used on all systems. The process might be something like the example below.

    cd Documents/algorithm-portfolio-20290-thomasogara

#### Building the project from source
To build the project from source, run the following command from the terminal:

    bash install

The build process is now complete. Each of the Practical sessions has its code stored in a package with the name Practical_\<Week No.\>, within the root org.algorithms.thomasogara package.

## Deployment
To begin, please ensure you have navigated into the root directory of the repository. For more information on this process, see the [navigation into the root directory](#Navigation-into-the-root-directory) section.
### Running the program locally
#### Launching the run script
To launch the run script, simply type the following command into the terminal.
    
    bash run
    
This will execute a script which begins executing the project code. If all goes well, you will be greeted by the message "Hello and welcome to my algorithms portfolio!" This message indicates execution success.

#### Navigating through the program
Once the program has begun execution, it will invite you to choose which Practical session you would like to inspect the code for. All of the instructions for using the program are self-contained within the program. Once you have chosen a Practical session to test the code for, depending on the format of the practical, an example usage of the practical code will be output to the screen.