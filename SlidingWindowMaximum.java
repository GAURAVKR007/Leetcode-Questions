import java.util.PriorityQueue;

public class SlidingWindowMaximum {

    // public static int[] maxSlidingWindow(int[] nums, int k) {
    //     Deque<Integer> dq = new LinkedList<>();
    //     int n = nums.length;
    //     int[] res = new int[n - k + 1];
    //     int idx = 0;

    //     for (int i = 0; i < n; i++) {
    //         int num = i - k + 1;
    //         // remove out of window
    //         if (!dq.isEmpty() && dq.peekFirst() < num) {
    //             dq.pollFirst();
    //         }

    //         // remove smaller elements
    //         while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
    //             dq.pollLast();
    //         }

    //         dq.offerLast(i);

    //         // store result
    //         if (i >= k - 1) {
    //             res[idx++] = nums[dq.peekFirst()];
    //         }
    //     }

    //     return res;
    // }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];

        // Max-heap: largest value comes first.
        // Each pair stores {value, index}.
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[0], a[0])
        );

        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{nums[i], i});

            // Remove expired elements from the top.
            while (!pq.isEmpty() && pq.peek()[1] <= i - k) {
                pq.poll();
            }

            // A complete window has formed.
            if (i >= k - 1) {
                res[i - k + 1] = pq.peek()[0];
            }
        }

        return res;

    }

    public static void main(String[] args) {
        int[] nums = { 100, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        int[] result = maxSlidingWindow(nums, k);
        System.out.print("Maximum values in each sliding window: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
