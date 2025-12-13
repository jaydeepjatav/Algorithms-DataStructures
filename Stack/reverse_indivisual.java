import java.util.Stack;

public class reverse_indivisual {

    public static String reverseWords(String str) {
        // Create an empty stack of characters
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        // Push each character of the input string onto the stack
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != ' '){
            stack.push(str.charAt(i));
            }else{
                while (!stack.isEmpty()) {
                    result.append(stack.pop());
                }
                result.append(" ");
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

     public static void main(String[] args) {
        String str = "Human love his mother";
        String reversed = reverseWords(str);
        System.out.println(reversed);
    }
}
