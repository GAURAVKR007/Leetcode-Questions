import java.util.HashMap;
import java.util.Map;

public class CheckIfArrayIsGood {
    public static boolean isGood(int[] nums) {
       HashMap<Integer,Integer> hash = new HashMap<>();
        int highest = 0;

        for(int x : nums){
            if(highest < x){
                highest = x;
            }
            if(hash.containsKey(x)){
                hash.put(x,hash.get(x) + 1);
            }else{
                hash.put(x,1);
            }
        }

        boolean flag = false;
        int size = nums.length > highest ? nums.length + 1 : highest + 1;
        boolean[] arrCheck = new boolean[size];

        for(Map.Entry<Integer,Integer> map : hash.entrySet()){
            int key = map.getKey();
            int value = map.getValue();

            if(key != highest && value > 1){
                return false;
            }

            if(key == highest && value > 1){
                flag = true;
            }

            arrCheck[key] = true;

        }

        for(int i = 1 ; i < size - 1; i++){
            if(arrCheck[i] == false){
                return false;
            }
        }

        return flag;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,3,2};
        System.out.println(isGood(nums));
    }
}
