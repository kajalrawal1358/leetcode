class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int level = queue.size();
            List<Integer> current = new ArrayList<>();

            for (int i = 0; i < level; i++) {
                TreeNode curr = queue.poll();
                current.add(curr.val);
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }

            res.add(0, current); // Insert at beginning
        }

        return res;
    }
}