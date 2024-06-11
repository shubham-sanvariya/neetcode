import java.util.ArrayList;
import java.util.List;

public class Palindrome_Partitioning {
    public static void main(String[] args) {
        String s = "aab";
        Palindrome_Partitioning palindromePartitioning = new Palindrome_Partitioning();
        palindromePartitioning.partition(s);
    }

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        dfs(0, ans, new ArrayList<String>(), s);
        System.out.println(ans);
        return ans;
    }

    private void dfs(int start, List<List<String>> ans, ArrayList<String> curr, String s)
    {
        if(start >= s.length())
        {
            ans.add(new ArrayList<String>(curr));
            return;
        }

        for(int end = start; end < s.length(); ++end)
        {
            if(isPalindrome(s, start, end))
            {
                curr.add(s.substring(start, end+1));
                dfs(end+1, ans, curr, s);
                curr.remove(curr.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end)
    {
        while(start < end)
        {
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
