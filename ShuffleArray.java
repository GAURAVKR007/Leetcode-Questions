class ShuffleArray {

    public static void shiftPlaces(int[] nums, int start, int end){
        int x = nums[start];
        nums[start] = nums[end];
        int idx = 0;
        for(int i = end; i > start; i--){
            if(i == start + 1) {
                nums[i] = x;
                break;
            }
            nums[end - idx] = nums[end - idx - 1];
            idx++;
        }
    }

    public static int[] shuffle(int[] nums, int n) {
        int j = nums.length / 2;
        for (int i=0; i < nums.length ; i++) {
            if(i%2 == 0) {
                continue;
            }

            shiftPlaces(nums,i,j);
            j++;

        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,4,3,2,1};
        int n = 4;
        int[] result = shuffle(nums,n);
        for(int i : result){
            System.out.print(i + " ");
        }
    }

}