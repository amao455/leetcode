package leetcode.editor.cn;

//给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用 一次 。 
//
// 注意：解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
//
// Related Topics 数组 回溯 👍 1281 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CombinationSumIi{
    public static void main(String[] args) {
        Solution solution = new CombinationSumIi().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        boolean[] used = new boolean[candidates.length];
        for (boolean b : used) {
            b = false;
        }
        Arrays.sort(candidates);
        backTracking(candidates, used, target, 0, 0);
        return result;
    }

    private void backTracking(int[] candidates, boolean[] used, int target, int sum, int startIndex) {
        if(sum > target){
            return;
        }

        if(sum == target){
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = startIndex; i < candidates.length; i++){
            if(i > 0 && candidates[i] == candidates[i-1] && used[i-1] == false){
                continue;
            }
            sum += candidates[i];
            if(sum > target){
                break;
            }
            path.add(candidates[i]);
            used[i] = true;
            backTracking(candidates, used, target, sum, i+1);
            sum -= candidates[i];
            path.remove(path.size()-1);
            used[i] = false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}