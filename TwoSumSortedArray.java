public class TwoSumSortedArray {
    public static int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int total = numbers[left] + numbers[right];
            if (total == target) {
                res[0] = left + 1;
                res[1] = right + 1;
                break;
            } else if (total < target) {
                left++;
            } else {
                right--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] numbers = { 3, 24, 50, 79, 88, 150, 345 };
        int target = 200;
        int[] result = twoSum(numbers, target);
        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }
}
