package leetcode.editor.cn;

//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
//
// Related Topics 数组 回溯 👍 1238 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PermutationsIi{
    public static void main(String[] args) {
        Solution solution = new PermutationsIi().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        // 对数组进行排序
        Arrays.sort(nums);
        // 记录是否已经访问
        boolean[] used = new boolean[nums.length];
        backTracking(nums, used);
        return res;
    }

    private void backTracking(int[] nums, boolean[] used) {
        // 结束条件
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        // 单层搜索的逻辑
        for (int i = 0; i < nums.length; i++) {

            // 表示nums[i-1]在本层已经使用
            if(i > 0 && used[i-1] == false && nums[i] == nums[i-1]){
                continue;
            }


            if(used[i] == false){
                used[i] = true;
                path.add(nums[i]);
                backTracking(nums, used);
                path.remove(path.size()-1);
                used[i] = false;
            }
        }


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}