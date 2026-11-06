import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class PowerBadges {
    public static void main(String[] args) {
        int n = 6; // Example value for n
        int[] arr = { 7, 7, 7, 7, 7, 7 }; // Example array of integers
        HashMap<Integer, Integer> hash = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int num = arr[i];
            if (hash.containsKey(num)) {
                hash.put(num, hash.get(num) + 1);
            } else {
                hash.put(num, 1);
            }
        }

        // Replace Arrays.sort(arr, Collections.reverseOrder()); with this:
        arr = Arrays.stream(arr)
                .boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        int maxCount = 0;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {

            int noOfOccur = hash.get(arr[i]);

            int totalCurrLess = noOfOccur + (arr.length - (i + noOfOccur));

            if (totalCurrLess > maxCount) {
                res = res + noOfOccur;
            }

            i = i + noOfOccur - 1;

            maxCount = maxCount + noOfOccur;

        }

        System.out.println(res);
    }
}
