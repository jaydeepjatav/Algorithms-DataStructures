# Array
An array is a fundamental data structure that stores a collection of similar data items (elements) of the same type in contiguous (next to each other) memory locations, allowing efficient access and manipulation using an index, which typically starts at 0.<br>
### Key Characteristics
* Fixed Size: Size is defined at creation (in static arrays)
* Contiguous Memory: Elements stored in adjacent memory locations
* Index-Based Access: O(1) time to access any element
* Homogeneous: All elements are of the same data type
* Zero-Indexed: First element is at index 0 (in most languages)

  ## 📁 Repository Structure

  ```text
  array-dsa/
      ├── 01-basics/
      │   ├── array-declaration.cpp
      │   ├── array-traversal.cpp
      │   └── README.md
      ├── 02-searching/
      │   ├── linear-search.cpp
      │   ├── binary-search.cpp
      │   └── README.md
      ├── 03-sorting/
      │   ├── bubble-sort.java
      |   ├── Selection-sort.java
      |   ├── Insertion-sort.java 
      │   ├── merge-sort.java
      │   ├── quick-sort.java
      |   ├── Heap-sort.java
      │   └── README.md
      ├── 04-manipulation/
      │   ├── array-rotation.cpp
      │   ├── array-reversal.cpp
      │   └── README.md
      ├── 05-patterns/
      │   ├── two-pointers.cpp
      │   ├── sliding-window.cpp
      │   ├── prefix-sum.cpp
      │   └── README.md
      ├── 06-problems/
      │   ├── easy/
      │   ├── medium/
      │   ├── hard/
      │   └── README.md
      ├── 07-2d-arrays/
      │   ├── matrix-operations.cpp
      │   ├── spiral-matrix.cpp
      │   └── README.md
      └── README.md
  ```

### Types of Arrays

1. One-Dimensional Arrays: Linear sequence of elements
2. Multi-Dimensional Arrays: Arrays of arrays (2D, 3D, etc.)
3. Dynamic Arrays: Resizable arrays (ArrayList, Vector, etc.)

### ⚙️ Array Operations
| Operation| Description| Time Complexity|
|-----------|------------|----------------|
|AccessGet | element at index |O(1) |
|SearchFind | element in array | O(n)|
|InsertAdd | element at position| O(n)|
|DeleteRemove| element|O(n)|
UpdateModify| element at index|O(1)|
|TraverseVisit| all elements|O(n)|

## ⏱️ Time & Space Complexity
Understanding complexity is crucial for optimization:<br>
```text 
Best Case    → Ω (Omega)
Average Case → Θ (Theta)
Worst Case   → O (Big-O)
```

### Common Complexities
**O(1)**: Constant - Access by index<br>
**O(log n)**: Logarithmic - Binary search<br>
**O(n)**: Linear - Linear search, traversal<br>
**O(n log n)**: Log-linear - Merge sort, quick sort<br>
**O(n²)**: Quadratic - Bubble sort, nested loops<br>
**O(2ⁿ)**: Exponential - Recursive subset generation<br>
