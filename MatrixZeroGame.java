import java.util.ArrayDeque;
import java.util.Deque;

public class MatrixZeroGame {

    public static int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] res = new int[m][n];

        Deque<int[]> queue = new ArrayDeque<>();
        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != 0) {
                    queue.add(new int[] { i, j });
                    int currDistance = 0;
                    boolean[][] visited = new boolean[m][n];

                    while (!queue.isEmpty()) {
                        int size = queue.size();

                        for (int k = 0; k < size; k++) {
                            boolean flag = false;
                            int[] curr = queue.pop();
                            int r = curr[0];
                            int c = curr[1];

                            visited[r][c] = true;

                            for (int d = 0; d < 4; d++) {
                                int nr = r + dr[d];
                                int nc = c + dc[d];

                                if (nr < 0 || nc < 0 || nr >= m || nc >= n || visited[nr][nc]) {
                                    continue;
                                }

                                if (mat[nr][nc] == 0) {
                                    flag = true;
                                    queue.clear(); // Clear the queue to break out of the while loop
                                    break;
                                }

                                queue.add(new int[] { nr, nc });
                            }

                            if (flag) {
                                break;
                            }

                        }

                        currDistance += 1;
                    }

                    res[i][j] = currDistance;
                }
            }
        }

        return res;

    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 0, 0, 0 },
                { 0, 1, 0 },
                { 1, 1, 1 }
        };

        int[][] updatedMatrix = updateMatrix(matrix);

        // Print the modified matrix
        for (int i = 0; i < updatedMatrix.length; i++) {
            for (int j = 0; j < updatedMatrix[0].length; j++) {
                System.out.print(updatedMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
