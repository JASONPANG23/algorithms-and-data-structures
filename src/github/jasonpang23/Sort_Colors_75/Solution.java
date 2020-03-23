package github.jasonpang23.Sort_Colors_75;

/**
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Note: You are not suppose to use the library's sort function for this problem.
 *
 * Example:
 *
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 */
// 计数排序
public class Solution {
    public static void sortColors(int[] nums) {

        int [] count = new int[3] ;
        for (int num : nums) {
            count[num]++;
        }

        int index = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                nums[index++] = i ;
            }
        }
    }

    public static void main(String[] args) {
        int[] input = new int[]{2,0,2,1,1,0} ;
        sortColors(input);
        for (int item : input){
            System.out.println(item);
        }
    }
}
