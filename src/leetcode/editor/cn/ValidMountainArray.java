package leetcode.editor.cn;

//给定一个整数数组 arr，如果它是有效的山脉数组就返回 true，否则返回 false。 
//
// 让我们回顾一下，如果 arr 满足下述条件，那么它是一个山脉数组： 
//
// 
// arr.length >= 3 
// 在 0 < i < arr.length - 1 条件下，存在 i 使得： 
// 
// arr[0] < arr[1] < ... arr[i-1] < arr[i] 
// arr[i] > arr[i+1] > ... > arr[arr.length - 1] 
// 
// 
//
// 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [2,1]
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：arr = [3,5,5]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：arr = [0,3,2,1]
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10⁴ 
// 0 <= arr[i] <= 10⁴ 
// 
//
// Related Topics 数组 👍 192 👎 0

class ValidMountainArray{
    public static void main(String[] args) {
        Solution solution = new ValidMountainArray().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validMountainArray1(int[] arr) {
        if(arr.length < 3){
            return false;
        }
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[maxIndex] < arr[i]){
                maxIndex = i;
            }
        }

        if(maxIndex == 0){
            return false;
        }
        if(maxIndex == arr.length-1){
            return false;
        }

        for(int i = 0; i < maxIndex - 1; i++){
            if(arr[i] >= arr[i+1]){
                return false;
            }
        }

        for(int j = maxIndex + 1; j < arr.length; j++){
            if(arr[j-1] <= arr[j]){
                return false;
            }
        }
        return true;
    }



    public boolean validMountainArray(int[] arr) {
        if(arr.length < 3){
            return false;
        }


        int start = 0;
        int end = arr.length-1;

        while(start+1 < arr.length && arr[start+1] > arr[start]){
            start++;
        }

        while(end-1 >= 0 && arr[end-1] > arr[end]){
            end--;
        }

        if(start == 0 || end == arr.length-1){
            return false;
        }
        if(start == end){
            return true;
        }

        return false;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}