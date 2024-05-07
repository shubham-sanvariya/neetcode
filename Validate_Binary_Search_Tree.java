public class Validate_Binary_Search_Tree {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(4);
        treeNode.right.left = new TreeNode(3);
        treeNode.right.right = new TreeNode(7);

        Validate_Binary_Search_Tree validateBinarySearchTree = new Validate_Binary_Search_Tree();
        validateBinarySearchTree.isValidBST(treeNode);
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode node, Integer low, Integer high){
        if(node == null) return true;

        if(low != null && node.val <= low){
            return false;
        }
        if(high != null && node.val >= high){
            return false;
        }

        boolean leftTree =  helper(node.left, low, node.val);
        boolean rightTree =  helper(node.right, node.val, high);

        return leftTree & rightTree;
    }

    static class TreeNode {
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
}
