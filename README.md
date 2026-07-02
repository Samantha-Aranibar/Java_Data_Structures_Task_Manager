# Java_Data_Structures_Task_Manager

This project is a Java-based task management demonstration that implements and tests multiple data structures. Each data structure is used to model different task management features such as storing tasks, handling recurring tasks, managing priorities, tracking dependencies, supporting undo actions, and sorting tasks by due date.

## Project Overview

The goal of this project is to practice implementing and using common data structures in Java. The program tests each structure in the console and displays sample task-related operations.

## Data Structures Implemented

- Dynamic Array
- Singly Linked List
- Doubly Linked List
- Circular Linked List
- Graph
- Stack
- Priority Queue
- Binary Search Tree

## Features

- Store task categories using a dynamic array
- Add, delete, and traverse tasks using linked lists
- Manage recurring tasks with a circular linked list
- Represent task dependencies using a graph
- Traverse task dependencies using BFS
- Manage task priority using a priority queue
- Support undo actions using a stack
- Sort tasks by due date using a binary search tree

## Technologies Used

- Java
- Eclipse IDE
- Object-Oriented Programming
- Data Structures
- Java Collections Framework

## Project Structure

```text
Java-Task-Manager-Data-Structures/
│
├── README.md
├── LICENSE
├── .gitignore
│
├── src/
│   └── HM.java
│
├── docs/
│   └── ProjectOutput.jpg
│
└── output/
    └── sample-output.txt
```

## How to Compile

From the root folder, run:

```bash
javac src/HM.java
```

## How to Run

```bash
java -cp src HM
```

## Sample Output

The program tests each data structure and prints the results to the console, including:

- Dynamic array contents
- Singly linked list traversal
- Doubly linked list traversal
- Circular linked list traversal
- Graph dependency traversal
- Top priority task
- Undo action
- Tasks sorted by due date

A screenshot of the program output is included in the `docs/` folder.

## Skills Demonstrated

- Java programming
- Object-oriented design
- Custom data structures
- Generic classes
- Linked lists
- Graph traversal
- Stack operations
- Priority queues
- Binary search trees
- Console-based testing

## Future Improvements

- Split each data structure into its own Java file
- Add unit tests with JUnit
- Add a menu-based user interface
- Add file saving and loading
- Improve date handling with `LocalDate`
- Build a simple GUI version

## Author

Samantha Aranibar
