public class MinOperationsWithKLockedIndexies {

    public static int minOperations(int[] nums, int[] locked, int k) {
        int res = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= nums[i - 1]) {
                continue;
            }

            int idx = i;

            while (idx > 0 && nums[idx] < nums[idx - 1]) {
                if (locked[idx] == 1) {
                    if (k == 0) {
                        break;
                    }
                    locked[idx] = 0;
                    res = res + 1;
                    k--;
                }

                if (locked[idx - 1] == 1) {
                    if (k == 0) {
                        break;
                    }
                    locked[idx - 1] = 0;
                    res = res + 1;
                    k--;
                }
                int temp = nums[idx];
                nums[idx] = nums[idx - 1];
                nums[idx - 1] = temp;
                idx--;

                res = res + 1;
            }

        }

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return -1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        // boiler plate code give me
        int[] nums = { 3, 2, 1 };
        int[] locked = { 0, 1, 0 };
        int k = 2;
        System.out.println(minOperations(nums, locked, k));

    }
}
