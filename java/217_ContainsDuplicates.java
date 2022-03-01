/*
    @author Alejandro Arzola
    https://leetcode.com/problems/contains-duplicate/
*/

import java.util.*;

class SolutionContainsDuplicates {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> container = new HashSet<>();
        for(int num : nums){
            if(container.contains(num))
                return true;
            container.add(num);
        }
        return false;
    }
}

class TestContainsDuplicates{
    public static void main(String args[]){
        SolutionContainsDuplicates s = new SolutionContainsDuplicates();
        int data[] = {1,2,3,4,5,5};
        System.out.println(s.containsDuplicate(data));
    }
}

