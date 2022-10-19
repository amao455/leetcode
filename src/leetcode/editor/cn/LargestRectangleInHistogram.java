package leetcode.editor.cn;

//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10
// 
//
// 示例 2： 
//
// 
//
// 
//输入： heights = [2,4]
//输出： 4 
//
// 
//
// 提示： 
//
// 
// 1 <= heights.length <=10⁵ 
// 0 <= heights[i] <= 10⁴ 
// 
//
// Related Topics 栈 数组 单调栈 👍 2174 👎 0

import java.util.Stack;

class LargestRectangleInHistogram{
    public static void main(String[] args) {
        Solution solution = new LargestRectangleInHistogram().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        // 最大柱状体的高度一定是数组中的某一个元素
    public int largestRectangleArea1(int[] heights) {
        int sum = 0;
        for (int i = 0; i < heights.length; i++) {
            int left = i;
            int right = i;
            for(; left >= 0; left--){
                if(heights[left] < heights[i]){
                    break;
                }
            }

            for(; right < heights.length; right++){
                if(heights[right] < heights[i]){
                    break;
                }
            }

            int w = right - left - 1;
            int h = heights[i];
            sum = Math.max(sum, w * h);
        }
        return sum;
    }


    public int largestRectangleArea(int[] heights) {

        if(heights.length == 1){
            return 0;
        }

        int len = heights.length;
        int sum = 0;
        int[] newHeights = new int[len+1];
        for (int i = 0; i < len; i++) {
            newHeights[i] = heights[i];
        }

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < len+1; i++){

            if(stack.isEmpty()){
                stack.push(i);
            }

            if(newHeights[i] > newHeights[stack.peek()]){
                stack.push(i);
            }else if(newHeights[i] == newHeights[stack.peek()]){
                stack.pop();
                stack.push(i);
            }else{
                while(!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]){

                    int mid = newHeights[stack.pop()];
                    int left;
                    int right;
                    if(!stack.isEmpty()){
                        left = stack.peek();
                        right = i;
                    }else{
                        left = -1;
                        right = i;
                    }
                    sum = Math.max(sum, (right - left - 1)*mid);
                }
                stack.push(i);
            }
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}