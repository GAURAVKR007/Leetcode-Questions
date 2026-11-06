import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, Integer> hash = new HashMap<>();
        HashMap<String, Integer> revisit = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            hash.put(wordList.get(i), 1);
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        revisit.put(beginWord, 1);
        int res = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                String currWord = queue.poll();
                if (currWord.equals(endWord)) {
                    return res;
                }

                for (int i = 0; i < currWord.length(); i++) {
                    char[] arr = currWord.toCharArray();
                    char original = arr[i];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == original)
                            continue;

                        arr[i] = ch;
                        String newWord = new String(arr);

                        if (revisit.containsKey(newWord) || !hash.containsKey(newWord)) {
                            continue;
                        }

                        revisit.put(newWord, 1);
                        queue.offer(newWord);
                    }
                }

            }

            res = res + 1;
        }

        return res;

    }

    public static void main(String[] args) {
        WordLadder wl = new WordLadder();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = List.of("hot", "dot", "dog", "lot", "log", "cog");
        int result = wl.ladderLength(beginWord, endWord, wordList);
        System.out.println("Length of the shortest transformation sequence: " + result);
    }
}
