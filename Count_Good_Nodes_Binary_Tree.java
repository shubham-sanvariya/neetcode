public class Count_Good_Nodes_Binary_Tree {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(1);
        treeNode.left.left = new TreeNode(3);
        treeNode.right = new TreeNode(4);
        treeNode.right.left = new TreeNode(1);
        treeNode.right.right = new TreeNode(5);

        Count_Good_Nodes_Binary_Tree countGoodNodesBinaryTree = new Count_Good_Nodes_Binary_Tree();
        countGoodNodesBinaryTree.goodNodes(treeNode);
    }

    public int goodNodes(TreeNode root) {
        return goodNodes(root, Integer.MIN_VALUE);
    }

    private int goodNodes(TreeNode root, int max) {
        if (root == null)
            return 0;

        final int newMax = Math.max(max, root.val);
        int goodLeft = goodNodes(root.left,newMax);
        int goodRight = goodNodes(root.right,newMax);
        return (root.val >= max ? 1 : 0) + goodLeft + goodRight;
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
