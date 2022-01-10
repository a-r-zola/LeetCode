/*
    @author Alejandro Arzola
    https://leetcode.com/problems/single-number/
*/
class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int num: nums){
            result ^= num;
        }
        return result;
    }
}

class Test{
    public static void main(String args[]){
        Solution s = new Solution();
        int data[] = {1,2,1};
        System.out.println(s.singleNumber(data));
    }
}