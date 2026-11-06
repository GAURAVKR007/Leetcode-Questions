import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {

    public static int maxFreq(HashMap<Character, Integer> hash) {
        int maxFreq = 0;
        for (Map.Entry<Character, Integer> map : hash.entrySet()) {
            int value = map.getValue();

            if (value > maxFreq) {
                maxFreq = value;
            }
        }
        return maxFreq;
    };

    public static int characterReplacement(String s, int k) {
        HashMap<Character, Integer> hash = new HashMap<>();

        int maxLength = 0;
        int maxFreq = 0;
        int currLength = 0;
        int left = 0;
        int right = 0;
        int idx = 0;

        while (idx < s.length()) {
            if (hash.containsKey(s.charAt(idx))) {
                hash.put(s.charAt(idx), hash.get(s.charAt(idx)) + 1);
            } else {
                hash.put(s.charAt(idx), 1);
            }

            // Check valid
            currLength = right - left + 1;
            maxFreq = maxFreq(hash);

            if (currLength - maxFreq <= k) {
                maxLength = Math.max(maxLength, currLength);
            } else {
                char ch = s.charAt(left);
                left++;
                hash.put(ch, hash.get(ch) - 1);
                hash.put(s.charAt(idx), hash.get(s.charAt(idx)) - 1);
                continue;
            }

            right++;
            idx++;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String str = "AABABBA";
        int k = 1;
        int longestLength = characterReplacement(str, k);
        System.out.println("Length of the longest substring after replacement: " + longestLength);
    }
}
