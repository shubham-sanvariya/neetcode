public class Serialize_And_Deserialize_Binary_Tree {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(4);
        treeNode.right.right = new TreeNode(5);

        Serialize_And_Deserialize_Binary_Tree serializeAndDeserializeBinaryTree= new
                Serialize_And_Deserialize_Binary_Tree();
        String str = serializeAndDeserializeBinaryTree.serialize(treeNode);
        System.out.println(str);
        serializeAndDeserializeBinaryTree.deserialize(str);
    }

    class Pos {
        int val;
        Pos(int val){
            this.val = val;
        }
        int next() {
            return val++;
        }
    }

    public String serialize(TreeNode root) {
        StringBuilder s = new StringBuilder();
        serialize(root, s);
        return s.toString();
    }

    private void serialize(TreeNode node, StringBuilder s) {
        if (node == null) {
            s.append('N');
            return;
        }
        s.append(node.val);
        s.append(',');
        serialize(node.left, s);
        serialize(node.right, s);
    }

    public TreeNode deserialize(String data) {
        Pos pos = new Pos(0);
        return deserialize(data, pos);
    }

    TreeNode deserialize(String s, Pos pos) {
        int index = pos.next();
        if (s.charAt(index) == 'N') return null;

        pos.val = s.indexOf(',', index);
        int value = Integer.parseInt(s.substring(index, pos.next()));

        TreeNode node = new TreeNode(value);
        node.left = deserialize(s, pos);
        node.right = deserialize(s, pos);
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
