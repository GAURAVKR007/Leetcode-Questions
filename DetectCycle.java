public class DetectCycle {
    public static boolean res = false;

    public static void dfs(char[][] grid, boolean[][] visited, char value, int i, int j, int pi, int pj) {

        visited[i][j] = true;

        int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        for (int k = 0; k < dir.length; k++) {
            int nr = i + dir[k][0];
            int nc = j + dir[k][1];

            if (nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[0].length) {
                continue;
            }

            if (grid[nr][nc] != value) {
                continue;
            }

            if (visited[nr][nc]) {
                if (!(nr == pi && nc == pj)) {
                    res = true;
                }
                continue; // 🚨 VERY IMPORTANT
            }

            dfs(grid, visited, value, nr, nc, i, j);

        }

    }

    public static boolean containsCycle(char[][] grid) {
        res = false;
        int rl = grid.length;
        int cl = grid[0].length;
        boolean visited[][] = new boolean[rl][cl];

        char value = 'n';

        for (int i = 0; i < rl; i++) {
            for (int j = 0; j < cl; j++) {
                value = grid[i][j];
                if (visited[i][j] == false) {
                    dfs(grid, visited, value, i, j, -1, -1);
                }
            }
        }

        return res;

    }

    public static void main(String[] args) {
        char[][] grid = { { 'a', 'b', 'b' }, { 'b', 'z', 'b' }, { 'b', 'b', 'a' } };
        boolean result = containsCycle(grid);
        System.out.println("Result: " + result);
    }
}
