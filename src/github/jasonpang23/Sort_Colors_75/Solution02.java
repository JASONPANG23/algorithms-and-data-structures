package github.jasonpang23.Sort_Colors_75;


public class Solution02 {

    public void sortColors(int[] nums) {


        int l = 0 ; // [0...l) == 0
        int r = nums.length - 1; // [0...l) == 0
        int i = 0 ;
        while(i < nums.length && i <= r){
            if(nums[i] == 1) i ++ ;
            else if(nums[i] == 0){
                swap(nums,l , i);
                l ++ ;
                i ++ ;
            }else if (nums[i] == 2){
                swap(nums,r,i);
                r  --;
            }
        }
    }

    private void swap(int [] arr ,int a,int b){
        int temp = arr[a] ;
        arr[a] = arr[b] ;
        arr[b] = temp ;
    }

    public static void main(String[] args) {
        Solution02 solution02 = new Solution02();
        int[] arr = new int[]{2,0,2,1,1,0} ;
        solution02.sortColors(arr);
        for (int item : arr)
            System.out.println(item);
    }
}
