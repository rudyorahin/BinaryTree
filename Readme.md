# DeepFind: Deep File Search in Java

## Description

DeepFind is a Java application designed to find the largest file within a given directory and all its subdirectories. It utilizes recursive algorithms to traverse through the directory structure and identify the file with the maximum size.

## Features

- Finds the largest file within a directory and its subdirectories.
- Utilizes Java's NIO package for efficient file and directory handling.
- Provides a JUnit test suite for validation.
  
![Build Status](https://img.shields.io/badge/build-passing-brightgreen)
![Java](https://img.shields.io/badge/language-Java-orange)
![GitHub license](https://img.shields.io/github/license/mashape/apistatus.svg)


## Setup

To get started, clone the repository to your local machine.

Navigate to the `src/main/java/edu/gcccd/csis` directory to find the source files.

## Usage

Compile and run the `DeepFind.java` file, providing the path of the directory to be searched as an argument.

Compile the code:
```bash
javac DeepFind.java
```
Run the program:
```bash
java DeepFind /path/to/search
```

The application will output the largest file's path and its size.

Running Tests
Navigate to the src/test/java/edu/gcccd/csis directory and run the DeepFindTest.java to validate the extreme file finding algorithm.

License

Copyright © 2023 Rudy Orahin.
Licensed under the MIT License. See LICENSE for more information.

---

Feel free to modify the README to better suit your project. Don't forget to add a `LICENSE` file in your GitHub repository and paste the MIT License text into it, crediting you as the copyright holder.





