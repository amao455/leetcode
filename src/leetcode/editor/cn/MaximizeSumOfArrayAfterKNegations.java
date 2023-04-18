package leetcode.editor.cn;

//给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组： 
//
// 
// 选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。 
// 
//
// 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。 
//
// 以这种方式修改数组后，返回数组 可能的最大和 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,2,3], k = 1
//输出：5
//解释：选择下标 1 ，nums 变为 [4,-2,3] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,-1,0,2], k = 3
//输出：6
//解释：选择下标 (1, 2, 2) ，nums 变为 [3,1,0,2] 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [2,-3,-1,5,-4], k = 2
//输出：13
//解释：选择下标 (1, 4) ，nums 变为 [2,3,-1,5,4] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -100 <= nums[i] <= 100 
// 1 <= k <= 10⁴ 
// 
//
// Related Topics 贪心 数组 排序 👍 333 👎 0

import java.util.Arrays;
import java.util.stream.IntStream;

class MaximizeSumOfArrayAfterKNegations {
    public static void main(String[] args) {
        Solution solution = new MaximizeSumOfArrayAfterKNegations().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int largestSumAfterKNegations(int[] nums, int k) {
            Arrays.sort(nums);
            int sum = 0;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] < 0 && k > 0){
                    nums[i] = -nums[i];
                    k--;
                }
                sum += nums[i];
            }
            Arrays.sort(nums);
            // 如果k没有剩余，说明能转的负数都转正了
            // 如果k有剩余：k为偶数，自己抵消掉；k为奇数，减掉2倍最小数
            return sum - (k % 2 == 0 ? 0 : 2 * nums[0]);
        }
        public int largestSumAfterKNegations1(int[] nums, int k) {

            // 将数组按照绝对值的大小进行排序(按照从大到小的顺序进行排序)
            nums = IntStream.of(nums)
                    .boxed()
                    .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
                    .mapToInt(Integer::intValue)
                    .toArray();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < 0 && k > 0) {
                    nums[i] = -nums[i];
                    k--;
                }
            }
            // 如果k还大于0，那么反复转变数值最小的元素，将k用完
            if (k % 2 == 1) nums[nums.length - 1] = -nums[nums.length - 1];
            return Arrays.stream(nums).sum();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}