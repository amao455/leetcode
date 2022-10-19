package leetcode.editor.cn;

//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
//
// Related Topics 数组 动态规划 👍 1492 👎 0

class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        Solution solution = new PartitionEqualSubsetSum().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*
        1,确定dp数组以及下标的含义
            dp[j] 代表 背包总容量为j，最大可以凑成i的子集总和为dp[j]
        2，递推公式为：
            dp[j] = max(dp[j], dp[j - nums[i]] + nums[i])
        3，初始化
        4，递推顺序
        5，举例推导dp数组
         */

        public boolean canPartition1(int[] nums) {
            int total = 0;
            for (int i = 0; i < nums.length; i++) {
                total += nums[i];
            }
            if (total % 2 == 1) {
                return false;
            }

            int W = total / 2;
            int[] dp = new int[W + 1];
            dp[0] = 1;
            for (int num : nums) {
                for (int i = W; i >= num; i--) {
                    dp[i] += dp[i - num];
                }
            }

            return dp[W] != 0;

        }

        // 将问题抽象成“给定一个数组和一个容量为x的背包，求有多少种方法可以让背包装满”
        // dp[i] = dp[i] + dp[i-nums[i]]
        public boolean canPartition(int[] nums) {
            int total = 0;
            for (int num : nums) {
                total += num;
            }

            if (total % 2 == 1) {
                return false;
            }

            int[] dp = new int[total / 2 + 1];
            int W = total / 2;
            dp[0] = 1;
            for (int i = 0; i < nums.length; i++) {
                for (int j = W; j >= nums[i]; j--) {
                    dp[j] += dp[j] + dp[j - nums[i]];
                }
            }

            return dp[W] == 0 ? false : true;

        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}