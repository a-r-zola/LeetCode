/*
    @author Alejandro Arzola
    https://leetcode.com/problems/open-the-lock/
*/

package Queue;

import java.util.*;

class SolutionOpenTheLock {

    public int openLock(String[] deadends, String target) {

        //Initial combination
        String node = "0000"; 

        if(target.equals(node))
            return 0;
        
        Set<String> blocks = new HashSet<>();
        Set<String> seen = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        blocks.addAll(Arrays.asList(deadends));
        
        if(blocks.contains(node))
            return -1;
            
        queue.offer(node);
        seen.add(node);
        int turns[] = { -1, 1 };
        int depth = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int element = 0 ; element < size ; element++){
                String combination = queue.poll();
                for (int i = 0; i < 4; ++i) {
                    int digit = combination.charAt(i) - '0';
                    for(int turn : turns){
                        int digitChange = (digit + 10 + turn) % 10;
                        String newNode = combination.substring(0,i) + digitChange + combination.substring(i + 1);
                        if(newNode.equals(target))
                            return depth;
                        if(blocks.contains(newNode) || seen.contains(newNode))
                            continue;
                        queue.add(newNode);
                        seen.add(newNode);
                    }   
                }
            }
            depth ++;
        }
        return -1;    
    }
}

class TestOpenTheLock {
    public static void main(String args[]){
        

        SolutionOpenTheLock solution = new SolutionOpenTheLock();

        String deads1[] = {"0201","0101","0102","1212","2002"};
        String target1 = "0202";

        String deads2[] = {"8888"};
        String target2 = "0009";

        String deads3[] = {"8887","8889","8878","8898","8788","8988","7888","9888"};
        String target3 = "8888";

        System.out.println(solution.openLock(deads1, target1));
        System.out.println(solution.openLock(deads2, target2));
        System.out.println(solution.openLock(deads3, target3));
    }
}