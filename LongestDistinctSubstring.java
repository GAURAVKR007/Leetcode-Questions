import java.util.HashMap;

public class LongestDistinctSubstring {

    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int curr = 0;
        int max = 0;
        int p1 = -1;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) > p1) {
                p1 = map.get(s.charAt(i));
                curr = i - p1;
                map.put(s.charAt(i), i);
                continue;
            }

            curr = i - p1;
            max = Math.max(max, curr);
            map.put(s.charAt(i), i);
        }

        return max;
    }

    public static void main(String[] args) {
        String str = "tmmzuxt";
        int longestLength = lengthOfLongestSubstring(str);
        System.out.println("Length of the longest substring without repeating characters: " + longestLength);
    }
}
