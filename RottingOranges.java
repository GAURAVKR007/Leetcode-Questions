import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    public static int orangesRotting(int[][] grid) {
        int res = 0;
        int rl = grid.length;
        int cl = grid[0].length;
        boolean[][] visited = new boolean[rl][cl];
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        boolean flag = false;

        for (int i = 0; i < rl; i++) {
            for (int j = 0; j < cl; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                }

                if (grid[i][j] == 2) {
                    queue.offer(new int[] { i, j });
                }
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {

                int[] curr = queue.poll();
                int i = curr[0];
                int j = curr[1];

                visited[i][j] = true;

                int[][] dir = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };

                for (int k = 0; k < 4; k++) {
                    int nr = i + dir[k][0];
                    int nc = j + dir[k][1];

                    if (nr >= grid.length || nr < 0 || nc >= grid[0].length || nc < 0) {
                        continue;
                    }

                    if (grid[nr][nc] == 1) {
                        if (visited[nr][nc] == true) {
                            continue;
                        }
                        queue.offer(new int[] { nr, nc });
                        fresh--;
                        flag = true;
                        grid[nr][nc] = 2;
                    }
                }
            }

            res = flag == true ? res + 1 : res;
            flag = false;

        }

        if (fresh > 0) {
            return -1;
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] grid = {
                { 2, 1, 1 },
                { 1, 1, 1 },
                { 0, 1, 2 }
        };

        int result = orangesRotting(grid);
        System.out.println("Minimum minutes until no fresh orange: " + result);
    }
}
