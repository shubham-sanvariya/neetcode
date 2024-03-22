public class Valid_Palindrome {
    public static void main(String[] args) {
        Valid_Palindrome validPalindrome = new Valid_Palindrome();
        String s = "A man, a plan, a canal: Panama";
        validPalindrome.isPalindrome(s);
    }

    public boolean isPalindrome(String s) {
        if (s.length() <= 1) return true;
        int st = 0, en = s.length()-1;
        while (st < en){
            while (st < en && !Character.isLetterOrDigit(s.charAt(st))) st++;
            while (st < en && !Character.isLetterOrDigit(s.charAt(en))) en--;
            if (st < en && Character.toLowerCase(s.charAt(st)) != Character.toLowerCase(s.charAt(en))) return false;
            st++;
            en--;
        }
        return true;
    }
}
