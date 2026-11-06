import java.util.Arrays;

public class SortMatrixDiagonally {

    public static void sortingAlgo(int[][] arr, int m, int n){ 
        // For Down Matrix from Diagonal
        
        for(int i=1;i<m;i++){
            int j = 0;
            int k = i;
            int idx = 0;
            int diagLength = Math.min(m - i, n); 
int[] currArr = new int[diagLength];
            while(j < m){
                currArr[idx] = arr[k][j];
                j++; k++; idx++;
            }
            
            Arrays.sort(currArr);
            j = 0;
            k = i;
            idx = 0;
            for(int l = 0;l<currArr.length;l++){
                arr[k][j] = currArr[idx];
                k++; j++; idx++;
            }
        }
        
        // For Up Matrix Diagonal
        
        for(int j=1;j<n;j++){
            int i = 0;
            int k = j;
            int idx = 0;
            int[] currArr = new int[n - j];
            while(i < m){
                currArr[idx] = arr[k][i];
                i++; k++; idx++;
            }
            
            Arrays.sort(currArr);
            i = 0;
            k = j;
            idx = 0;
            for(int l = 0;l<currArr.length;l++){
                arr[k][i] = currArr[idx];
                k++; i++; idx++;
            }
        }
        
        int diagonalLength = Math.min(m,n);
        
        int[] diagonalArr = new int[diagonalLength];
        
        for(int i=0;i<diagonalLength;i++){
            diagonalArr[i] = arr[i][i];
        }
        
        Arrays.sort(diagonalArr);
        
        for(int i=0;i<diagonalLength;i++){
            arr[i][i] = diagonalArr[i];
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.println(arr[i][j]+" ");
            }
            System.out.println("");
        }
    }
    public static void main(String[] args) {
        // Example usage
        int[][] arr = {
            {4, 3 ,19, 4},
            {12, 3, 1, 13},
            {6, 8, 4, 5}
        };

        int m = arr.length;
        int n = arr[0].length;

        sortingAlgo(arr, m, n);
    }
}
