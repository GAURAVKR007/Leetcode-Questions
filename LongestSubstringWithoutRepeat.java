import java.util.HashMap;

public class LongestSubstringWithoutRepeat {
    public static int lengthOfLongestSubstring(String s) {
        char[] ch = s.toCharArray();
        HashMap<Character, Integer> hash = new HashMap<>();
        int res = 0;

        int start = 0;
        int last = 0;
        while (last < ch.length) {
            if (hash.containsKey(ch[last])) {
                while (ch[start] != ch[last]) {
                    hash.remove(ch[start]);
                    start++;
                }

                hash.remove(ch[start]);
                start++;
                continue;
            }

            hash.put(ch[last], 1);
            last++;
            res = Math.max(res, last - start);
        }
        return res;

    }

    public static void main(String[] args) {
        // Code here below to test the lengthOfLongestSubstring method
        String input = "pwwkew";
        int length = lengthOfLongestSubstring(input);
        System.out.println("Length of the longest substring without repeating characters: " + length);
    }
}
