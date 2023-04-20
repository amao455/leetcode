package leetcode.editor.cn;

//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
//被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：[1,2,3,1]
//输出：4
//解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2： 
//
// 
//输入：[2,7,9,3,1]
//输出：12
//解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
//
// Related Topics 数组 动态规划 👍 2294 👎 0

class HouseRobber {
    private static ThreadLocal<String> thread = new ThreadLocal<>();
    public static void main(String[] args) {
        Solution solution = new HouseRobber().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
            // dp[i]表示下标i（包括i）以内的房屋，最多可以偷窃的金额
            int[] dp = new int[nums.length];
            if(nums.length == 1){
                return nums[0];
            }
            if(nums.length == 1){
                return Math.max(nums[0], nums[1]);
            }

            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);

            for(int i = 2; i < nums.length; i++){
                dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
            }

            return dp[nums.length-1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}