public class LemonadeChange {
    public static boolean lemonadeChange(int[] bills) {
        int[] change = new int[21];

        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                change[bills[i]] += 1;
                continue;
            }

            int returnBill = bills[i] - 5;
            change[bills[i]] += 1;

            for (int j = returnBill; j >= 5; j = j - 5) {
                if (change[j] == 0) {
                    continue;
                }

                if (returnBill == 0) {
                    break;
                }

                if (returnBill >= j && change[j] > 0) {
                    change[j] -= 1;
                    returnBill -= j;
                    j = j + 5;
                }

            }

            if (returnBill != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] bills = { 5, 5, 5, 10, 20 };
        System.out.println(lemonadeChange(bills));
    }
}
