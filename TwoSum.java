import java.util.HashMap;
import java.util.Map;

class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
    
        int res[] = new int[2];
        
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }

        for (Map.Entry<Integer,Integer> mapElement : map.entrySet()) {
            int number = target - mapElement.getKey();

            if(map.containsKey(number)){
                res[0] = mapElement.getValue();
                res[1] = map.get(number);
                break;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }
}