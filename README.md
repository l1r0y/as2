# My Data Structures

This project provides implementations of several data structures in Java without using the standard libraries `java.util.*`.

## About the Project

This project includes implementations of the following data structures:

- MyArrayList: Implementation of a dynamic array, similar to ArrayList from the Java standard library.
- MyLinkedList: Implementation of a doubly linked list, similar to LinkedList from the Java standard library.

Each of these data structures implements the common interface `MyList`, which provides methods for working with the list.

## Usage

You can use the MyArrayList and MyLinkedList classes just like the standard data structures in Java. Here's an example of usage:

```java
MyList<Integer> list = new MyArrayList<>();
list.add(1);
list.add(2);
list.add(3);

System.out.println("Size of the list: " + list.size()); // Outputs: Size of the list: 3

list.remove(1);
System.out.println("First element after removal: " + list.get(0)); // Outputs: First element after removal: 1
