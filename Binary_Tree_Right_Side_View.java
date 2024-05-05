import java.util.ArrayList;
import java.util.List;

public class Binary_Tree_Right_Side_View {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(5);
        treeNode.right.right = new TreeNode(4);

        Binary_Tree_Right_Side_View binaryTreeRightSideView =new Binary_Tree_Right_Side_View();
        binaryTreeRightSideView.rightSideView(treeNode);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        bfsHelper(root, result, 0);
        return result;
    }

    private void bfsHelper(TreeNode root, List<Integer> result, int depth) {
        if (root == null)
            return;
        if(result.size() == depth){
            result.add(0);
        }
        result.set(depth, root.val);
        bfsHelper(root.left, result, depth + 1);
        bfsHelper(root.right, result, depth + 1);
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
