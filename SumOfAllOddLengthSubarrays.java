class SumOfAllOddLengthSubarrays {
    public static int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int res = 0;
        int[] prefix = new int[arr.length + 1];

        for (int i = 0; i < arr.length; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }

        for (int len = 1; len <= n; len += 2) {
            for (int i = 0; i + len <= n; i++) {
                res += prefix[i + len] - prefix[i];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 10, 11, 12 };
        System.out.println(sumOddLengthSubarrays(arr));
    }
}