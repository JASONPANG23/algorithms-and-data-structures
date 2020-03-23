package github.jasonpang23.数组中的第K个最大元素_215;

import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        int [] arr = new int[]{3,2,1,5,6,4};
        int result = new Solution().findKthLargest(arr, 2);
        System.out.println("result "+result);
    }
    public int findKthLargest(int[] nums, int k) {
        int l = 0;
        int r = nums.length - 1;

        while(l <= r){
            int p = partition(nums,l,r) ;
            System.out.println("p : "+p);
            for (int i = 0; i < nums.length; i++) {
                System.out.print(nums[i] + " ");
            }
            System.out.println();
            if(p == k - 1)
                return nums[p] ;
            if(p < k - 1)
                l = p + 1 ;
            else
                r = p - 1 ;
        }
        return 0;

    }

    //[l...r]

    private int partition(int[] nums,int l ,int r){
        int v = nums[l] ;
        int i = l + 1;
        int j = r ;

        while(true){
            while(i <= j && nums[i] >= v) i ++ ;
            while(i <= j && nums[j] < v) j--;

            if( i > j) break;
            swap(nums,i,j);
            i++;j--;

        }

        swap(nums,l,j);

        return j;
    }

    private void swap(int[]nums,int a,int b){
        int temp = nums[a] ;
        nums[a] = nums[b] ;
        nums[b] = temp;
    }
}
