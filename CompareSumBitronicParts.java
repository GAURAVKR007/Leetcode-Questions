public class CompareSumBitronicParts {
    public static int compareBitonicSums(int[] nums) {
        int peak = -1;
        int peakIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (peak < nums[i]) {
                peak = nums[i];
                peakIndex = i;
            }
        }

        int ascSum = 0;
        int decSum = 0;
        int lastPeak = nums[peakIndex];

        for (int i = peakIndex; i >= 0; i--) {
            if (nums[i] > lastPeak) {
                break;
            }
            lastPeak = nums[i];
            ascSum = ascSum + nums[i];
        }

        lastPeak = nums[peakIndex];

        for (int i = peakIndex; i < nums.length; i++) {
            if (nums[i] > lastPeak) {
                break;
            }

            lastPeak = nums[i];
            decSum = decSum + nums[i];
        }

        if (ascSum == decSum) {
            return -1;
        }

        int res = ascSum > decSum ? 0 : 1;

        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 30494606, 875031872, 850559628, 844602130 };
        int result = compareBitonicSums(nums);
        System.out.println("Result: " + result);
    }
}
