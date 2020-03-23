package github.jasonpang23.合并两个有序数组_88;

/**
 * 从后往前放 ， 那么就不需要开额外的空间
 */
public class Solution02 {

    public void merge(int[] nums1, int m, int[] nums2, int n){
        int p1 = m - 1 ;
        int p2 = n - 1 ;
        int p = nums1.length - 1;

        while(p1 >= 0 && p2 >= 0){
            if(nums1[p1] > nums2[p2]) nums1[p -- ] = nums1[p1--];
            else nums1[p -- ] = nums2[p2--];
        }

        while(p1 >= 0) nums1[p--] = nums1[p1--];
        while(p2 >= 0) nums1[p--] = nums2[p2--];
    }
}
