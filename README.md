# Thomas O'Gara's Algorithms Portfolio
Algorithms, eh?

## Getting Started
To begin, please `git clone` the repository onto your local machine.

### Prerequisutes
There are a number of prerequisutes if you aim to **build and/or run** this project on your local machine. The first of those would be a Java Development Kit (JDK) for Java version 8+. The official Oracle JDK can be found at [oracle.com](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html).  

	Please ensure that the JDK installed on your system is added to the PATH environment variable. You must be able to run the java and javac tools from the terminal in order to build and/or run this project.

Another prerequisute is the ability to run bash scripts. Almost all modern terminals will be based on a shell which supports the running of bash scripts. You can test this by simply typing `bash` into the terminal. If there is no output, then bash in installed. Windows releases prior to Windows10 will not support bash scripting out of the box. The recommended alternative shell, for Windows versions prior to Windows10, is the [git bash](https://gitforwindows.org/) shell.

### Installation
Now that you have a JDK installed and available via the terminal, as well as the ability to run bash scripts, you are now ready to install the project from source.
#### Navigation into the root directory
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

#### Building the project from source
With the terminal session now runnning from within the root directory of the repository, the next step is running the included installation scripts, in order to get the project up and running on your system. To do this, simple run the `bash install` command from the terminal.

In a *nux terminal:

	example@arch:~/Documents/algorithm-portfolio-20290-thomasogara$ bash install

In a Windows terminal:

	C:\Users\example\Documents\algorithm-portfolio-20290-thomasogara> bash install

After running this command, the `/out/` directory will be populated with the compiled Java class files from each of the Practical sessions. Each of the Practical sessions has its code