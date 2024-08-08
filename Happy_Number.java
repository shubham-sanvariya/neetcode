public class Happy_Number {
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    public static boolean isHappy(int n) {
        while(n>0){
            int sum = 0;
            while(n>0){
                int i = n % 10;
                n /= 10;
                sum += i*i;

            }
            n = sum;

            switch (n) {
                case 1:
                case 7:
                    return true;
                default:
                    if (n < 9) {
                        return false;
                    }
            }
        }

        return false;
    }
}
