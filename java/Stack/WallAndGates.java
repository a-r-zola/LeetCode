package Stack;

import java.util.*;

class Coordinate {
    private int x;
    private int y;
    private int step;

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

    public int getStep(){
        return this.step;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public void setStep(int step){
        this.step = step;
    }

    public boolean validCoordinate(Coordinate coordinate, int sizeX, int sizeY){
        return coordinate.getX() >= 0 && coordinate.getX() < sizeX && coordinate.getY() >= 0 && coordinate.getY() < sizeY;
    }

    public void print(){
        System.out.println("Coordinate Y: "+ y +" X: "+x);
    }
}

class SolutionWallAndGates {
    public void wallsAndGates(int[][] rooms) {
        //We need to store the gates coordinates
        
        
        //Queue<Coordinate> queue = new LinkedList<>();
        int sizeX = rooms[0].length;
        int sizeY = rooms.length;

        List<Coordinate> coordinates = new ArrayList<>();


        //int x = 0;
        //int y = 0;
        for(int i = 0 ; i < sizeY; i++){
            for(int j = 0 ; j < sizeX; j++){
                if(rooms[i][j] == 0){
                    coordinates.add(new Coordinate(j, i));
                    //dfs(new Coordinate(j, i), rooms, sizeX, sizeY);
                    //break;
                    //System.out.println("result");
                    //printMap(rooms);
                }
            }
            //break;
        }

        for(Coordinate coordinate: coordinates){
            dfs(coordinate, rooms, sizeX, sizeY);
            System.out.println("result");
            printMap(rooms);
        }
        // System.out.println("Resultado");

        // for(int i = 0 ; i < sizeY; i++){
        //     for(int j = 0 ; j < sizeX; j++){
        //         System.out.print(rooms[i][j] + " ");
                
        //     }
        //     System.out.println();
        // }
    }

    public void printMap(int[][] rooms){
        int sizeX = rooms[0].length;
        int sizeY = rooms.length;
        for(int i = 0 ; i < sizeY; i++){
            for(int j = 0 ; j < sizeX; j++){
                System.out.print(rooms[i][j] + " ");
                
            }
            System.out.println();
        }
    }

    public void dfs(Coordinate source, int[][] rooms, int sizeX, int sizeY){

        Queue<Coordinate> queue = new LinkedList<>();
        boolean visited[][] = new boolean[sizeY][sizeX];
        source.print();
        queue.offer(source);

        int step = 0;;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0 ; i < size ; i++){
                Coordinate point = queue.poll();
                //point.print();
                rooms[point.getY()][point.getX()] = step;
                if(point.getY() == point.getX()){
                    System.out.println( "nmatrix");
                    printMap(rooms);
                    System.out.println( "fin nmatrix");
                }
                //step = rooms[point.getY()][point.getX()] + 1;
                Coordinate up = point.getUp(sizeX, sizeY);
                // if(up != null){
                //     System.out.println("No es nulo :D");
                //     up.print();
                // }
                Coordinate down = point.getDown(sizeX, sizeY);
                // if(down != null){
                //     System.out.println("No es nulo :D");
                //     down.print();
                // }
                //down.print();
                Coordinate left = point.getLeft(sizeX, sizeY);
                // if(left != null){
                //     System.out.println("No es nulo :D");
                //     left.print();
                // }
                //left.print();
                Coordinate right = point.getRight(sizeX, sizeY);
                // if(right != null){
                //     System.out.println("No es nulo :D");
                //     right.print();
                // }
                //right.print();

                if(up != null && rooms[up.getY()][up.getX()] > 0 && !visited[up.getY()][up.getX()]){
                    System.out.println( "up "+step + " - " + rooms[up.getY()][up.getX()]);
                    rooms[up.getY()][up.getX()] = Math.min(step, rooms[up.getY()][up.getX()]);
                    visited[up.getY()][up.getX()] = true;
                    queue.offer(up);
                }
                if(down != null && rooms[down.getY()][down.getX()] > 0 && !visited[down.getY()][down.getX()]){
                    System.out.println( "Down "+step + " - " + rooms[down.getY()][down.getX()]);
                    rooms[down.getY()][down.getX()] = Math.min(step, rooms[down.getY()][down.getX()]);
                    visited[down.getY()][down.getX()] = true;
                    queue.offer(down);
                }
                if(left != null && rooms[left.getY()][left.getX()] > 0 && !visited[left.getY()][left.getX()]){
                    System.out.println( "left "+step + " - " + rooms[left.getY()][left.getX()]);
                    rooms[left.getY()][left.getX()] = Math.min(step, rooms[left.getY()][left.getX()]);
                    visited[left.getY()][left.getX()] = true;
                    queue.offer(left);
                }
                if(right != null && rooms[right.getY()][right.getX()] > 0 && !visited[right.getY()][right.getX()]){
                    System.out.println( "right "+step + " - " + rooms[right.getY()][right.getX()]);
                    System.out.println( "new value 00");
                    printMap(rooms);
                    
                    rooms[right.getY()][right.getX()] = Math.min(step, rooms[right.getY()][right.getX()]);
                    visited[right.getY()][right.getX()] = true;
                    queue.offer(right);
                    System.out.println( "new value 11"+ rooms[right.getY()][right.getX()]);
                    printMap(rooms);
                    System.out.println( "new value 22"+ rooms[right.getY()][right.getX()]);
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

        //boolean visited[][] = new boolean[sizeY][sizeX];
        System.out.println("Inicio");
        for(int i = 0 ; i < sizeY; i++){
            for(int j = 0 ; j < sizeX; j++){
                System.out.print(rooms[i][j] + " ");
                
            }
            System.out.println();
        }
            

        // Set<Coordinate> set = new HashSet<>();
        // Coordinate uno = new Coordinate(1,2);
        // Coordinate dos = new Coordinate(1,2);
        // set.add(uno);
        // System.out.println(set.contains(dos));


        SolutionWallAndGates solution = new SolutionWallAndGates();
        solution.wallsAndGates(rooms);



    }
}
