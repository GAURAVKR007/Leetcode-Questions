class JumpGameIII{

    public static boolean dfs(int[] arr, int start,boolean[] visited){
       
        if(visited[start]){
            return false;
        }

        visited[start] = true; 

        if(arr[start] == 0){
            return true;
        }

        int left = start - arr[start];
        int right = start + arr[start];

        if(left >= 0 && left < arr.length){
            if(dfs(arr,left,visited)){
                return true;
            }
        }

        if(right >= 0 && right < arr.length){
            if(dfs(arr,right,visited)){
                return true;
            }
        }

        
        return false;

    }
    public static boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
       

        if(dfs(arr,start,visited)){
            return true;
        }

        return false;
    }
    public static void main(String[] args) {
        int[] arr = {3,0,2,1,2};
        int start = 2;
        System.out.println(canReach(arr, start));
    }
}