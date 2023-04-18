package leetcode.editor.cn;

//n 皇后问题 研究的是如何将 n 个皇后放置在 n × n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。 
//
// 
//
// 
// 
// 示例 1： 
// 
// 
//输入：n = 4
//输出：2
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
// 
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 
//
// Related Topics 回溯 👍 402 👎 0

import java.util.ArrayList;
import java.util.List;

class NQueensIi {
    public static void main(String[] args) {
        Solution solution = new NQueensIi().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int res = 0;
        public int totalNQueens(int n) {
            int[][] arr = new int[n][n];
            backTracking(arr, 0, n);
            return res;
        }

        private void backTracking(int[][] arr, int row, int n) {
            // 结束条件
            if (row == n) {
                res++;
                return;
            }

            for (int col = 0; col < n; col++) {
                if (isValid(arr, row, col, n)) {
                    arr[row][col] = 1;
                    backTracking(arr, row + 1, n);
                    arr[row][col] = 0;
                }
            }
        }

        private boolean isValid(int[][] arr, int row, int col, int n) {
            // 同一列
            for (int i = 0; i < row; i++) {
                if (arr[i][col] == 1) {
                    return false;
                }
            }

            // 左斜线
            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
                if (arr[i][j] == 1) {
                    return false;
                }
            }

            // 右斜线
            for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
                if (arr[i][j] == 1) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}