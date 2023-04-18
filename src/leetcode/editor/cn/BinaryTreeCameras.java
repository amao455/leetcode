package leetcode.editor.cn;

//给定一个二叉树，我们在树的节点上安装摄像头。 
//
// 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。 
//
// 计算监控树的所有节点所需的最小摄像头数量。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：[0,0,null,0,0]
//输出：1
//解释：如图所示，一台摄像头足以监控所有节点。
// 
//
// 示例 2： 
//
// 
//
// 输入：[0,0,null,0,null,0,null,null,0]
//输出：2
//解释：需要至少两个摄像头来监视树的所有节点。 上图显示了摄像头放置的有效位置之一。
// 
//
// 提示： 
//
// 
// 给定树的节点数的范围是 [1, 1000]。 
// 每个节点的值都是 0。 
// 
//
// Related Topics 树 深度优先搜索 动态规划 二叉树 👍 571 👎 0

class BinaryTreeCameras {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeCameras().new Solution();

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
    public class Solution {
        /**
         * 局部最优：让叶子节点的父节点安装摄像头，所用摄像头最少
         * 全局最优：全部摄像头所用数量最少
         * @param root
         * @return
         */
        int result = 0;

        public int minCameraCover(TreeNode root) {
            // 对根节点的状态做检测，防止根节点是无覆盖状态
            if(minCase(root) == 0){
                result++;
            }
            return result;

        }

        /**
         * 节点的状态值：
         * 0 表示无覆盖
         * 1 表示有摄像头
         * 2 表示有覆盖
         *
         * 后序遍历，根据左右节点的情况，来判读自己的状态
         * @param root
         * @return
         */

        public int minCase(TreeNode root){
            // 空节点的状态：该节点有覆盖（重点）
            // 空节点不能是无覆盖的状态，这样叶子节点就要放摄像头了；
            // 空节点也不能是有摄像头的状态，这样叶子节点的父节点就没必要放摄像头了
            if(root == null){
                return 2;
            }

            int left = minCase(root.left);
            int right = minCase(root.right);

            // 左右节点的状态
            // 左右节点有一个没有覆盖的情况
            if(left == 0 || right == 0){
                result++;
                return 1;
            }else if(left == 2 && right == 2){ // 左右节点都有覆盖的情况
                return 0;
            }else{ // 左右节点至少有一个摄像头
                return 2;
            }


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}