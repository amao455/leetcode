package leetcode.editor.cn;

//给你一个整数数组 nums 和一个整数 target 。 
//
// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ： 
//
// 
// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。 
// 
//
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,1,1], target = 3
//输出：5
//解释：一共有 5 种方法让最终目标和为 3 。
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], target = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 1000 
// 
//
// Related Topics 数组 动态规划 回溯 👍 1375 👎 0

import java.util.Scanner;


class TargetSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.println("next方式接收：");
//        if(scanner.hasNext()){
//            String str1 = scanner.next();
//            System.out.println("输入的数据为：" + str1);
//        }
//        String str1 = scanner.next();
//        System.out.println("输入的数据为：" + str1);


//        while(scanner.hasNext()){
//            System.out.println("键盘输入的内容是：" + scanner.next());
//        }
//        System.out.println("执行吗");

        int i = 1;
        while(!scanner.hasNext("#")){
            System.out.println("第"+i+"个字符串"+scanner.next());
            i++;
        }

        System.out.println("输入完成");


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 转换为在集合中找和为bigSize的组合数
//    public int findTargetSumWays1(int[] nums, int target) {
//
//        int sum = 0;
//        for (int num : nums) {
//            sum += num;
//        }
//
//        if((sum + target) % 2 == 1){
//            return 0;
//        }
//
//        if(Math.abs(target) > sum){
//            return 0;
//        }
//
//        int bigSize =  (sum + target) / 2;
//        int[] dp = new int[bigSize+1];
//        dp[0] = 1;
//
//        for(int i = 0; i < nums.length; i++){
//            for(int j = bigSize; j >= nums[i]; j--){
//                dp[j] += dp[j - nums[i]];
//            }
//        }
//        return dp[bigSize];
//    }

        int res = 0;

        public int findTargetSumWays(int[] nums, int target) {

            int sum = 0;
            for (int num : nums) {
                sum += num;
            }

            if ((sum + target) % 2 == 1) {
                return 0;
            }

            if (Math.abs(target) > sum) {
                return 0;
            }

            int bigSize = (sum + target) / 2;
            backtracking(nums, bigSize, 0, 0);
            return res;
        }

        public void backtracking(int[] nums, int target, int sum, int startIndex) {
            if (sum == target) {
                res++;
                return;
            }
            if (sum > target) {
                return;
            }

            for (int i = startIndex; i < nums.length; i++) {
                sum += nums[i];
                backtracking(nums, target, sum, i + 1);
                sum -= nums[i];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}