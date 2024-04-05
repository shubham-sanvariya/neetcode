public class Longest_Repeating_Character_Replacement {
    public static void main(String[] args) {
        String str = "AABABBA";
        Longest_Repeating_Character_Replacement longestRepeatingCharacterReplacement = new Longest_Repeating_Character_Replacement();
        longestRepeatingCharacterReplacement.characterReplacement(str,2);
    }

    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] char_counts = new int[26];

        int window_start = 0, max_length = 0, max_count = 0;

        for (int window_end = 0; window_end < n; window_end++){
            char_counts[s.charAt(window_end) - 'A']++;
            int current_char_count = char_counts[s.charAt(window_end) - 'A'];
            max_count = Math.max(max_count, current_char_count);
//            int sum = window_end - window_start - max_count + 1;
            while (window_end - window_start - max_count + 1  > k){
                char_counts[s.charAt(window_start) - 'A']--;
                window_start++;
            }
            max_length = Math.max(max_length, window_end - window_start + 1);
        }
        return max_length;
    }
}
