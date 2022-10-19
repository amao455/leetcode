package leetcode.editor.cn;

//给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。 
//
// 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列
//，而 "AEC" 不是） 
//
// 题目数据保证答案符合 32 位带符号整数范围。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "rabbbit", t = "rabbit"
//输出：3
//解释：
//如下图所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
//rabbbit
//rabbbit
//rabbbit 
//
// 示例 2： 
//
// 
//输入：s = "babgbag", t = "bag"
//输出：5
//解释：
//如下图所示, 有 5 种可以从 s 中得到 "bag" 的方案。 
//babgbag
//babgbag
//babgbag
//babgbag
//babgbag
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length, t.length <= 1000 
// s 和 t 由英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 868 👎 0

class DistinctSubsequences{
    public static void main(String[] args) {
        Solution solution = new DistinctSubsequences().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        // dp[i][j]：以 i-1 为结尾的s子序列中出现以 j-1 结尾的t的个数
    public int numDistinct(String s, String t) {
        if(t.length() == 0){
            return 1;
        }

        if(s.length() == 0){
            return 0;
        }

        int[][] dp = new int[s.length()+1][t.length()+1];

        // 初始化
        for(int i = 0; i < s.length()+1; i++){
            dp[i][0] = 1;
        }

        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    // s串用最后一位 + s串不用最后一位
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}