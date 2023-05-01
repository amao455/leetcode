package leetcode.editor.cn;

//给定字符串 s 和 t ，判断 s 是否为 t 的子序列。 
//
// 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而
//"aec"不是）。 
//
// 进阶： 
//
// 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代
//码？ 
//
// 致谢： 
//
// 特别感谢 @pbrother 添加此问题并且创建所有测试用例。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abc", t = "ahbgdc"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "axc", t = "ahbgdc"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 100 
// 0 <= t.length <= 10^4 
// 两个字符串都只由小写字符组成。 
// 
//
// Related Topics 双指针 字符串 动态规划 👍 735 👎 0

class IsSubsequence{
    public static void main(String[] args) {
        Solution solution = new IsSubsequence().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        // dp[i][j]：表示以下标i-1为结尾的字符串s，和以下标j-1节气的字符串t，相同子序列的长度

    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0){
            return true;
        }
        if(t.length() == 0){
            return false;
        }

        if(s.length() > t.length()){
            return false;
        }

        int len1 = s.length();
        int len2 = t.length();
        int[][] dp = new int[len1+1][len2+1];

        int max = 0;
        for(int i = 1; i <= len1; i++){
            for(int j = 1; j <= len2; j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
                if(max < dp[i][j]){
                    max = dp[i][j];
                }
            }
        }

        if(max == len1){
            return true;
        }
        return false;



    }
    public boolean isSubsequence1(String s, String t) {
        if(s.length() == 0){
            return true;
        }
        if(t.length() == 0){
            return false;
        }

        int start = 0;
        for(int i = 0; i < t.length(); i++){
            if(start >= s.length()){
                return true;
            }
            if(t.charAt(i) == s.charAt(start)){
                start++;
            }
        }

        if(start >= s.length()){
            return true;
        }

        return false;

    }

}
//leetcode submit region end(Prohibit modification and deletion)

}