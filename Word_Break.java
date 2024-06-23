import java.util.List;

public class Word_Break {
    public static void main(String[] args) {
        List<String > list = List.of("leet","code");
        String s = "leetcode";
        Word_Break wordBreak = new Word_Break();
        wordBreak.wordBreak(s,list);
    }

    boolean[] fails;

    public boolean wordBreak(String s, List<String> wordDict) {
        fails = new boolean[s.length()+1];
        return dfs(s, 0, wordDict);
    }

    private boolean dfs(String s,  int index, List<String> wordDict) {
        if (index == s.length()) return true;
        if(fails[index] == true) return false;

        for (String word : wordDict) {
            if (!s.startsWith(word, index)) continue;
            if (fails[index+word.length()]) continue;
            if (dfs(s, index+word.length(), wordDict)) return true;
        }

        fails[index] = true;
        return false;
    }
}
