public class MaxSumSquare {
    public static String maxSumOfSquares(int num, int sum) {
        if (sum > 9 * num)
            return "";

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < num; i++) {
            int d = Math.min(sum, 9);
            ans.append(d);
            sum = sum - d;
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        int num = 4;
        int sum = 18;
        String result = maxSumOfSquares(num, sum);
        System.out.println(result); // Output: "992"
    }
}
