import java.util.*;

class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Long> levelSums = new ArrayList<>();
        
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            long levelSum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelSum += node.val;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            levelSums.add(levelSum);
        }

        Collections.sort(levelSums, Collections.reverseOrder());
        return levelSums.size() < k ? -1 : levelSums.get(k - 1);
    }
}
