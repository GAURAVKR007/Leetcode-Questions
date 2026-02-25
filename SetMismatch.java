import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SetMismatch {

    public static int[] findErrorNums(int[] nums) {
        int res[] = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int notPresent = 0;

        Arrays.sort(nums);

        for (int i = 1; i <= nums.length; i++) {
            if (map.containsKey(nums[i - 1])) {
                map.put(nums[i - 1], map.get(nums[i - 1]) + 1);
            } else {
                map.put(nums[i - 1], 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 2) {
                res[0] = entry.getKey();
            }
        }

        for (int i = 1; i <= nums.length; i++) {
            if (!map.containsKey(i)) {
                notPresent = i;
                break;
            }
        }

        res[1] = notPresent;

        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 3, 4, 6, 5 };
        int[] result = findErrorNums(nums);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
