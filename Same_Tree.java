public class Same_Tree {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);

        TreeNode treeNode2 = new TreeNode(1);
        treeNode2.left = new TreeNode(2);
        treeNode2.right = new TreeNode(4);

        Same_Tree sameTree = new Same_Tree();
        sameTree.isSameTree(treeNode,treeNode2);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        while (p != null && q != null){
            if (p.val == q.val){
                boolean left = isSameTree(p.left,q.left);
                boolean right = isSameTree(p.right,q.right);
                System.out.println(left&&right);
                return left && right;
            }
            return false;
        }

        return false;
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
