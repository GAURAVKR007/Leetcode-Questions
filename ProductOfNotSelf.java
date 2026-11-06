class ProductOfNotSelf {

    public static int[] productExceptSelf(int[] nums) {

        int[] leftPass = new int[nums.length];
        int[] rightPass = new int[nums.length];

        int prevMul = 1;

        // Left pass
        for (int i = 0; i < nums.length; i++) {
            leftPass[i] = prevMul;
            prevMul *= nums[i];
        }

        prevMul = 1;

        // Right pass
        for (int i = nums.length - 1; i >= 0; i--) {
            rightPass[i] = prevMul;
            prevMul *= nums[i];
        }

        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            res[i] = leftPass[i] * rightPass[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        int[] result = productExceptSelf(nums);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}