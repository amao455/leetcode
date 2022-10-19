package leetcode.editor.cn;

//给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。 
//
// 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "bbbab"
//输出：4
//解释：一个可能的最长回文子序列为 "bbbb" 。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出：2
//解释：一个可能的最长回文子序列为 "bb" 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 891 👎 0

class LongestPalindromicSubsequence{
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubsequence().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        // s 和s.reverse()的最长公共子序列即为最长回文子序列
//    public int longestPalindromeSubseq1(String s) {
//        int[][] dp = new int[s.length()+1][s.length()+1];
//        for(int i = 1; i < dp.length; i++){
//            for(int j = 1; j <dp[0].length; j++){
//                if(s.charAt(i-1) == s.charAt(s.length()-j)){
//                    dp[i][j] = dp[i-1][j-1] + 1;
//                }else{
//                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
//                }
//            }
//        }
//
//        return dp[dp.length-1][dp[0].length-1];
//
//    }

    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        // 初始化
        for(int i = 0; i < len; i++){
            dp[i][i] = 1;
        }
        for(int i = dp.length - 2; i >= 0; i--){
            for(int j = i+1; j <dp[0].length; j++){
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }else{
                    dp[i][j] = Math.max(Math.max(dp[i+1][j], dp[i][j-1]), dp[i][j]);
                }
            }
        }
        return dp[0][len-1];
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}