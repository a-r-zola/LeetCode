/*
    @author Alejandro Arzola
    https://leetcode.com/problems/single-number/
*/

import java.util.*;

class SolutionMajorityElement {
    public int majorityElement(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int N = nums.length / 2;
        for(int num: nums){
            if(map.containsKey(num)){

                map.put(num, map.get(num) + 1);
            }else{
                map.put(num, 1);
            }
            if(map.get(num) > N)
                return num;
        }
        return -1;
    }
}

class TestMajorityElement{
    public static void main(String args[]){
        SolutionMajorityElement s = new SolutionMajorityElement();
        int data[] = {2,2,1,1,1,2,2};
        System.out.println(s.majorityElement(data));
    }
}