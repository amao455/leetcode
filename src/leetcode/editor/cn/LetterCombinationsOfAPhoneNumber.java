package leetcode.editor.cn;

//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
//
// Related Topics 哈希表 字符串 回溯 👍 2187 👎 0

import java.util.ArrayList;
import java.util.List;

class LetterCombinationsOfAPhoneNumber{
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {


        List<String> res = new ArrayList<>();
        List<Character> path = new ArrayList<>();
    String[] str = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs","tuv","wxyz"};
     public List<String> letterCombinations(String digits) {

        backTracking(digits, digits.length(), 0);
        return res;
    }

    private void backTracking(String digits, int n, int startIndex) {
         // 终止条件(可以完全理解)
         if(path.size() == n){
             StringBuilder sb = new StringBuilder();
             for (Character character : path) {
                sb.append(character);
             }
             res.add(sb.toString());
             return;
         }


//         for(int i = 0; i < str[digits.charAt(startIndex) - '0'].length(); i++){
//                path.add(str[digits.charAt(startIndex) - '0'].charAt(i));
//                backTracking(digits, n, startIndex + 1);
//                path.remove(path.size() - 1);
//         }


        for(int i = 0; i < str[digits.charAt(startIndex) - '0'].length(); i++){
            path.add(str[digits.charAt(startIndex) - '0'].charAt(i));
            backTracking(digits, n, startIndex+1);
            path.remove(path.size() - 1);

        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}