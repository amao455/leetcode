package leetcode.editor.cn;

//有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。 
//
// 
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 
//和 "192.168@1.1" 是 无效 IP 地址。 
// 
//
// 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新
//排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 
//输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 
//输入：s = "101023"
//输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// s 仅由数字组成 
// 
//
// Related Topics 字符串 回溯 👍 1068 👎 0

import java.util.ArrayList;
import java.util.List;

class RestoreIpAddresses{
    public static void main(String[] args) {
        Solution solution = new RestoreIpAddresses().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        List<String> res = new ArrayList<>();
        List<String> path = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if(s.length() > 12){
            return res;
        }

        backTracking(s, s.length()-1, 0);

        return res;


    }

    private void backTracking(String s, int n, int startIndex) {
        // 结束条件
        if(path.size() == 3){
            // 判断最后剩余的是否也满足条件
            if(isV(s, startIndex, n)){
                StringBuilder sb = new StringBuilder();
                for (String s1 : path) {
                    sb.append(s1 + '.');
                }
                sb.append(s.substring(startIndex, n+1));
                res.add(sb.toString());
                return;
            }
        }


        for(int i = startIndex; i < n; i++){
           if(isV(s, startIndex, i)){
               path.add(s.substring(startIndex, i+1));
               backTracking(s, n, i+1);
               path.remove(path.size() - 1);
           }else{
               continue;
           }

        }
    }

    private boolean isV(String s, int start, int end) {
        if(start > end){
            return false;
        }
        if(end - start > 2){
            return false;
        }

        if(s.charAt(start) == '0' && end != start){
            return false;
        }

        String s1 = s.substring(start, end+1);
        int num = Integer.parseInt(s1);
        if(num > 255){
            return false;
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}