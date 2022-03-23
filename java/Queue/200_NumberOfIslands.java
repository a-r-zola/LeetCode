/*
    @author Alejandro Arzola
    https://leetcode.com/problems/number-of-islands/
*/
package Queue;

import java.util.*;

class Point {
    int x;
    int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public boolean validCoordinate(int sizeX, int sizeY){
        return x >= 0 && x < sizeX && y >= 0 && y < sizeY;
    }
}
class SolutionNumberOfIstalnds {

    private int[][] neighbors = { {1,0}, {-1,0}, {0,-1}, {0,1} };

    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    bfs(new Point(j, i), grid);
                    count ++;
                }
            }
        }
        return count;
    }

    private void bfs(Point source, char[][] grid){

        int sizeX = grid[0].length;
        int sizeY = grid.length;

        Queue<Point> queue = new LinkedList<>();

        queue.add(source);
        grid[source.y][source.x] = '2';

        while(!queue.isEmpty()){
            Point point = queue.poll();
            
            for(int i = 0; i < neighbors.length; i++){
                Point ngh = new Point(point.x + neighbors[i][0], point.y + neighbors[i][1]);
                
                if(ngh.validCoordinate(sizeX, sizeY) && grid[ngh.y][ngh.x] == '1'){
                    grid[ngh.y][ngh.x] = '2';
                    queue.add(ngh);
                }
            }
        }
    }
}

class TestNumberOfIslands{
    public static void main(String args[]){
        
        SolutionNumberOfIstalnds solution = new SolutionNumberOfIstalnds();
        
        char[][] grid1 = {
                        {'1','1','0','0','0'},
                        {'1','1','0','0','0'},
                        {'0','0','1','0','0'},
                        {'0','0','0','1','1'}
                    };

        
        char[][] grid2 = {
                        {'1','1','1','1','0'},
                        {'1','1','0','1','0'},
                        {'1','1','0','0','0'},
                        {'0','0','0','0','0'}
                    };
        
        char[][] grid3 = { {'1','0','1','1','0','1','1'} };

        char[][] grid4 = { 
        {'1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','0','1','0','1','1'},
        {'0','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','0'},
        {'1','0','1','1','1','0','0','1','1','0','1','1','1','1','1','1','1','1','1','1'},
        {'1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
        {'1','0','0','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
        {'1','0','1','1','1','1','1','1','0','1','1','1','0','1','1','1','0','1','1','1'},
        {'0','1','1','1','1','1','1','1','1','1','1','1','0','1','1','0','1','1','1','1'},
        {'1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','0','1','1'},
        {'1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1'},
        {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
        {'0','1','1','1','1','1','1','1','0','1','1','1','1','1','1','1','1','1','1','1'},
        {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
        {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
        {'1','1','1','1','1','0','1','1','1','1','1','1','1','0','1','1','1','1','1','1'},
        {'1','0','1','1','1','1','1','0','1','1','1','0','1','1','1','1','0','1','1','1'},
        {'1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','1','1','0'},
        {'1','1','1','1','1','1','1','1','1','1','1','1','1','0','1','1','1','1','0','0'},
        {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
        {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'},
        {'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'} };
        
        
        System.out.println(solution.numIslands(grid1));
        System.out.println(solution.numIslands(grid2));
        System.out.println(solution.numIslands(grid3));
        System.out.println(solution.numIslands(grid4));
        
                
    }
}