public class ClosestTarget {
    public static int closestTarget(String[] words, String target, int startIndex) {
        int fromLeft = Integer.MAX_VALUE;
        int fomRight = Integer.MAX_VALUE;
        boolean found = false;
        for (String word : words) {
            if (word.equals(target)) {
                fromLeft = 0;
                fomRight = 0;
                found = true;
                break;
            }
        }

        if (!found) {
            return -1;
        }

        int i = startIndex;
        do {
            if (words[i].equals(target)) {
                break;
            }
            fromLeft++;

            i = (i - 1 + words.length) % words.length; // circular move
        } while (i != startIndex);

        i = startIndex;
        do {
            if (words[i].equals(target)) {
                break;
            }
            fomRight++;

            i = (i + 1) % words.length; // circular move
        } while (i != startIndex);

        int res = Math.min(fromLeft, fomRight);

        return res;
    }

    public static void main(String[] args) {
        String[] words = { "a", "b", "leetcode" };
        String target = "leetcode";
        int startIndex = 0;
        int result = closestTarget(words, target, startIndex);
        System.out.println("Result: " + result);
    }
}
