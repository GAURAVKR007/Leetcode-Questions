public class FloodFill {
    public static void gridRotation(int[][] image, int sr, int sc, int color, int m, int n, int[][] visited) {

        if (visited[sr][sc] == 1) {
            return;
        }
        visited[sr][sc] = 1;

        // Up
        if (sr - 1 >= 0) {
        if (image[sr - 1][sc] == image[sr][sc]) {
            gridRotation(image, sr - 1, sc, color, m, n, visited);
        }
        }

        // Down
        if (sr + 1 < m) {
            if (image[sr + 1][sc] == image[sr][sc]) {
                gridRotation(image, sr + 1, sc, color, m, n, visited);
            }
        }

        // Left
        if (sc - 1 >= 0) {
            if (image[sr][sc - 1] == image[sr][sc]) {
                gridRotation(image, sr, sc - 1, color, m, n, visited);
            }
        }

        // Right
        if (sc + 1 < n) {
            if (image[sr][sc + 1] == image[sr][sc]) {
                gridRotation(image, sr, sc + 1, color, m, n, visited);
            }
        }

        image[sr][sc] = color;

        return;

    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image[0].length;
        int m = image.length;
        int[][] visited = new int[m][n];

        gridRotation(image, sr, sc, color, m, n, visited);

        return image;
    }

    public static void main(String[] args) {
        // Boiler plate code to test the floodFill function
        int[][] image = {
                { 1, 1, 1 },
                { 1, 1, 0 },
                { 1, 0, 1 }
        };

        int sr = 1;
        int sc = 1;

        int color = 2;

        int[][] result = floodFill(image, sr, sc, color);

        // Print the result
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

    }
}
