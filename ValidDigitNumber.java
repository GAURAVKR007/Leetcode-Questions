public class ValidDigitNumber {
    public static boolean validDigit(int n, int x) {
        boolean condition1 = false;

        while(n >=10){
            int last = n % 10;
            
            if(last == x){
                condition1 = true;
            }

            n = n / 10;
        }

        if(n == x || condition1 == false){
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int n = 101;
        int x = 0;
        boolean result = validDigit(n, x);
        System.out.println("Is " + x + " a valid digit in " + n + "? " + result);
    }
}
