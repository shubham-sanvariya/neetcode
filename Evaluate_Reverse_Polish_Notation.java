import java.util.Stack;

public class Evaluate_Reverse_Polish_Notation {
    public static void main(String[] args) {
        Evaluate_Reverse_Polish_Notation evaluateReversePolishNotation = new Evaluate_Reverse_Polish_Notation();
        String[] strs = {"2","1","+","3","*"};
        evaluateReversePolishNotation.evalRPN(strs);
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens){
            switch (token.charAt(0)){
                case '+':
                    int sum = stack.pop() + stack.pop();
                    stack.push(sum);
                    break;
                case '*':
                    int prod = stack.pop() * stack.pop();
                    stack.push(prod);
                    break;
                case '/':
                    int denom = stack.pop();
                    int numer = stack.pop();
                    stack.push(numer/denom);
                    break;
                default:
                    if (token.charAt(0) == '-' && token.length() == 1){
                        int right = stack.pop();
                        int left = stack.pop();
                        stack.push(left - right);
                    }
                    else {
                        stack.push(Integer.parseInt(token));
                    }
                    break;
            }
        }
        return stack.pop();
    }
}
