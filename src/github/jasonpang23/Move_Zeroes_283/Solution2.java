package github.jasonpang23.Move_Zeroes_283;

/**
 * 283. Move Zeroes
 */
public class Solution2 {
    public void moveZeroes(int[] nums) {
        int index = 0 ;
        for(int i = 0 ;i<nums.length ;i++){
            if(nums[i] != 0){
                swap(nums,index++,i);
            }
        }
    }

    private void swap(int [] arr ,int a,int b){
        int temp = arr[a] ;
        arr[a]  = arr[b] ;
        arr[b]  = temp ;
    }
}
