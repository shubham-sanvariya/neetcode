public class Binary_Tree_Maximum_Path_Sum {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(-10);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);

        Binary_Tree_Maximum_Path_Sum binaryTreeMaximumPathSum = new Binary_Tree_Maximum_Path_Sum();
        binaryTreeMaximumPathSum.maxPathSum(treeNode);
    }

    public int maxPathSum(TreeNode root) {
        maxPathSumDownFrom(root);
        return ans;
    }

    private int ans = Integer.MIN_VALUE;

    // Returns the maximum path sum starting from the current root, where
    // root.val is always included.
    private int maxPathSumDownFrom(TreeNode root) {
        if (root == null)
            return 0;

        final int l = Math.max(maxPathSumDownFrom(root.left), 0);
        final int r = Math.max(maxPathSumDownFrom(root.right), 0);
        ans = Math.max(ans, root.val + l + r);
        System.out.println(root.val + Math.max(l, r));
        return root.val + Math.max(l, r);
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
