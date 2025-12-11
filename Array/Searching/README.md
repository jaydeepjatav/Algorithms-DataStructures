# Search Algorithms
A **search algorithm** is a method for locating a specific element within a data structure or problem space. The appropriate algorithm depends on the data's organization, such as whether it's sorted, its size, and the specific application.

## Linear Search
Linear search is the simplest search algorithm that checks every element in a collection sequentially until the target element is found or the end is reached.

### How It Works

* Start from the first element
* Compare each element with the target value
* If a match is found, return the index
* If the end is reached without finding the target, return -1 (or indicate not found)

  <p align="center"><img src="https://www.tutorialspoint.com/data_structures_algorithms/images/linear_search.gif" width="500"/></p>


### Time Complexity

* Best Case: O(1) - element found at first position
* Average Case: O(n) - element found somewhere in middle
* Worst Case: O(n) - element at end or not present

### Space Complexity
* O(1) - only requires constant extra space

### Advantages

* Works on unsorted data
* Simple to implement
* No preprocessing required
* Efficient for small datasets

### Disadvantages

* Inefficient for large datasets
* Slower than other search algorithms for sorted data

### Use Cases

* Small datasets (< 100 elements)
* Unsorted collections
* Linked lists (where random access isn't available)
* When simplicity is more important than efficiency

## Binary Search
Binary search is an efficient algorithm for finding an item in a sorted collection by repeatedly dividing the search interval in half.

### How It Works
1. Start with the middle element of the sorted array
2. If the target equals the middle element, return its index
3. If the target is less than the middle element, search the left Sub-Array
4. If the target is greater than the middle element, search the right Sub-Array
5. Repeat until the element is found or the search space is empty

   <p align="center"><img src="https://www.tutorialspoint.com/data_structures_algorithms/images/binary_search_algorithm.jpg" width="800"/></p>


### Time Complexity

* Best Case: O(1) - element found at middle
* Average Case: O(log n)
* Worst Case: O(log n)

### Space Complexity

* Iterative: O(1)
* Recursive: O(log n) - due to call stack

### Advantages

* Very fast for large sorted datasets
* Predictable performance (logarithmic)
* Efficient memory usage (iterative version)

### Disadvantages

* Requires sorted data
* Only works with data structures that support random access
* Preprocessing (sorting) adds overhead if data isn't already sorted

### Use Cases

* Large sorted datasets (databases, arrays)
* Repeated searches on the same dataset
* When search speed is critical
* Dictionary lookups, phone books, sorted lists


## Comparison
| Feature |Linear Search | Binary Search |
|---------|--------------|---------------|
|Data Requirement | Any order |Must be sorted|
|Time Complexity| O(n) |O(log n) |
|Space Complexity |O(1) |O(1)iterative, O(log n) recursive|
|Best For |Small/unsorted data |Large sorted data|
|Implementation |Very simple|Moderate complexity|

### Performance Example
For an array of 1,000,000 elements:

* **Linear Search**: Up to 1,000,000 comparisons
* **Binary Search**: Maximum 20 comparisons (log₂ 1,000,000 ≈ 20)

















