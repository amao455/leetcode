package leetcode.editor.cn;

//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 算法的时间复杂度应该为 O(log (m+n)) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
//
// Related Topics 数组 二分查找 分治 👍 6502 👎 0

class MedianOfTwoSortedArrays{
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        // TODO: 厉害的想法
        return (getKth(nums1, 0, nums2, 0, left) + getKth(nums1, 0, nums2, 0, right)) / 2.0;


    }

    // 函数的含义：在两个递增的数列中找到第k个元素
    private double getKth(int[] nums1, int st1, int[] nums2, int st2, int k){
        // 边界情况，如果nums1数组已经穷尽了，则只能返回nums2中的第k个元素
        // 起始位置已经大于数组的长度，直接返回另一个数组中指定位置的元素
        if(st1 >= nums1.length){
            return nums2[st2 + k - 1];
        }
        if(st2 >= nums2.length){
            return nums1[st1 + k - 1];
        }

        // 边界情况，如果 k=1 则返回两个数组中最小的那个
        if(k == 1){
            return Math.min(nums1[st1], nums2[st2]);
        }

        // 在nums1和nums2 当前范围内找出mid1和mid2，判断舍弃哪半个部分
        int mid1 = Integer.MAX_VALUE;
        int mid2 = Integer.MAX_VALUE;

        // 想想这步的含义
        if(st1 + k / 2 - 1 < nums1.length){
            mid1 = nums1[st1 + k / 2 - 1];
        }

        if(st2 + k / 2 - 1 < nums2.length){
            mid2 = nums2[st2 + k / 2 - 1];
        }

        // mid1 < mid2在nums1.right 和nums2之间搜索，丢掉 k/2 个数
        // TODO: 仔细想想其中的含义
        if(mid1 < mid2){
            return getKth(nums1, st1 + k / 2, nums2, st2, k - k / 2);
        }else{
            return getKth(nums1, st1, nums2, st2 + k / 2, k - k / 2);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}