import java.util.List;

public class ConnectedCell {
    public static int connectedCell(List<List<Integer>> matrix) {
        // Write your code here
        int rows = matrix.size();
        int cols = matrix.get(0).size();
        int max = 0;
        int[][] visited = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (visited[i][j] == 0 && matrix.get(i).get(j) == 1) {
                    int size = 0;
                    size = dfs(matrix, i, j, visited);
                    if (size > max) max = size;
                }
            }
        }
        return max;

    }

    public static int dfs(List<List<Integer>> matrix, int row, int col, int[][] visited) {

        if (row < 0 || col < 0 || row >= matrix.size() || col >= matrix.get(0).size()) {
            return 0;
        }
        if (matrix.get(row).get(col) == 0 || visited[row][col] == 1) return 0;
        int size = 1;
        visited[row][col] = 1;
        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = col - 1; c <= col + 1; c++) {
                size += dfs(matrix, r, c, visited);
            }
        }
        return size;
    }

}

