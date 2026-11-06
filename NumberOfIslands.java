public class NumberOfIslands {
    public static void dfs(char[][] grid, boolean[][] visited, int i, int j) {
        if (i >= grid.length || i < 0 || j >= grid[0].length || j < 0) {
            return;
        }
        if (visited[i][j] == true) {
            return;
        }

        visited[i][j] = true;

        if (grid[i][j] != '1') {
            return;
        }

        

        

        dfs(grid, visited, i - 1, j);
        dfs(grid, visited, i, j - 1);
        dfs(grid, visited, i, j + 1);
        dfs(grid, visited, i + 1, j);

    }

    public static int numIslands(char[][] grid) {
        int rl = grid.length;
        int cl = grid[0].length;
        boolean[][] visited = new boolean[rl][cl];
        int res = 0;

        for (int i = 0; i < rl; i++) {
            for (int j = 0; j < cl; j++) {
                if (grid[i][j] == '1' && visited[i][j] == false) {
                    dfs(grid, visited, i, j);
                    res = res + 1;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        char[][] grid = {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' }
        };

        int result = numIslands(grid);
        System.out.println("Number of islands: " + result);
    }
}
