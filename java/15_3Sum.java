/*
    @author Alejandro Arzola
    3 Sum problem, waiting to resolve
*/

import java.util.*;
class SolutionThreeSum {

    /**
     * 1. Take the first number and the mutiply by -1 after we need to found this number in the rest of the numbers taking acount that the index shoudl be different than other 
     * 2. We need to return a array of triplets that compliosh the followin sentence i != j, i!=k, j !=k and the sum must be 0
     * 3. The result doesnt have duplicates
     */
    public List<List<Integer>> threeSum(int[] nums) {
     
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            map.put(i, nums[i]);
        }

        /* Ask for each element in the array */

        return null;
    }

    public int[] twoSum(Map<Integer, Integer> map, int[] nums, int target, int idxSource){

        /* 
            c = a + b
            a = c - b
            if 'a' exist we have a solution
        */

        for(int i = 0; i < nums.length; i++){
            int a = target - nums[i];
            if(map.containsValue(a)){
                
            }
        }
        return null;
    }
    
}

// class Test{
//     public static void main(String args[]){
//         // Solution s = new Solution();
//         // int data[] = {2,2,1,1,1,2,2};
//         // System.out.println(s.majorityElement(data));
//     }
// }
