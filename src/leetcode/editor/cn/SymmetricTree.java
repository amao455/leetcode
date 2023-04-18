package leetcode.editor.cn;

//给你一个二叉树的根节点 root ， 检查它是否轴对称。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,2,3,4,4,3]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,2,null,3,null,3]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 1000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以运用递归和迭代两种方法解决这个问题吗？ 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 2195 👎 0



class SymmetricTree{
    public static void main(String[] args) {
        Solution solution = new SymmetricTree().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class TreeNode {
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

class Solution {



    public boolean isSymmetric(TreeNode root) {
        return compare(root, root);

    }

    private boolean compare(TreeNode root1, TreeNode root2) {

        // 结束条件
        // 节点有为空的情况
        if(root1 == null && root2 != null){
            return false;
        }else if(root1 != null && root2 == null){
            return false;
        }else if(root1 == null && root2 == null){
            return true;
        }else if(root1.val != root2.val){
            // 排除了空节点，在排除数值不相同的情况
            return false;
        }

        // 此时就是：左右节点都不为空，且数值相同的情况
        // 此时才做递归，坐下一层的判断
        // 单层递归的逻辑
        boolean left = compare(root1.left, root2.right);
        boolean right = compare(root1.right, root2.left);
        return (left && right);


    }

}
//leetcode submit region end(Prohibit modification and deletion)

}