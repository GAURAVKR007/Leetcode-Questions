public class PeakAndValleys {
    public static int peakValleyDifference(int[] nums) {
        int peak = 0;
        int valley = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            int start = nums[i];
            int middle = nums[i + 1];
            int end = nums[i + 2];

            if (middle > start && middle > end) {
                peak += middle;
            } else if (middle < start && middle < end) {
                valley += middle;
            }
        }

        return peak - valley;
    }

    public static void main(String[] args) {
        // boiler plate code
        int[] nums = { 1, 5, 2, 4, 1, 3, 0 };
        System.out.println(peakValleyDifference(nums));
    }
}
