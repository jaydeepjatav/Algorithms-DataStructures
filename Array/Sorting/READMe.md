# Sorting Algorithms
Sorting algorithms are fundamental to computer science and are used to arrange elements in a specific order. This repository contains implementations of classic and modern sorting algorithms with detailed explanations, complexity analysis, and visualizations.

### Algorithms Included

#### // ==================== UTILITY METHODS ====================//
```java
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
```
#### Elementary Sorts

* **Bubble Sort** - Simple comparison-based algorithm that repeatedly steps through the list <br>
  ```java
  public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }
  ```
* **Selection Sort** - Divides the list into sorted and unsorted regions, repeatedly selecting the minimum element
  ```java
  public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            swap(arr, i, minIdx);
        }
    }
  ```
* **Insertion Sort** - Builds the final sorted array one item at a time
   ```java
       public static void insertionSort(int[] arr) {
              int n = arr.length;
              for (int i = 1; i < n; i++) {
                  int key = arr[i];
                  int j = i - 1;
                  while (j >= 0 && arr[j] > key) {
                      arr[j + 1] = arr[j];
                      j--;
                  }
                  arr[j + 1] = key;
              }
          }
  ```

#### Efficient Sorts

* **Merge Sort** - Divide-and-conquer algorithm that divides the array into halves
  ```java
      public static void mergeSort(int[] arr) {
        if (arr.length < 2) return;
        mergeSortHelper(arr, 0, arr.length - 1);
    }
    
    private static void mergeSortHelper(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSortHelper(arr, left, mid);
            mergeSortHelper(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
    
    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];
        
        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, mid + 1, rightArr, 0, n2);
        
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
        
        while (i < n1) arr[k++] = leftArr[i++];
        while (j < n2) arr[k++] = rightArr[j++];
    }
  ```
* **Quick Sort** - Efficient divide-and-conquer algorithm using a pivot element
  ```java
  public static void quickSort(int[] arr) {
        quickSortHelper(arr, 0, arr.length - 1);
    }
    
    private static void quickSortHelper(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSortHelper(arr, low, pi - 1);
            quickSortHelper(arr, pi + 1, high);
        }
    }
    
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }
  ```
* **Heap Sort** - Comparison-based algorithm using a binary heap data structure
  ```java
   public static void heapSort(int[] arr) {
        int n = arr.length;
        
        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        
        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }
    
    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }
  ```

#### Specialized Sorts

* **Counting Sort** - Integer sorting algorithm for a specific range
  ```java
  public static void countingSort(int[] arr) {
        if (arr.length == 0) return;
        
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int range = max - min + 1;
        
        int[] count = new int[range];
        int[] output = new int[arr.length];
        
        // Store count of each element
        for (int num : arr) {
            count[num - min]++;
        }
        
        // Change count[i] to actual position
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        
        // Build output array
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }
        
        System.arraycopy(output, 0, arr, 0, arr.length);
    }
  ```
* **Radix Sort** - Non-comparative sorting algorithm for integers
  ```java
   public static void radixSort(int[] arr) {
        if (arr.length == 0) return;
        
        int max = Arrays.stream(arr).max().getAsInt();
        
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(arr, exp);
        }
    }
    
    private static void countingSortByDigit(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];
        
        for (int num : arr) {
            count[(num / exp) % 10]++;
        }
        
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }
        
        System.arraycopy(output, 0, arr, 0, n);
    }
  ```
* **Bucket Sort** - Distributes elements into buckets and sorts them individually
  ```java
   public static void bucketSort(int[] arr) {
        if (arr.length == 0) return;
        
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int bucketCount = arr.length;
        int range = (max - min) / bucketCount + 1;
        
        @SuppressWarnings("unchecked")
        java.util.ArrayList<Integer>[] buckets = new java.util.ArrayList[bucketCount];
        
        for (int i = 0; i < bucketCount; i++) {
            buckets[i] = new java.util.ArrayList<>();
        }
        
        // Distribute elements into buckets
        for (int num : arr) {
            int bucketIndex = (num - min) / range;
            if (bucketIndex >= bucketCount) bucketIndex = bucketCount - 1;
            buckets[bucketIndex].add(num);
        }
        
        // Sort individual buckets and concatenate
        int index = 0;
        for (java.util.ArrayList<Integer> bucket : buckets) {
            java.util.Collections.sort(bucket);
            for (int num : bucket) {
                arr[index++] = num;
            }
        }
    }
  ```
  
### Time Complexity Comparison
| Algorithm | Best Case | Average Case | Worst Case | Space Complexity |
|-----------|------------|--------------|-----------|-------------------|
|Bubble Sort |O(n) |O(n²) |O(n²) |O(1)|
|Selection Sort|O(n²)|O(n²)|O(n²)|O(1)|
|Insertion Sort|O(n)|O(n²)|O(n²)|O(1)|
|Merge Sort|O(n log n)|O(n log n)|O(n log n)|O(n)|
|Quick Sort|O(n log n)|O(n log n)|O(n²)|O(log n)|
|Heap Sort|O(n log n)|O(n log n)|O(n log n)|O(1)|
|Counting Sort|O(n + k)|O(n + k)|O(n + k)|O(k)|
|Radix Sort|O(nk)|O(nk)|O(nk)|O(n + k)|
|Bucket Sort|O(n + k)|O(n + k)|O(n²)|O(n)|
