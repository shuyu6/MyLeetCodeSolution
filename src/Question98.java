public class Question98 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        public boolean isValidBST(TreeNode root) {
            return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);

        }
        public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
            if (root == null) return true;
            // the root cant more than maxVal and cant less than minVal
            if (root.val >= maxVal || root.val <= minVal) return false;
            //
            return isValidBST(root.left, minVal, root.val) &&
                    isValidBST(root.right, root.val, maxVal);
        }
        private TreeNode previousNode;
        public boolean isValidBstInOrderMethod(TreeNode root){
            if (root==null) return true;
            boolean isValidBst = isValidBstInOrderMethod(root.left);
            if (!isValidBst|| (previousNode!=null && this.previousNode.val>= root.val))
                return false;
            previousNode = root;
            return isValidBstInOrderMethod(root.right);
        }
    }
    class TreeNode{
        long val;
        TreeNode left;
        TreeNode right;

    }
}
