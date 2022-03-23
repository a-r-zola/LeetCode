/*
    @author Alejandro Arzola
    https://leetcode.com/problems/min-stack/
*/

package Stack;

import java.util.*;

class Element{
    int val;
    int min;

    public Element(int val, int min){
        this.val = val;
        this.min = min;
    }
}

class SolutionMinStack {

    List<Element> list;

    public SolutionMinStack() {
        list = new ArrayList<>();
    }
    
    public void push(int val) {
        if(list.size() == 0){
            list.add(new Element(val, val));
            return;
        }
        list.add(new Element(val, Math.min(list.get(list.size() - 1).min, val)));
    }
    
    public void pop() {
        if(list.size() == 0)
            return;
        list.remove(list.size() - 1);
    }
    
    public int top() {
        return list.get(list.size() - 1).val;
    }
    
    public int getMin() {
        return list.get(list.size() - 1).min;
    }
}

class TestMinStack {
    public static void main(String args[]){
        SolutionMinStack minStack = new SolutionMinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2
    }
}
