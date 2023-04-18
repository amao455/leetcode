package leetcode.editor.cn;

//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。 
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
//
// Related Topics 回溯 👍 1185 👎 0

import java.util.ArrayList;
import java.util.List;

class Combinations{
    public static void main(String[] args) {
//        List<List<Integer>> result = new ArrayList<>();
//        List<Integer> path1 = new ArrayList<>();
//        path1.add(1);
//        path1.add(2);
//        result.add(path1);
//        path1.remove(0);
//        result.add(path1);
//        System.out.println(result);
        Solution solution = new Combinations().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backTracking(n, 1, k);
        return res;
    }

    public void backTracking(int n, int start, int num){
        if(path.size() == num){
            // TODO:为何不能直接res.add(path)
            // res.add(path)是浅拷贝，直接添加path的话，后面path被修改，res里的数值也会变化
            res.add(new ArrayList<>(path));
            return;
        }

/*        // 为优化前
        for(int i = start; i <= n; i++){
            path.add(i);
            backTracking(n, i+1, num);
            path.remove(path.size() - 1);
        }*/

        // 剪枝优化
        for(int i = start; i <= n + 1 - (num - path.size()); i++ ){

            path.add(i);
            backTracking(n, i+1, num);
            path.remove(path.size() - 1);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}