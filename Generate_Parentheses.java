import java.util.ArrayList;
import java.util.List;

public class Generate_Parentheses {
    public static void main(String[] args) {
        Generate_Parentheses generateParentheses = new Generate_Parentheses();
        generateParentheses.generateParenthesis(3);
    }

    List<String> res = new ArrayList<>();

    public void recurse(int n, int left, int right, StringBuilder sb) {
        if(left == n && right == n) {
            res.add(sb.toString());
            return;
        }

        if(n > left){
            sb.append("(");
            recurse(n, left+1, right, sb);
            sb.deleteCharAt(sb.length()-1);
        }

        if(left > right){
            sb.append(")");
            recurse(n, left, right+1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public List<String> generateParenthesis(int n) {
        recurse(n, 0, 0, new StringBuilder());
        System.out.println(res);
        return res;
    }


}
