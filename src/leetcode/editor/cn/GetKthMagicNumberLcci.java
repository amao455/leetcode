package leetcode.editor.cn;

//有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，
//5，7，9，15，21。 
//
// 示例 1: 
//
// 输入: k = 5
//
//输出: 9
// 
//
// Related Topics 哈希表 数学 动态规划 堆（优先队列） 👍 170 👎 0

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class GetKthMagicNumberLcci{
    public static void main(String[] args) {
        Solution solution = new GetKthMagicNumberLcci().new Solution();
        solution.getKthMagicNumber(5);
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        // 答案没有看懂
    public int getKthMagicNumber(int k) {

        // 记录结果
        int[] result = new int[k];
        result[0] = 1;

        // 三个指针 分别代表resultA, B, C的下标
        int point3 = 0;
        int point5 = 0;
        int point7 = 0;

        for (int i = 1; i < k; i++) {
            int resultN = Math.min(Math.min(result[point3] * 3, result[point5] * 5), result[point7] * 7);
            if(resultN % 3 == 0){
                point3++;
            }
            if(resultN % 5 == 0){
                point5++;
            }
            if(point7 % 7 == 0){
                point7++;
            }
            result[i] = resultN;
        }
        return result[k-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}