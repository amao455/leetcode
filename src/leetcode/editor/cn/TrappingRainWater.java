package leetcode.editor.cn;

//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
//
// Related Topics 栈 数组 双指针 动态规划 单调栈 👍 3833 👎 0

import java.util.Stack;

class TrappingRainWater{
    public static void main(String[] args) {
        Solution solution = new TrappingRainWater().new Solution();
        int[] arr = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        solution.trap(arr);
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap1(int[] height) {
         int len = height.length;
         int[] left = new int[len];
         int[] right = new int[len];

         // 当前元素左侧的最大值
        for(int i = 1; i < len; i++){
            left[i] = Math.max(left[i-1], height[i-1]);
        }

        // 当前元素右侧的最大值
        for(int j = len - 2; j >= 0; j--){
            right[j] = Math.max(right[j+1], height[j+1]);
        }

        int count = 0;
        for (int i = 0; i < len; i++) {
            int level = Math.min(left[i], right[i]);
            count += Math.max(level-height[i], 0);
        }

        return count;

    }

    public int trap(int[] height) {

        Stack<Integer> st = new Stack<>();

        int count = 0;
        for(int i = 0; i < height.length; i++){
            // 栈为空
            if(st.isEmpty()){
                st.push(i);
                continue;
            }

            if(height[i] < height[st.peek()]){
                // 当前元素的高度小于栈顶元素
                st.push(i);
            }else if(height[i] == height[st.peek()]){
                // 当前元素的高度等于栈顶元素
                st.pop();
                st.push(i);
            }else{
                // 当前元素的高度大于栈顶元素
                while(!st.isEmpty() && height[i] > height[st.peek()]){
                    int botton = height[st.pop()];
                    if(!st.isEmpty()){
                        int col = Math.min(height[i], height[st.peek()]) - botton;
                        int row = i - st.peek() - 1;
                        count += col * row;
                    }
                }

                if(!st.isEmpty() && height[i] == height[st.peek()]){
                    st.pop();
                }
                st.push(i);
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}