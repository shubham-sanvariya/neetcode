import java.util.HashSet;

public class Longest_Substring_Without_Repeating_Characters {
    public static void main(String[] args) {
        Longest_Substring_Without_Repeating_Characters longestSubstringWithoutRepeatingCharacters =
                new Longest_Substring_Without_Repeating_Characters();
        String str = "dvdf";
        longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(str);
    }

    public int lengthOfLongestSubstring(String s) {

        int[] charIndex = new int[128]; // Assuming ASCII character set
        int left = 0, right = 0;
        int maxLen = 0;

        while (right < s.length()) {
            char r = s.charAt(right);
            int index = charIndex[r];
            left = Math.max(left, index);

            maxLen = Math.max(maxLen, right - left + 1);
            charIndex[r] = right + 1;
            right++;
        }

        return maxLen;

//        int max_len = 0, i = 0, j = 0;
//        int curr = 0;
//        HashSet<Character> set  =new HashSet<>();
//        while (i <= j && j < s.length()){
//            char c = s.charAt(j);
//            if (!set.contains(c)){
//                set.add(c);
//                j++;
//                curr++;
//                max_len = Integer.max(curr,max_len);
//            } else if (i == j) {
//                j++;
//            }
//            else {
//                i++;
//                j = i;
//                curr = 0;
//                set = new HashSet<>();
//            }
//        }
//        System.out.println(max_len);
//        return max_len;
    }
}
