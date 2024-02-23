// 200. Number of Islands

// Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

// An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

// Example 1:

// Input: grid = [
//   ["1","1","1","1","0"],
//   ["1","1","0","1","0"],
//   ["1","1","0","0","0"],
//   ["0","0","0","0","0"]
// ]
// Output: 1
// Example 2:

// Input: grid = [
//   ["1","1","0","0","0"],
//   ["1","1","0","0","0"],
//   ["0","0","1","0","0"],
//   ["0","0","0","1","1"]
// ]
// Output: 3

class Solution {
    public int numIslands(char[][] grid) {
        // track yo islands
        int count = 0;

        // traverse until you find a 1
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                // cool we found a 1, that means an island.
                // then look every direction for more 1s
                if (grid[row][col] == '1') {
                    count++;
                    dfs(grid, row, col);
                } 
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int row, int col) {
        // are we out of bounds? did we find water for this spot in this direction?
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] == '0') return;

        // flipping to '0' lets us no longer see old islands 
        grid[row][col] = '0';
        dfs(grid, row + 1, col);     // up
        dfs(grid, row - 1, col);     // down
        dfs(grid, row, col - 1);     // left
        dfs(grid, row, col + 1);     // right
    }
}
