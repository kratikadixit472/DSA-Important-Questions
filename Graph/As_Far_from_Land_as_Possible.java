/*

1162. As Far from Land as Possible
Medium


Given an n x n grid containing only values 0 and 1, where 0 represents water and 1 represents land, find a water cell such that its distance to the nearest land cell is maximized, and return the distance. If no land or water exists in the grid, return -1.

The distance used in this problem is the Manhattan distance: the distance between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.


Example 1:

Input: grid = [[1,0,1],[0,0,0],[1,0,1]]
Output: 2
Explanation: The cell (1, 1) is as far as possible from all the land with distance 2.


*/
package Graph;

/**
 * As_Far_from_Land_as_Possible
 */
public record As_Far_from_Land_as_Possible() {
}

class As_Far_from_Land_as_Psooble {

  public int maxDistance(int[][] grid) {
      
      int n = grid.length, m = grid[0].length;
      
      for(int i = 0; i < n ; i++){
          for(int j = 0; j < m; j++){
              if(grid[i][j] == 1) continue;
              grid[i][j] = 201;
              
              if(i > 0) grid[i][j] = Math.min(grid[i][j], grid[i-1][j] + 1);
              if(j > 0) grid[i][j] = Math.min(grid[i][j], grid[i][j-1] + 1);
          }
      }
      
      int ans = 0;
      
      for(int i = n-1; i >= 0; i--){
          for(int j = m-1; j >= 0; j--){
              if(grid[i][j] == 1) continue;
              
              if(i < n-1) grid[i][j] = Math.min(grid[i][j], grid[i+1][j] + 1);
              if(j < m-1) grid[i][j] = Math.min(grid[i][j], grid[i][j+1] + 1);
              
              ans = Math.max(ans, grid[i][j]);
          }
      }
      
      return (ans == 201) ? -1 : ans - 1;
  }
}