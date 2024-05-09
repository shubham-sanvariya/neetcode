public class Construct_Binary_Tree_Preorder_Inorder_Traversal {
    public static void main(String[] args) {
        int[] arr = {3,9,20,15,7};
        int[] nums = {9,3,15,20,7};

        Construct_Binary_Tree_Preorder_Inorder_Traversal constructBinaryTreePreorderInorderTraversal =
                new Construct_Binary_Tree_Preorder_Inorder_Traversal();
        constructBinaryTreePreorderInorderTraversal.buildTree(arr,nums);
    }

    private int i = 0;
    private int p = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, Integer.MIN_VALUE);
    }

    private TreeNode build(int[] preorder, int[] inorder, int stop) {
        if (p >= preorder.length) {
            return null;
        }
        if (inorder[i] == stop) {
            ++i;
            return null;
        }

        TreeNode node = new TreeNode(preorder[p++]);
        node.left = build(preorder, inorder, node.val);
        node.right = build(preorder, inorder, stop);
        return node;
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
