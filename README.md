# BinarySearchTrees Assignment (CS2720)

**Authors:** Ryan Majd & Maulik Durani  
**Emails:** [rm97798@uga.edu](mailto:rm97798@uga.edu) & [md00211@uga.edu](mailto:md00211@uga.edu)

## Overview

This repository contains the implementation of a Binary Search Tree in Java. The project is part of the CS2720 (Data Structures) course, taught by Dr. Jin Lu.
### UML Diagram

![UML Diagram of the project's Classes and Objects relevant for interpretation](./resources/umlDiagram.drawio.svg)

## How To Compile

To compile the Java program, you can use the following command:

```bash
java -cp bin src/cs2720/p1/Driver.java resources
```
Additionally, you can also use the provided `compile.sh` script for compilation.
```
./compile.sh
```
Make sure to have the necessary Java environment set up on your machine.

## Available Commands
```The program supports the following commands:
(i) - Insert Item
(d) - Delete Item
(p) - Print Tree
(r) - Retrieve Item
(l) - Count Leaf Nodes
(s) - Find Single Parents
(c) - Find Cousins
(q) - Quit program
```
## Contributions
Ryan Majd: Implemented recursive methods, insertion, deletion, `Driver.java`, UML Diagram, `readme.md` search.

Maulik Durani: Implemented the Binary Search Tree structure, initial structure of insertion, Get Single Parents, Get Cousins, and Num Leaf Nodes.




## Pseudocode
```
Since all of the functions modify/traverse a binary search tree, the recurrence relation is similar for all three functions. The recurrence relation is T(n) = T(n / 2) + 1. The time complexity of all functions is O(logn).
```
``` getNumLeafNodes(NodeType<T> node)
    if node == null return 0
    if node.left and node.right == null return 1
    return getNumLeafNodes(node.left) + getNumLeafNodes(node.right)

```
``` getSingleParent(NodeType<T> node)
    if node == null return "" (since there is node, there is no child node)
    if node.left != null and node.right == null (and vice versa) return a string that contains the value of the node
    recursively search down both left and right sub trees
    return the string containing all the values of the nodes that are a single parent
```
``` getCousins(T item)
    if node is found
        getCousins() -> a recursive function
    else
        print ""
```
