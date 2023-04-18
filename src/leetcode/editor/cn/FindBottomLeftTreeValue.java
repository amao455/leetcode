package leetcode.editor.cn;

//给定一个二叉树的 根节点 root， 请找出该二叉树的 最底层 最左边 节点的值。
//
// 假设二叉树中至少有一个节点。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: root = [2,1,3]
//输出: 1
// 
//
// 示例 2: 
//
// 
//
// 
//输入: [1,2,3,4,null,5,6,null,null,7]
//输出: 7
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [1,10⁴] 
// 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 405 👎 0

import java.util.Deque;
import java.util.LinkedList;

class FindBottomLeftTreeValue {
    public static void main(String[] args) {
        Solution solution = new FindBottomLeftTreeValue().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        // 思考：层次遍历解决
        Deque<TreeNode> queue = new LinkedList<>();

        public int findBottomLeftValue(TreeNode root) {
            if (root.left == null && root.right == null) {
                return root.val;
            }

            TreeNode res = new TreeNode();
            queue.offerLast(root);
            boolean flag;
            while (!queue.isEmpty()) {
                flag = false;
                //TODO：一定要是先算出len
                int len = queue.size();
                for (int i = 0; i < len; i++) {
                    TreeNode poll = queue.pollFirst();
                    if (flag == false) {
                        res = poll;
                        flag = true;
                    }
                    if (poll.left != null) {
                        queue.offerLast(poll.left);
                    }
                    if (poll.right != null) {
                        queue.offerLast(poll.right);
                    }

                }

            }
            return res.val;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}