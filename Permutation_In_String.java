import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutation_In_String {
    public static void main(String[] args) {
        Permutation_In_String permutationInString = new Permutation_In_String();
        String s1 = "hello", s2 = "ooolleoooleh";
        permutationInString.checkInclusion(s1,s2);
    }

    public boolean checkInclusion(String s1, String s2) {

        int[] count = new int[26];
        int required = s1.length();

        for (final char c : s1.toCharArray())
            ++count[c - 'a'];

        for (int l = 0, r = 0; r < s2.length(); ++r) {
            if (--count[s2.charAt(r) - 'a'] >= 0)
                --required;
            while (required == 0) {
                if (r - l + 1 == s1.length())
                    return true;
                if (++count[s2.charAt(l++) - 'a'] > 0)
                    ++required;
            }
        }

        return false;
    }
}
