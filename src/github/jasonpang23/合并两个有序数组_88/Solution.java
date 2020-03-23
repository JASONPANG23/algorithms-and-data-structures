package github.jasonpang23.合并两个有序数组_88;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 num1 成为一个有序数组。
 *
 *  
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *  
 *
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = 0 ;
        int j = 0 ;
        int k = 0 ;
        int[] nums3 = new int[m + n] ;

        while (i < m && j < n){
            if(nums1[i] < nums2[j])
                nums3[k ++] = nums1[i ++] ;
            else
                nums3[k ++] = nums2[j ++] ;
        }

        while (i < m) nums3[k ++] = nums1[i++] ;
        while (j < n) nums3[k ++] = nums2[j++] ;

        System.arraycopy(nums3, 0, nums1, 0, nums3.length);

    }
}
