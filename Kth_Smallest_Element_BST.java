import java.util.Stack;

public class Kth_Smallest_Element_BST {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(4);
        treeNode.left.right = new TreeNode(2);

        Kth_Smallest_Element_BST kthSmallestElementBst = new Kth_Smallest_Element_BST();
        kthSmallestElementBst.kthSmallest(treeNode,1);
    }

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while(true){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(--k ==0){
                return root.val;
            }
            root = root.right;
        }
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
