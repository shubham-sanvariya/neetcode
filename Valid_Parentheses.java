import java.util.Stack;

public class Valid_Parentheses {
    public static void main(String[] args) {
        Valid_Parentheses validParentheses = new Valid_Parentheses();
        String s = "()";
        validParentheses.isValid(s);
    }

    public boolean isValid(String s) {
        if(s.length() % 2 != 0)
            return false;

        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray())
        {
            if(c == '(' || c == '{' || c == '[')
                stack.push(c);

            else if(c == ')' && !stack.isEmpty() && stack.peek() == '(')
                stack.pop();
            else if(c == '}' && !stack.isEmpty() && stack.peek() =='{')
                stack.pop();
            else if(c == ']' && !stack.isEmpty() && stack.peek() =='[')
                stack.pop();
            else return false;
        }
        return stack.isEmpty();
    }
}
