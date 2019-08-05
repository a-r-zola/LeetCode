class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length;j++){
                //System.out.println("i: "+i + " j: " + j);
                if(i == j) continue;
                if(nums[i] + nums[j] == target){
                    int min = Math.min(i,j);
                    int max = Math.max(i,j);
                    
                    result[0] = min;
                    result[1] = max;
                    return result;
                }
                
            }
        }
        return result;
        
    }
}