package leetcode.editor.cn;

//给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。 
//
// 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,6,7,7]
//输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,4,3,2,1]
//输出：[[4,4]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 15 
// -100 <= nums[i] <= 100 
// 
//
// Related Topics 位运算 数组 哈希表 回溯 👍 616 👎 0

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class NonDecreasingSubsequences{
    public static void main(String[] args) {
        Solution solution = new NonDecreasingSubsequences().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {

        backTracking(nums, nums.length, 0);
        return result;
    }

    private void backTracking(int[] nums, int length, int startIndex) {
        if(path.size() >= 2){
            result.add(new ArrayList<>(path));
        }

//        int[] used = new int[201];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = startIndex; i < length; i++){

            if(!path.isEmpty() && nums[i] < path.get(path.size() - 1) || map.getOrDefault(nums[i], 0) >= 1){
                continue;
            }

            path.add(nums[i]);
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
            backTracking(nums, length, i+1);
            path.remove(path.size() - 1);


        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}