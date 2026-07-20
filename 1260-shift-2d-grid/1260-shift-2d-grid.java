import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] newGrid = new int[m][n];
        int totalElements = m * n;
        k = k % totalElements;
        
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int current1DIndex = (r * n) + c;
                int new1DIndex = (current1DIndex + k) % totalElements;
                int newR = new1DIndex / n;
                int newC = new1DIndex % n;
                newGrid[newR][newC] = grid[r][c];
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int[] row : newGrid) {
            List<Integer> listRow = new ArrayList<>();
            for (int val : row) {
                listRow.add(val);
            }
            result.add(listRow);
        }
        
        return result;
    }
}
