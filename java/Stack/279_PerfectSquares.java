/*
    @author Alejandro Arzola
    https://leetcode.com/problems/perfect-squares/
*/
package Stack;

import java.util.*;

class SolutionPerfectSquares {
    public int numSquares(int n) {

        List<Integer> listOfSquares = getListOfsquares(n);
        int level = 0;
        Set<Integer> queue = new HashSet<>();
        queue.add(n);

        while(!queue.isEmpty()){
            level++;

            Set<Integer> new_queue = new HashSet<>();

            for(int node :  queue){
                for(int square : listOfSquares){
                    if(node == square){
                        return level;
                    } else if(node < square){
                        break;
                    }
                    new_queue.add(node - square);
                }
            }
            queue = new_queue;
        }

        return level;
    }

    private List<Integer> getListOfsquares(int n){
        List<Integer> list = new ArrayList<>();

        for(int i = 1 ; i * i <= n ; i++){
            list.add(i*i);
        }
        return list;
    }


}

class TestPerfectSquares {
    public static void main(String args[]){
        SolutionPerfectSquares solution = new SolutionPerfectSquares();

        System.out.println(solution.numSquares(4));

    }
}