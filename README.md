# Red-Black-Tree-20407
An online algorithm for finding the k minimal values of an array based on a Red Black Tree implementation. Was submitted as a final project in the course "Data Structures and Introduction to Algorithms" (20407) at The Open University of Israel.


## Overview
The program implements an online algorithm which gets as an input a n-size array and an integer k and returns a list of the k minimal values in the array in an ascending order.

The program is comprised of an implementation of a Red Black Tree, meant to store k values every time which constitute the k minimal values seen so far.

The Red Black Tree supports insertion in logarithmic runtime and printing the k minimal values in an ascending order at a linear runtime.
The program runs on a single input that can only be modified through the Runner.java file. This file generates a few input arrays to be run by the algorithm. More details about the different inputs can be found in the project definition provided in Hebrew.


## Classes
The program is made of a few classes:

* A **Runner** class, contains the main method which runs the program. The Runner class constructs the arrays which will be the input of the algorithm and handles the operating of the algorithm with different parameters.

* **KMinTree** – The external interface of the K Minimum Tree data structure (Our Red Black Tree with minor upgrades) which offers the insertion action and the sorted print of the minimal values.

* **RBTree** – Implements a Red Black Tree extended with a number of extra data fields, including the maximal value in the tree, the number of the nodes in the tree and the number of nodes that can be stored in the tree. Also implements the insertion method (in logarithmic runtime) and the printing of the k minimal values, and of course all of the maintenance methods needed for a Red Black Tree.

* **Node** – A class implements a node in the tree and contains all of its data fields.
