import java.util.HashSet;

public class ThirdMaxNum {
    public static int thirdMax(int[] nums) {
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        HashSet<Integer> set = new HashSet<>();
        for (int x : nums) {
            set.add(x);
        }
        int idx = 0;
        int[] arr = new int[set.size()];
        for (int x : set) {
            arr[idx++] = x;
        }

        if (arr.length == 2) {
            return Math.max(arr[0], arr[1]);
        }

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= first) {
                third = second;
                second = first;
                first = arr[i];
                continue;
            }

            if (arr[i] >= second) {
                third = second;
                second = arr[i];
                continue;
            }

            if (arr[i] >= third) {
                third = arr[i];
            }
        }

        if (third == Integer.MIN_VALUE && arr[0] != Integer.MIN_VALUE && arr[1] != Integer.MIN_VALUE) {
            if (second == Integer.MIN_VALUE) {
                return first;
            }

            return second;
        }

        return third;
    }

    public static void main(String[] args) {
        // code to test the thirdMax function
        int[] nums1 = { 1, 2147483647, -2147483648 };
        System.out.println(thirdMax(nums1)); // Output: 1
    }
}
