package leetcode.editor.cn;


class SameTree {


    public static void main(String[] args) {
        Solution solution = new SameTree().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)

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
        public boolean isSameTree(TreeNode p, TreeNode q) {
            // 结束条件
            // 节点为空的情况
            if (p == null && q == null) {
                return true;
            }

            if (p == null || q == null) {
                return false;
            }

            if (p.val != q.val) {
                return false;
            }

            // 本层递归的逻辑
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}