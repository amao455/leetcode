package leetcode.editor.cn;

//给你一个字符串数组 words ，请你找出所有在 words 的每个字符串中都出现的共用字符（ 包括重复字符），并以数组形式返回。你可以按 任意顺序 返回答
//案。
//
// 
//
// 示例 1： 
//
// 
//输入：words = ["bella","label","roller"]
//输出：["e","l","l"]
// 
//
// 示例 2： 
//
// 
//输入：words = ["cool","lock","cook"]
//输出：["c","o"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 100 
// 1 <= words[i].length <= 100 
// words[i] 由小写英文字母组成 
// 
//
// Related Topics 数组 哈希表 字符串 👍 299 👎 0

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class FindCommonCharacters{
    public static void main(String[] args) {
//        Solution solution = new FindCommonCharacters().new Solution();
        System.out.println("abc" + 1);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> commonChars1(String[] words) {
        List<String> result = new ArrayList<>();

        if(words.length == 1){
            for(int i = 0; i < words[0].length(); i++){
                result.add(Character.toString(words[0].charAt(i)));
            }
        }

        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> tmp = new HashMap<>();

        for (int i = 0; i < words[0].length(); i++) {
            map.put(words[0].charAt(i), map.getOrDefault(words[0].charAt(i), 0) + 1);
        }
        for (int i = 0; i < words.length; i++) {
            for(int j = 0; j < words[i].length(); j++){
                if(map.containsKey(words[i].charAt(j))){
                    tmp.put(words[i].charAt(j), tmp.getOrDefault(words[i].charAt(j), 0) + 1);
                    map.put(words[i].charAt(j), map.get(words[i].charAt(j)) - 1);
                    if(map.get(words[i].charAt(j)) == 0){
                        map.remove(words[i].charAt(j));
                    }
                }
            }
            map.putAll(tmp);
            tmp.clear();
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int total = entry.getValue();
            for (int i = 0; i < total; i++) {
                result.add(entry.getKey().toString());
            }
        }
        return result;

    }


    public List<String> commonChars(String[] words) {
        List<String> result = new ArrayList<>();

        if(words.length == 1){
            for(int i = 0; i < words[0].length(); i++){
                result.add(Character.toString(words[0].charAt(i)));
            }
        }

        int[] hash = new int[26];
        for(int i = 0; i < words[0].length(); i++){
            hash[words[0].charAt(i) - 'a']++;
        }

        for(int i = 1; i < words.length; i++){
            int[] tmp = new int[26];
            for(int j = 0; j < words[i].length(); j++){
                tmp[words[i].charAt(j) - 'a']++;
            }

            for(int k = 0; k < 26; k++){
                hash[k] = Math.min(hash[k], tmp[k]);
            }
        }

        for(int i = 0; i < 26; i++){
            for (int i1 = 0; i1 < hash[i]; i1++) {
                result.add(Character.toString((char)(i + 'a')));
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}