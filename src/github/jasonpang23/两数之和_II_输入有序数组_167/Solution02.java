package github.jasonpang23.两数之和_II_输入有序数组_167;

/**
 * 双索引
 * 利用数组有序性的特点
 */
public class Solution02 {

    public int[] twoSum(int[] numbers, int target) {
        int l = 0 ;
        int r = numbers.length -1 ;
        while(l < r){
            int sum = numbers[l] + numbers[r] ;
            if(sum == target)
                return new int[]{l + 1 , r + 1} ;
            if(sum > target) r -- ;
            else l ++ ;
        }
        return null ;
    }
}
