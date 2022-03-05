
/*
    @author Alejandro Arzola
    https://leetcode.com/problems/moving-average-from-data-stream/
*/

package Stack;

import java.util.*;

class MovingAverage {
    private int size;
    private Queue<Integer>  queue;
    private double acum;
    
    public MovingAverage(int size) {
        this.size = size;
        this.acum = 0.0;
        queue = new LinkedList<>();
    }
        
    public double next(int val) {
        if(queue.size() == size){
            acum -= queue.poll();
        }
        acum += val;
        queue.offer(val);
        return acum / queue.size();
    }
}

class TestMovingAverage {
    public static void main(String args[]){
        
        MovingAverage movingAverage = new MovingAverage(3);
        
        System.out.println(movingAverage.next(1)); // return 1.0 = 1 / 1
        System.out.println(movingAverage.next(10)); // return 5.5 = (1 + 10) / 2
        System.out.println(movingAverage.next(3)); // return 4.66667 = (1 + 10 + 3) / 3
        System.out.println(movingAverage.next(5)); // return 6.0 = (10 + 3 + 5) / 3
    }
}
