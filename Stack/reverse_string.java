import java.util.Stack;

public class reverse_string {

    public static String reverseString(String str) {
        // Create an empty stack of characters
        Stack<Character> stack = new Stack<>();

        // Push each character of the input string onto the stack
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        // Pop each character from the stack and append it to a StringBuilder
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        // Return the reversed string
        return reversed.toString();
    }

    public static void main(String[] args) {
        String originalString = "jaydeep";
        String reversedString = reverseString(originalString);

        System.out.println("Original string: " + originalString);
        System.out.println("Reversed string: " + reversedString);
    }
}
