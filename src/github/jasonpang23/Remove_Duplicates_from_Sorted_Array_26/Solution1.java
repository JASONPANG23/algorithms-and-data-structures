package github.jasonpang23.Remove_Duplicates_from_Sorted_Array_26;

public class Solution1 {
    public int removeDuplicates(int[] nums) {
        int index = 1 ;
        for(int i = 1 ; i<nums.length ; i++){
            if(nums[i] != nums[i - 1])
                nums[index++] = nums[i];
        }
        return index ;
    }
}
