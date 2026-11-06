import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MinMovesEqualArray {
    public static int minMoves(int[] nums) {

        if (nums.length == 1) {
            return 0;
        }

        boolean allSame = Arrays.stream(nums).allMatch(x -> x == nums[0]);

        if (allSame) {
            return 0;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int x : nums) {
            queue.add(x);
        }

        int topElement = 0;
        boolean flag = true;
        int[] arr = new int[nums.length];
        int res = 0;
        do {
            flag = true;
            for (int i = 0; i < nums.length; i++) {
                if (i == 0) {
                    topElement = queue.poll();
                    arr[i] = topElement;
                    continue;
                }

                int element = queue.poll();

                if (element != topElement - 1) {
                    flag = false;
                }

                arr[i] = element + 1;
            }
            res++;
            queue.clear();
            for (int i = 0; i < nums.length; i++) {
                queue.add(arr[i]);
            }

        } while (flag == false);

        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1 };
        System.out.println(minMoves(nums)); // Output: 0
    }
}
