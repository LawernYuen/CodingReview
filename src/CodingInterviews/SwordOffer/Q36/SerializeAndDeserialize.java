public class SerializeAndDeserialize{
    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public String Serialize(TreeNode node){
        StringBuilder s = new StringBuilder();
        if (node == null)
            s.append("!,");
        else {
            s.append(node.val + ",");
            s.append(Serialize(node.left));
            s.append(Serialize(node.right));
        }
        return s.toString();
    }

    int index = 0;
    public TreeNode Deserialize(String s){
        TreeNode node = null;
        if (s == null || s.length() == 0)
            return node;
        int start = index;
        while (s.charAt(index) != ',')
            index++;
        if (!s.substring(start, index).equal("!")){
            node = new TreeNode(Integer.parseInt(str.substring(start, index)), null, null);
            index++;
            node.left = Deserialize(s);
            node.right = Deserialize(s);
        }
        else
            index++;
        return node;
    }
}