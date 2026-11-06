public class MinimumMergerIntger {
    public static int minMergedInteger(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int res = Integer.MAX_VALUE;

        for(int i=0;i<nums.length - 1;i++){
            StringBuilder currNum = new StringBuilder();
            currNum.append(nums[i]);
            currNum.append(nums[i+1]);

            res = Math.min(res,Integer.parseInt(currNum.toString()));
        }

        return res;
    }
    public static void main(String[] args) {
        // boiler plate 
        int[] nums = {46,45,78,34};
        System.out.println(minMergedInteger(nums));
    }
}
