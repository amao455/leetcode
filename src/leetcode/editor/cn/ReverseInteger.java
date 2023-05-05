package leetcode.editor.cn;

//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−2³¹, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= x <= 2³¹ - 1 
// 
//
// Related Topics 数学 👍 3822 👎 0

class ReverseInteger{
    public static void main(String[] args) {
        Solution solution = new ReverseInteger().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {
        String s = String.valueOf(x);

        if(x >= 0){
            StringBuilder sb = new StringBuilder(s);
            sb.reverse();
            long aLong = Long.valueOf(sb.toString());
            if(aLong > Integer.MAX_VALUE){
                return 0;
            }else{
                return (int)aLong;
            }

        }
        String s1 = s.substring(1);
        StringBuilder sb = new StringBuilder(s1);
        sb.reverse();
        long aLong = Long.valueOf(s.charAt(0) + sb.toString());
        if(aLong < Integer.MIN_VALUE){
            return 0;
        }else{
            return (int)aLong;
        }


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}