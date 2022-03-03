/*
    @author Alejandro Arzola
    https://leetcode.com/problems/maximum-subarray/
*/

class SolutionMaximumSubArray{
    public int maxSubArray(int[] nums) {

        int maximumSubArray = nums[0];
        int currentMaximumSubArray = nums[0];
        
        for(int i =1; i < nums.length ; i++){
            int num = nums[i];
            currentMaximumSubArray = Math.max(num, currentMaximumSubArray + num);
            maximumSubArray = Math.max(maximumSubArray, currentMaximumSubArray);
        }

        return maximumSubArray;
    }
}

class TestMaximumSubArray{
    public static void main(String args[]){
        SolutionMaximumSubArray solution = new SolutionMaximumSubArray();
        
        //int data[] = {-2,1,-3,4,-1,2,1};
        int data[] = {5,4,-1,7,8};
        System.out.println(solution.maxSubArray(data));

    }
}