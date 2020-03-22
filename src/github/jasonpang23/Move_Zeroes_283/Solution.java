package github.jasonpang23.Move_Zeroes_283;

/**
 * 283. Move Zeroes
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0 ;
        for(int i = 0;i<nums.length ; i++){
            if(nums[i] != 0)
                nums[index++] = nums[i] ;
        }
        for(int i =index ; i<nums.length;i++){
            nums[i] = 0 ;
        }

    }
}
