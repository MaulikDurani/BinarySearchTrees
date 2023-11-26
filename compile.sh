#!/bin/bash

javac -d bin -cp bin src/cs2720/p1/NodeType.java
javac -d bin -cp bin src/cs2720/p1/BinarySearchTree.java
javac -d bin -cp bin src/cs2720/p1/Driver.java
java -cp bin cs2720.p1.Driver
