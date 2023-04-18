package leetcode.editor.cn;

//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
//
// 
// 
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// 
//
// Related Topics 位运算 数组 回溯 👍 958 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SubsetsIi{
    public static void main(String[] args) {
        Solution solution = new SubsetsIi().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        for (boolean b : used) {
            b = false;
        }
//        backTracking(nums, nums.length, 0);
        backTracking1(nums, used, nums.length, 0);
        return res;
    }

    private void backTracking1(int[] nums, boolean[] used, int length, int startIndex) {
        res.add(new ArrayList<>(path));
        if(startIndex >= length){
            return;
        }

        for(int i = startIndex; i < length; i++){
            if(i > 0 && nums[i] == nums[i-1] && used[i-1] == false){
                continue;
            }
            path.add(nums[i]);
            used[i] =  true;
            backTracking1(nums, used, length, i+1);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

    private void backTracking(int[] nums, int length, int startIndex) {
        res.add(new ArrayList<>(path));
        if(startIndex >= length){
            return;
        }

        for(int i = startIndex; i < length; i++){
            // 剪枝操作
            // i == startIndex表示向下的操作
            if(i > startIndex && nums[i] == nums[i-1]){
                continue;
            }else{
                path.add(nums[i]);
                backTracking(nums, length, i+1);
                path.remove(path.size()-1);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}