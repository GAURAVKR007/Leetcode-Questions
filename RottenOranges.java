import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Deque<int[]> queue = new ArrayDeque<>();
        int fresh = 0;
        int minutes = 0;

        // Add all initially rotten oranges to the queue.
        // Count all fresh oranges.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        // Up, down, left, right
        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };

        // Process one BFS level per minute.
        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();

                int r = curr[0];
                int c = curr[1];

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (nr < 0 || nr >= m ||
                            nc < 0 || nc >= n ||
                            grid[nr][nc] != 1) {
                        continue;
                    }

                    // Rot the fresh orange immediately.
                    grid[nr][nc] = 2;
                    fresh--;

                    queue.add(new int[] { nr, nc });
                }
            }

            minutes++;
        }

        // Any fresh orange left is unreachable.
        return fresh == 0 ? minutes : -1;
    }

    public static void main(String[] args) {
        // Boiler plate code to test the orangesRotting function
        int[][] grid = {
                { 2, 1, 1 },
                { 1, 1, 0 },
                { 0, 1, 1 }
        };

        Solution solution = new Solution();
        int result = solution.orangesRotting(grid);

        System.out.println("Minutes until all oranges rot: " + result);
    }
}
