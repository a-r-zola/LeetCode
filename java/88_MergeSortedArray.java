/*
    @author Alejandro Arzola
    https://leetcode.com/problems/two-sum/
*/

class SolutionMergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int x = m - 1;
        int y = n - 1;
        int z = m + n - 1;

        for(int i = z ; i >= 0 ; i--){
            if( x >= 0 && y >= 0){
                if(nums1[x] > nums2[y]){
                    nums1[z--] = nums1[x--]; 
                }else{
                    nums1[z--] = nums2[y--];
                }
            }else if( x >= 0){
                nums1[z--] = nums1[x--];
            }else{
                nums1[z--] = nums2[y--];
            }
        }
    }
}

class TestSolutionMergeSortedArray {

    public static void main(String args[]){
        SolutionMergeSortedArray s = new SolutionMergeSortedArray();
        //int nums1[] = {1,2,3,0,0,0};
        //int nums2[] = {4,5,6};
        //s.merge(nums1, 3, nums2, 3);
        int nums1[] = {1};
        int nums2[] = {};
        s.merge(nums1, 1, nums2, 0);
        for(int num : nums1){
            System.out.println(num);
        }
    }
}
