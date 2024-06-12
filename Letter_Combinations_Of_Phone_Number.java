import java.util.ArrayList;
import java.util.List;

public class Letter_Combinations_Of_Phone_Number {
    public static void main(String[] args) {
        String digits = "23";
        Letter_Combinations_Of_Phone_Number letterCombinationsOfPhoneNumber =
                new Letter_Combinations_Of_Phone_Number();
        letterCombinationsOfPhoneNumber.letterCombinations(digits);
    }

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty())
            return new ArrayList<>();

        List<String> ans = new ArrayList<>();

        dfs(digits, 0, new StringBuilder(), ans);
        System.out.println(ans);
        return ans;
    }

    private static final String[] digitToLetters = {"",    "",    "abc",  "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"};

    private void dfs(String digits, int i, StringBuilder sb, List<String> ans) {
        if (i == digits.length()) {
            ans.add(sb.toString());
            return;
        }

        for (final char c : digitToLetters[digits.charAt(i) - '0'].toCharArray()) {
            sb.append(c);
            dfs(digits, i + 1, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
