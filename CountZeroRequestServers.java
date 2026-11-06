import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CountZeroRequestServers {
    public static int[] countServers(int n, int[][] logs, int x, int[] queries) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();

        for(int[] server : logs){
            if(map.containsKey(server[0])){
                List<Integer> currList = map.get(server[0]);
                currList.add(server[1]);
                map.put(server[0],currList);
            }else{
                List<Integer> currList = new ArrayList<>();
                currList.add(server[1]);
                map.put(server[0],currList);
            }
        }

        List<List<Integer>> serverTimings = new ArrayList<>();

        for(int i=1;i<=n;i++){
            if(map.containsKey(i)){
                serverTimings.add(map.get(i));
            }else{
                serverTimings.add(Arrays.asList(-1));
            }
        }

        int[] res = new int[queries.length];

        for(int i=0;i<queries.length;i++){
            int minRange = queries[i] - x;
            int maxRange = queries[i];

            int currCount = 0;
            for(List<Integer> list : serverTimings){
                boolean flag = true;
                for(int num : list){
                    if(num >= minRange && num <= maxRange){
                        flag = false;
                        break;
                    }
                }

                if(flag){
                    currCount++;
                }
            }

            res[i] = currCount;

        }

        return res;
    }
    public static void main(String[] args) {
        // Example usage
        int n = 3;
        int[][] logs = {{1, 3}, {2, 6}, {1, 5}};
        int x = 5;  
        int[] queries = {10,11};
        int[] result = countServers(n, logs, x, queries);
        System.out.println(Arrays.toString(result));
    }
}
