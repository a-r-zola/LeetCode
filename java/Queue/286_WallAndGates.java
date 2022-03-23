package Queue;

import java.util.*;

class Coordinate {
    private int x;
    private int y;
    
    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Coordinate getDown(int sizeX, int sizeY){
        //Coordinate candidate = new Coordinate(y+1,x);
        Coordinate candidate = new Coordinate(x,y+1);
        if(validCoordinate(candidate, sizeX, sizeY)){
            return candidate;
        }
        return null;

    }

    public Coordinate getUp(int sizeX, int sizeY){
        //Coordinate candidate = new Coordinate(y-1,x);
        Coordinate candidate = new Coordinate(x,y-1);
        if(validCoordinate(candidate, sizeX, sizeY)){
            return candidate;
        }
        return null;

    }

    public Coordinate getRight(int sizeX, int sizeY){
        //Coordinate candidate = new Coordinate(y,x+1);
        Coordinate candidate = new Coordinate(x+1,y);
        if(validCoordinate(candidate, sizeX, sizeY)){
            return candidate;
        }
        return null;

    }

    public Coordinate getLeft(int sizeX, int sizeY){
        //Coordinate candidate = new Coordinate(y,x-1);
        Coordinate candidate = new Coordinate(x-1,y);
        if(validCoordinate(candidate, sizeX, sizeY)){
            return candidate;
        }
        return null;

    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public boolean validCoordinate(Coordinate coordinate, int sizeX, int sizeY){
        return coordinate.getX() >= 0 && coordinate.getX() < sizeX && coordinate.getY() >= 0 && coordinate.getY() < sizeY;
    }

}

class SolutionWallAndGates {
    public void wallsAndGates(int[][] rooms) {
        
        int sizeX = rooms[0].length;
        int sizeY = rooms.length;
        
        for(int i = 0 ; i < sizeY; i++){
            for(int j = 0 ; j < sizeX; j++){
                if(rooms[i][j] == 0){
                    dfs(new Coordinate(j, i), rooms, sizeX, sizeY);
                }
            }
        }
    }

    public void dfs(Coordinate source, int[][] rooms, int sizeX, int sizeY){

        Queue<Coordinate> queue = new LinkedList<>();
        
        boolean visited[][] = new boolean[sizeY][sizeX];
        int step = 1;
        queue.offer(source);
    
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0 ; i < size ; i++){

                Coordinate point = queue.poll();
                Coordinate up = point.getUp(sizeX, sizeY);
                Coordinate down = point.getDown(sizeX, sizeY);
                Coordinate left = point.getLeft(sizeX, sizeY);
                Coordinate right = point.getRight(sizeX, sizeY);
         
                if(up != null && rooms[up.getY()][up.getX()] > 0 && !visited[up.getY()][up.getX()]){
                    rooms[up.getY()][up.getX()] = Math.min(step, rooms[up.getY()][up.getX()]);
                    visited[up.getY()][up.getX()] = true;
                    queue.offer(up);
                }
                if(down != null && rooms[down.getY()][down.getX()] > 0 && !visited[down.getY()][down.getX()]){
                    rooms[down.getY()][down.getX()] = Math.min(step, rooms[down.getY()][down.getX()]);
                    visited[down.getY()][down.getX()] = true;
                    queue.offer(down);
                }
                if(left != null && rooms[left.getY()][left.getX()] > 0 && !visited[left.getY()][left.getX()]){
                    rooms[left.getY()][left.getX()] = Math.min(step, rooms[left.getY()][left.getX()]);
                    visited[left.getY()][left.getX()] = true;
                    queue.offer(left);
                }
                if(right != null && rooms[right.getY()][right.getX()] > 0 && !visited[right.getY()][right.getX()]){
                    rooms[right.getY()][right.getX()] = Math.min(step, rooms[right.getY()][right.getX()]);
                    visited[right.getY()][right.getX()] = true;
                    queue.offer(right);
                }
            }
            step ++;
        }
    }
}

class TestWallAndGates {
    public static void main(String args[]){

        int rooms[][] = {   
                            {2147483647,-1,0,2147483647},
                            {2147483647,2147483647,2147483647,-1},
                            {2147483647,-1,2147483647,-1},
                            {0,-1,2147483647,2147483647}
                        };
        int sizeX = rooms[0].length;
        int sizeY = rooms.length;

        System.out.println("rooms");
        for(int i = 0 ; i < sizeY; i++){
            for(int j = 0 ; j < sizeX; j++){
                System.out.print(rooms[i][j] == 2147483647? "INF " : rooms[i][j] + " ");
                
            }
            System.out.println();
        }
            
        SolutionWallAndGates solution = new SolutionWallAndGates();
        solution.wallsAndGates(rooms);

        System.out.println("result");
        for(int i = 0 ; i < sizeY; i++){
            for(int j = 0 ; j < sizeX; j++){
                System.out.print(rooms[i][j] + " ");
                
            }
            System.out.println();
        }



    }
}
