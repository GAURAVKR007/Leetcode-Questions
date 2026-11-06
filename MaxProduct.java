public class MaxProduct {

    public static int maxProduct(int[] nums) {
        int maxProd = Integer.MIN_VALUE;
        int currProd = 1;
        int left = 0;
        int right = 0;

        while (right < nums.length) {
            if (left == right) {
                currProd = nums[left] * 1;
                maxProd = Math.max(currProd, maxProd);
                right++;
                continue;
            }
            currProd = 1;
            for (int j = left; j <= right; j++) {

                currProd = currProd * nums[j];
            }
            if (currProd > maxProd) {
                maxProd = currProd;
                right++;
                continue;
            }

            left++;
        }

        return maxProd;

    }

    public static void main(String[] args) {
        int[] nums = { -2, 3, -4 };
        int maxProduct = maxProduct(nums);
        System.out.println("Maximum product of a contiguous subarray: " + maxProduct);
    }
}
