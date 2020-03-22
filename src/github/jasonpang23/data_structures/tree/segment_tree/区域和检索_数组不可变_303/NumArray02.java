package github.jasonpang23.data_structures.tree.segment_tree.区域和检索_数组不可变_303;

public class NumArray02 {

    //sum[i] 存储了前i个元素的和
    private int[] sum ;

    public NumArray02(int[] nums) {
        sum = new int[nums.length + 1] ;
        sum[0] = 0  ;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = nums[i -  1] + sum[i - 1] ;
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i] ;
    }
}
