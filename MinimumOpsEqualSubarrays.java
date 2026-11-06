import java.util.Arrays;

public class MinimumOpsEqualSubarrays {
    public static void evaluate(int[] nums, int start, int end, int x, int k, int[] minOps) {
        int[] arr = new int[x];
        int idx = 0;
        for (int i = start; i <= end; i++) {
            arr[idx++] = nums[i];
        }

        Arrays.sort(arr);
        // int lowest = arr[0];
        // int highest = arr[x - 1];

        // int median = (lowest + highest) / 2;

        int median = arr[x / 2];

        int operations = 0;

        for (int i = 0; i < x; i++) {
            if (arr[i] == median) {
                continue;
            }
            if (arr[i] > median) {
                operations += Math.abs(median - arr[i]);
            } else {
                operations += Math.abs(arr[i] - median);
            }
        }

        minOps[start] = operations;
    }

    public static long minOperations(int[] nums, int x, int k) {
        int[] minOps = new int[nums.length - x + 1];
        long res = 0;
        for (int i = 0; i < nums.length - x + 1; i++) {
            int start = i;
            int end = i + x - 1;

            evaluate(nums, start, end, x, k, minOps);
        }

        for (int i = 0; i < k; i++) {
            long min = Integer.MAX_VALUE - i;
            int minPos = -1;
            for (int j = 0; j < minOps.length; j++) {
                if (min > minOps[j]) {
                    min = minOps[j];
                    minPos = j;
                }
            }

            for (int o = minPos; o < (minPos + x); o++) {
                if (o >= minOps.length) {
                    break;
                }
                minOps[o] = Integer.MAX_VALUE;
            }

            for (int o = minPos; o > minPos - x; o--) {
                if (o >= 0) {
                    minOps[o] = Integer.MAX_VALUE;
                }
            }

            res = res + min;
        }

        return res;

    }

    public static void main(String[] args) {
        int[] nums = { -13, 11, 7, -1 };
        int x = 2;
        int k = 2;
        System.out.println(minOperations(nums, x, k));
    }
}
