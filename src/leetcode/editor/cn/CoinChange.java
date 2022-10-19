package leetcode.editor.cn;

//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。 
//
// 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 2³¹ - 1 
// 0 <= amount <= 10⁴ 
// 
//
// Related Topics 广度优先搜索 数组 动态规划 👍 2131 👎 0

class CoinChange {
    public static void main(String[] args) {
        Solution solution = new CoinChange().new Solution();
        int[] coins = new int[]{2};
        solution.coinChange1(coins, 3);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int coinChange1(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            for (int i = 0; i < dp.length; i++) {
                dp[i] = Integer.MAX_VALUE;
            }
            dp[0] = 0;

            for (int i = 0; i <= amount; i++) {
                for (int j = 0; j < coins.length; j++) {
                    if (i >= coins[j]) {
                        if (dp[i - coins[j]] != Integer.MAX_VALUE) {
                            dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                        }
                    }
                }

            }
            if (dp[amount] == Integer.MAX_VALUE) {
                return -1;
            }
            return dp[amount];

        }


//    public int coinChange(int[] coins, int amount) {
//        int[] dp = new int[amount+1];
//        for(int i = 1; i < dp.length; i++){
//            dp[i] = Integer.MAX_VALUE;
//        }
//
//        for(int i = 0; i < coins.length; i++){
//            for(int j = coins[i]; j <= amount; j++){
//                if(dp[j-coins[i]] != Integer.MAX_VALUE){
//                    dp[j] = Math.min(dp[j], dp[j-coins[i]] + 1);
//                }
//
//            }
//        }
//
//        if(dp[amount] == Integer.MAX_VALUE){
//            return -1;
//        }
//
//        return dp[amount];
//    }

    }
//leetcode submit region end(Prohibit modification and deletion)

}