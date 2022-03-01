/*
    @author Alejandro Arzola
    https://leetcode.com/problems/single-number/
*/
class SolutionSingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int num: nums){
            result ^= num;
        }
        return result;
    }
}

class TestSingleNumbe{
    public static void main(String args[]){
        SolutionSingleNumber s = new SolutionSingleNumber();
        int data[] = {1,2,1};
        System.out.println(s.singleNumber(data));
    }
}