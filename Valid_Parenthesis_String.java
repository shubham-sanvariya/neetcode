public class Valid_Parenthesis_String {
    public static void main(String[] args) {
        Valid_Parenthesis_String validParenthesisString = new Valid_Parenthesis_String();
        String s = "()";
        validParenthesisString.checkValidString(s);
    }

    public boolean checkValidString(final String s) {
        int low = 0;  // the lower bound of the number of valid '('s
        int high = 0; // the upper bound of the number of valid '('s

        for (final char c : s.toCharArray()) {
            switch (c) {
                case '(':
                    ++low;
                    ++high;
                    break;
                case ')':
                    low = Math.max(0, --low);
                    --high;
                    break;
                case '*':
                    low = Math.max(0, --low);
                    ++high;
                    break;
            }
            if (high < 0)
                return false;
        }

        System.out.println(low == 0);
        return low == 0;
    }
}
