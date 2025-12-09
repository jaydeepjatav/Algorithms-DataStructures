# Linked List
<p>A linked list is a linear data structure where elements are stored in nodes. Each node contains a data field and a reference (link) to the next node in the sequence. Unlike arrays, linked list elements are not stored in contiguous memory locations.</p>

### Key Characteristics
* Dynamic size allocation
* Efficient insertion and deletion operations
* Sequential access to elements
* No memory wastage (allocates memory as needed)

## Types of Linked Lists
#### 1. Singly Linked List
Each node contains data and a pointer to the next node.
```text
[Data|Next] -> [Data|Next] -> [Data|Next] -> NULL
```
#### 2. Doubly Linked List
Each node contains data, a pointer to the next node, and a pointer to the previous node.
```text
NULL <- [Prev|Data|Next] <-> [Prev|Data|Next] <-> [Prev|Data|Next] -> NULL
```
#### 3. Circular Linked List
The last node points back to the first node, forming a circle.
```text
[Data|Next] -> [Data|Next] -> [Data|Next] -> (back to first node)
```

## Operations
#### Basic Operations
* **Insertion** : Add a new node at the beginning, end, or at a specific position
* **Deletion** :Remove a node from the beginning, end, or a specific position
* **Traversal**: Visit each node in the list
* **Search**: Find a node with a given value
* **Update** : Modify the data in an existing node

#### Advanced Operations

* Reverse the linked list
* Detect and remove cycles
* Find the middle element
* Merge two sorted linked lists
* Clone a linked list with random pointers

## Implementation
Node class representing each element in the linked list
```java
class Node {
    int data;
    Node next;
    
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
```

Insert a node at the beginning
```java
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        System.out.println("Inserted " + data + " at beginning");
    }
```

Insert a node at the end
```java
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        
        if (head == null) {
            head = newNode;
            System.out.println("Inserted " + data + " at end");
            return;
        }
        
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        System.out.println("Inserted " + data + " at end");
    }
```
Insert a node at a specific position (0-indexed)
```java
    public void insertAtPosition(int data, int position) {
        if (position < 0) {
            System.out.println("Invalid position");
            return;
        }
        
        Node newNode = new Node(data);
        
        if (position == 0) {
            newNode.next = head;
            head = newNode;
            System.out.println("Inserted " + data + " at position " + position);
            return;
        }
        
        Node current = head;
        for (int i = 0; i < position - 1 && current != null; i++) {
            current = current.next;
        }
        
        if (current == null) {
            System.out.println("Position out of bounds");
            return;
        }
        
        newNode.next = current.next;
        current.next = newNode;
        System.out.println("Inserted " + data + " at position " + position);
    }
```

Delete a node with specific value
```java
    public void deleteByValue(int key) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        
        // If head node contains the key
        if (head.data == key) {
            head = head.next;
            System.out.println("Deleted " + key);
            return;
        }
        
        Node current = head;
        Node prev = null;
        
        while (current != null && current.data != key) {
            prev = current;
            current = current.next;
        }
        
        if (current == null) {
            System.out.println("Element " + key + " not found");
            return;
        }
        
        prev.next = current.next;
        System.out.println("Deleted " + key);
    }
```

Delete node at a specific position (0-indexed)
```java
    public void deleteAtPosition(int position) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        
        if (position == 0) {
            head = head.next;
            System.out.println("Deleted node at position " + position);
            return;
        }
        
        Node current = head;
        for (int i = 0; i < position - 1 && current != null; i++) {
            current = current.next;
        }
        
        if (current == null || current.next == null) {
            System.out.println("Position out of bounds");
            return;
        }
        
        current.next = current.next.next;
        System.out.println("Deleted node at position " + position);
    }
```
    
Search for a value in the list
```java
    public boolean search(int key) {
        Node current = head;
        while (current != null) {
            if (current.data == key) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    // Get the length of the linked list
    public int length() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
```

Display the linked list
```java
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        
        Node current = head;
        System.out.print("Linked List: ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("NULL");
    }
```
    
Reverse the linked list
```java
    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;
        
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        System.out.println("List reversed");
    }
```

Find the middle element
```java
    public Integer findMiddle() {
        if (head == null) {
            return null;
        }
        
        Node slow = head;
        Node fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow.data;
    }
```

Detect if there's a cycle in the linked list
```java
    public boolean detectCycle() {
        if (head == null) {
            return false;
        }
        
        Node slow = head;
        Node fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                return true;
            }
        }
        
        return false;
    }
```
Remove duplicates from sorted linked list
```java
    public void removeDuplicates() {
        if (head == null) {
            return;
        }
        
        Node current = head;
        
        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        System.out.println("Duplicates removed");
    }
```

### Time Complexity 
|Operation |Time Complexity|
|----------|----------------|
|Access | O(n) |
|Search | O(n) |
|Insertion (at beginning)|O(1)|
|Insertion (at end)|O(n)|
|Deletion (at beginning)|O(1)|
|Deletion (at end)|O(n)|

#### Space Complexity: O(n)

### Applications

* Implementation of stacks and queues
* Dynamic memory allocation
* Music playlist management
* Browser history navigation (back/forward)
* Undo functionality in applications
* Image viewer (previous/next image)
* Hash table chaining for collision resolution
* Graph representation using adjacency lists

### Advantages

* Dynamic size management
* Efficient insertion and deletion
* No memory wastage
* Easy implementation of other data structures

### Disadvantages

* No random access to elements
* Extra memory for storing pointers
* Not cache-friendly due to non-contiguous memory
* Reverse traversal is difficult in singly linked lists
