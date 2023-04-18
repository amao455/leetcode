package leetcode.editor.cn;

//给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。 
//
// 注意：如果对空文本输入退格字符，文本继续为空。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ab#c", t = "ad#c"
//输出：true
//解释：s 和 t 都会变成 "ac"。
// 
//
// 示例 2： 
//
// 
//输入：s = "ab##", t = "c#d#"
//输出：true
//解释：s 和 t 都会变成 ""。
// 
//
// 示例 3： 
//
// 
//输入：s = "a#c", t = "b"
//输出：false
//解释：s 会变成 "c"，但 t 仍然是 "b"。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 200 
// s 和 t 只含有小写字母以及字符 '#' 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以用 O(n) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？ 
// 
//
// Related Topics 栈 双指针 字符串 模拟 👍 538 👎 0

import java.util.ArrayList;
import java.util.List;

class BackspaceStringCompare{
    public static void main(String[] args) {
        Solution solution = new BackspaceStringCompare().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {


    public boolean backspaceCompare(String s, String t) {
        int sSkipNum = 0;
        int tSkipNum = 0;
        int sIndex =  s.length() - 1;
        int tIndex =  t.length() - 1;

        while(true){
            while(sIndex >= 0){
                if(s.charAt(sIndex) == '#'){
                    sSkipNum++;
                }else{
                    if(sSkipNum > 0){
                        sSkipNum--;
                    }else{
                        break;
                    }
                }
                sIndex--;
            }

            while(tIndex >= 0){
                if(t.charAt(tIndex) == '#') {
                    tSkipNum++;
                }else{
                    if(tSkipNum > 0){
                        tSkipNum--;
                    }else{
                        break;
                    }
                }
                tIndex--;
            }

            if(sIndex < 0 || tIndex < 0){
                break;
            }
            if(s.charAt(sIndex) != t.charAt(tIndex)){
                return false;
            }else{
                sIndex--;
                tIndex--;
            }

        }

        if(sIndex == -1 && tIndex == -1){
            return true;
        }

        return false;
    }




    public boolean backspaceCompare1(String s, String t) {
        List<Character> list1 = new ArrayList<>();
        List<Character> list2 = new ArrayList<>();

        toList(s, list1);
        toList(t, list2);

        if(list1.size() != list2.size()){
            return false;
        }

        for (int i = 0; i < list1.size(); i++) {
            if(list1.get(i) !=  list2.get(i)){
                return false;
            }
        }
        return true;
    }

    private void toList(String t, List<Character> list2) {
        for (int i = 0; i < t.length(); i++) {
            if(t.charAt(i) != '#'){
                list2.add(t.charAt(i));
            }else{
                if(list2.isEmpty()){
                    continue;
                }else{
                    list2.remove(list2.size() - 1);
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}