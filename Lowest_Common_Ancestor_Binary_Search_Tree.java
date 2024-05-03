public class Lowest_Common_Ancestor_Binary_Search_Tree {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(6);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(8);
        treeNode.left.left = new TreeNode(0);
        treeNode.left.right = new TreeNode(4);
        treeNode.left.left.left = new TreeNode(3);
        treeNode.left.left.right = new TreeNode(5);
        treeNode.right.left = new TreeNode(7);
        treeNode.right.right = new TreeNode(9);

        Lowest_Common_Ancestor_Binary_Search_Tree lowestCommonAncestorBinarySearchTree = new Lowest_Common_Ancestor_Binary_Search_Tree();
        lowestCommonAncestorBinarySearchTree.lowestCommonAncestor(treeNode,treeNode.left,treeNode.left.right);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > Math.max(p.val, q.val))
            return lowestCommonAncestor(root.left, p, q);
        if (root.val < Math.min(p.val, q.val))
            return lowestCommonAncestor(root.right, p, q);
        System.out.println(root.val);
        return root;
    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x ) {
            val = x;
        }
    }
}
