package Tree;

import java.util.*;
//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
 
class SolutionBinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List< List< Integer> > result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if(root == null)
            return result;
        
        q.offer(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                level.add(node.val);
                if(node.left != null)
                    q.offer(node.left);
                if(node.right != null)
                    q.offer(node.right);
            }
            result.add(level);
        }
        return result;
    }
}

class TestBinaryTreeLevelOrderTraversal {

    public static void main(String args[]){
        
        TreeNode thirdNode = new TreeNode(20);
        thirdNode.left = new TreeNode(15);
        thirdNode.right = new TreeNode(7);

        TreeNode second = new TreeNode(9);

        TreeNode root = new TreeNode(3);
        root.left = second;
        root.right = thirdNode;

        SolutionBinaryTreeLevelOrderTraversal solution = new SolutionBinaryTreeLevelOrderTraversal();
        System.out.println(solution.levelOrder(root));

    }
}
