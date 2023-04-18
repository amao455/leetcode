package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

class BinaryTreePaths {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePaths().new Solution();

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


    class TreeNode {
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

        // 存放路径
        List<Integer> path = new ArrayList<>();
        // 存最终的结果
        List<String> result = new ArrayList<>();

        // 回溯求解
        public List<String> binaryTreePaths(TreeNode root) {
            backTracking(root);
            return result;
        }

        private void backTracking(TreeNode root) {
            // 前序遍历（中）：为啥子写在这里
            path.add(root.val);

            // 遇到了叶子节点
            if (root.left == null && root.right == null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < path.size() - 1; i++) {
                    sb.append(path.get(i).toString() + "->");
                }

                sb.append(path.get(path.size() - 1));
                result.add(sb.toString());
                return;
            }

            // 递归和回溯是同时进行的，要放在同一个花括号里
            if (root.left != null) {
                backTracking(root.left);
                path.remove(path.size() - 1);
            }

            if (root.right != null) {
                backTracking(root.right);
                path.remove(path.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}