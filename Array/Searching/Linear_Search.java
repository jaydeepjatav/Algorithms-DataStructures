public class LinearSearch {
    // Method to perform linear search
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // return index if found
            }
        }
        return -1; // return -1 if not found
    }

    // Main method to test
    public static void main(String[] args) {
        int[] arr = {10, 23, 45, 70, 11, 15};
        int target = 70;

        int result = linearSearch(arr, target);

        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found");
        }
    }
}
