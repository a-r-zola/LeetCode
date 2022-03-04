/*
    @author Alejandro Arzola
    https://leetcode.com/problems/two-sum/
*/
import java.util.*;
class SolutionIntersectionofTwoArrays2 {
    public int[] intersect(int[] nums1, int[] nums2) {

        //In this set we are going to store the differente nums
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        List<Integer> result = new ArrayList<Integer>();

        for(int num : nums1){
            if(map1.containsKey(num)){
                map1.put(num, map1.get(num) + 1);
            }else{
                map1.put(num, 1);
            }
            set.add(num);
        }
        for(int num : nums2){
            if(map2.containsKey(num)){
                map2.put(num, map2.get(num) + 1);
            }else{
                map2.put(num, 1);
            }
            set.add(num);
        }

        for(int element: set){
            if(map1.containsKey(element) && map2.containsKey(element)){
                int count = Math.min(map1.get(element), map2.get(element));
                for(int i = 0 ; i < count ; i++){
                    result.add(element);
                } 
            }
        }
        int[] resultArray = new int[result.size()];
        for(int i = 0; i < result.size();i++){
            resultArray[i] = result.get(i);
        }
        
        return resultArray;
    }
}

class TestIntersectionofTwoArrays2 {
    public static void main(String args[]){
        SolutionIntersectionofTwoArrays2 s = new SolutionIntersectionofTwoArrays2();
        int nums1[] = {4,4,9,5};
        int nums2[] = {9,4,9,8,4,4};
        int data[] = s.intersect(nums1,  nums2);
        for(int num : data){
            System.out.println(num);
        }
    }
}