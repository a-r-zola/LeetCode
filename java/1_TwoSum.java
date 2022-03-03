/*
    @author Alejandro Arzola
    https://leetcode.com/problems/two-sum/
*/

import java.util.*;

class SolutionTwoSum{
    public int[] twoSum(int[] nums, int target) {

        int result[] = new int[2];

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0 ; i < nums.length ; i++){
            map.put(nums[i], i);
        }

        /* B = target - A */

        for(int i = 0 ; i < nums.length ; i++){
            int B = target - nums[i];
            if(map.containsKey(B) && map.get(B) != i){
                result[0] = i;
                result[1] = map.get(B);
            }
        }
        return result;
    }
}

class TestTwoSum{
    public static void main(String args[]){
        SolutionTwoSum s = new SolutionTwoSum();
        int data[] = {1, 2, 4, 5, 6, 7, 8};
        System.out.println(s.twoSum(data, 15)[0]);
        System.out.println(s.twoSum(data, 15)[1]);
        
    }
}