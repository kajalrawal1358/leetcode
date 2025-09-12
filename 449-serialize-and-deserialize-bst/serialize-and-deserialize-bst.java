/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Codec {
    // Serialize BST with pre-order traversal
    public String serialize(TreeNode root) {  
        StringBuilder sb = new StringBuilder(); 
        preOrder(root, sb); 
        return sb.toString(); 
    }

    private void preOrder(TreeNode root, StringBuilder sb){
        if(root == null) return;
        sb.append(root.val).append(","); 
        preOrder(root.left, sb); 
        preOrder(root.right, sb); 
    }

    // Deserialize string back into BST
    public TreeNode deserialize(String data) {  
        String[] arr = data.split(","); 
        TreeNode root = null; 
        for(String s: arr){
            if(s.length() > 0){
                root = buildBst(root, Integer.parseInt(s)); 
            }
        }
        return root; 
    }

    // Helper to insert values into BST
    private TreeNode buildBst(TreeNode root, int v){
        if(root == null) return new TreeNode(v); 
        if(v < root.val) root.left = buildBst(root.left, v); 
        else root.right = buildBst(root.right, v); 
        return root; 
    }
}