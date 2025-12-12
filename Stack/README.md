# Stack
A Stack is a linear data structure that follows the Last-In-First-Out (LIFO) principle. The last element added to the stack is the first one to be removed. Think of it like a stack of plates - you add plates to the top and remove them from the top.

### Key Characteristics

* **LIFO Ordering**: Last In, First Out
* **Single Entry Point**: Elements are added and removed from the same end (top)
* **Dynamic Size**: Can grow and shrink as needed
* **Time Complexity**: O(1) for push, pop, and peek operations

### Core Operations

* **push(element)**: Add an element to the top of the stack
* **pop()**: Remove and return the top element
* **peek()**: View the top element without removing it
* **isEmpty()**: Check if the stack is empty
* **size()**: Get the number of elements in the stack

### Common Use Cases

* Function Call Management: Managing function calls and recursion
* Undo/Redo Functionality: Text editors, graphics software
* Expression Evaluation: Parsing and evaluating mathematical expressions
* Backtracking Algorithms: Maze solving, game AI
* Browser History: Back button functionality
* Syntax Parsing: Compiler design, matching parentheses

### Real-World Applications

* Browser Navigation: Back and forward buttons use stacks
* Text Editors: Undo/redo operations
* Compilers: Syntax checking and expression evaluation
* Memory Management: Call stack in programming languages
* Algorithm Design: DFS traversal, Tower of Hanoi

### Time Complexity
|Operation | Time Complexity |
|-----------|---------------|
| Push | O(1)|
| Pop | O(1) |
| Peek | O(1) |
| Search | O(n) |
| Space | O(n) |
