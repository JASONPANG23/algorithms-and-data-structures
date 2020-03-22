package github.jasonpang23.Remove_Element_27;

/**
 * 27. Remove Element
 */
public class Solution1 {

    public int removeElement(int[] nums, int val) {

        int index = 0 ;
        for(int i = 0 ; i<nums.length;i++){
            if(nums[i] != val){
                swap(nums,index ++ ,i) ;
            }
        }
        return index;
    }
    private void swap(int [] arr ,int a,int b){
        int temp = arr[a] ;
        arr[a]  = arr[b] ;
        arr[b]  = temp ;
    }
}
