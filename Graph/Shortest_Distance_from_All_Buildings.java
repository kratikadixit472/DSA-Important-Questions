/*
 
317. Shortest Distance from All Buildings
Hard
You are given an m x n grid grid of values 0, 1, or 2, where:

each 0 marks an empty land that you can pass by freely,
each 1 marks a building that you cannot pass through, and
each 2 marks an obstacle that you cannot pass through.
You want to build a house on an empty land that reaches all buildings in the shortest total travel distance. You can only move up, down, left, and right.

Return the shortest travel distance for such a house. If it is not possible to build such a house according to the above rules, return -1.

The total travel distance is the sum of the distances between the houses of the friends and the meeting point.

The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.

 

Example 1:

Input: grid = [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]
Output: 7
Explanation: Given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2).
The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal.
So return 7.


Example 2:

Input: grid = [[1,0]]
Output: 1

 */

package Graph;
import java.util.*;


class Shortest_Distance_from_All_Building{

  public int shortestDistance(int[][] grid) {

    int n = grid.length, m = grid[0].length;

    int[][] reach = new int[n][m];
    int[][] dist = new int[n][m];
    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    int totalHouses = 0;

    for(int i = 0; i < n; i++){
        for(int j = 0 ; j < m; j++){
            if(grid[i][j] == 1){
                totalHouses++;

                boolean[][] vis = new boolean[n][m];
                LinkedList<int[]> q = new LinkedList<>();
                q.add(new int[]{i, j});
                int level = 1;

                while(!q.isEmpty()){
                    int sz = q.size();
                    while(sz-- > 0){

                        int[] curr = q.poll();
                        int r = curr[0], c = curr[1];

                        for(int d [] : dir){
                            int nr = r + d[0];
                            int nc = c + d[1];

                            if(nr >= 0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] == 0 && !vis[nr][nc]){
                                dist[nr][nc] += level;
                                reach[nr][nc]++;
                                q.add(new int[]{nr, nc});
                                vis[nr][nc] = true;
                            }
                        }
                    }
                    level++;
                }
            }
        }
    }

    int minDist = Integer.MAX_VALUE;

    for(int i = 0; i < n; i++){
        for(int j = 0 ; j < m; j++){
            if(reach[i][j] == totalHouses){
                minDist = Math.min(minDist, dist[i][j]);
            }
        }
    }

    return (minDist == Integer. MAX_VALUE)  ? -1 : minDist;
  }
}