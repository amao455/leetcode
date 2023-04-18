package leetcode.editor.cn;

//按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。 
//
// n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
// 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
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
// Related Topics 数组 回溯 👍 1547 👎 0

import java.util.ArrayList;
import java.util.List;

class NQueens {
    public static void main(String[] args) {
        Solution solution = new NQueens().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<String>> res = new ArrayList<>();

        public List<List<String>> solveNQueens(int n) {
            char[][] arr = new char[n][n];
            // 初始化棋盘，全为空
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = '.';
                }
            }
            backTracking(arr, n, 0);
            return res;
        }

        private void backTracking(char[][] arr, int n, int row) {
            // 结束条件
            // 当n个皇后都已经安置好
            if (row == n) {
                res.add(arrayToList(arr));
                return;
            }

            for (int col = 0; col < n; col++) {
                // 判断当前位置是否能可以放置皇后（回溯的另一种变形）
                if (isValid(row, col, n, arr)) {
                    arr[row][col] = 'Q';
                    backTracking(arr, n, row + 1);
                    arr[row][col] = '.';
                } else {
                    continue;
                }
            }
        }

        // 将得到的二维数组转换为指定的类型
        private List<String> arrayToList(char[][] arr) {
            List<String> list = new ArrayList<>();
            for (char[] chars : arr) {
                list.add(String.copyValueOf(chars));
            }
            return list;

        }

        private boolean isValid(int row, int col, int n, char[][] arr) {

            // 同列不能有元素
            for (int i = 0; i < row; i++) {
                if (arr[i][col] == 'Q') {
                    return false;
                }
            }

            // 左斜线不能有元素
            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
                if (arr[i][j] == 'Q') {
                    return false;
                }
            }

            // 右斜线不能有元素
            for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
                if (arr[i][j] == 'Q') {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}