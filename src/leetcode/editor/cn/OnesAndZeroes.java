package leetcode.editor.cn;

//给你一个二进制字符串数组 strs 和两个整数 m 和 n 。 
//
// 
// 请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。 
// 
//
// 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
//输出：4
//解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
//其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 
//n 的值 3 。
// 
//
// 示例 2： 
//
// 
//输入：strs = ["10", "0", "1"], m = 1, n = 1
//输出：2
//解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 600 
// 1 <= strs[i].length <= 100 
// strs[i] 仅由 '0' 和 '1' 组成 
// 1 <= m, n <= 100 
// 
//
// Related Topics 数组 字符串 动态规划 👍 795 👎 0

class OnesAndZeroes {
    public static void main(String[] args) {
        Solution solution = new OnesAndZeroes().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 一：确定dp数组以及下标的含义
         *      dp[i][j]代表最多有m个0和n个1的最大子集长度
         * 二：确定递推公式
         *      dp[i][j] = max(dp[i][j], dp[i-zeroNum][j-oneNum] + 1)
         * 三：dp数组如何初始化
         * 四：确定遍历顺序
         * 五：距离推导dp数组
         * @param strs
         * @param m
         * @param n
         * @return
         */


        public int findMaxForm(String[] strs, int m, int n) {

            int[][] dp = new int[m+1][n+1];
            int zeroNum = 0;
            int oneNum = 0;

            dp[0][0] = 0;

            for (String str : strs) {// 遍历物品
                zeroNum = 0;
                oneNum = 0;
                for(int i = 0; i < str.length(); i++){
                    if(str.charAt(i) == '0'){
                        zeroNum++;
                    }else{
                        oneNum++;
                    }
                }

                for(int i = m; i >= zeroNum; i--){
                    for(int j = n; j >= oneNum; j--){
                        dp[i][j] = Math.max(dp[i][j], dp[i-zeroNum][j-oneNum] + 1);
                    }
                }
            }

            return dp[m][n];





        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}