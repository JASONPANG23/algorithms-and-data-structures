package github.jasonpang23.sorting;

import java.util.Random;

public class QuickSort {

    public static void main(String[] args) {
        int count = 1000;
        int [] arr = new int[count] ;
        Random random = new Random() ;
        for (int i = 0; i < count; i++) {
            int num = random.nextInt(Integer.MAX_VALUE);
            arr[i] = num ;
        }
        new QuickSort().sort(arr);

        for (int i = 1; i < count; i++) {
            if(arr[i] < arr[i - 1])
                throw new RuntimeException("error!");
        }
//        for (int i = 0; i < count; i++) {
//            System.out.println(arr[i]);
//        }
        System.out.println("completed!");

    }

    public void sort(int[]nums){
        sort(nums,0,nums.length - 1);
    }

    // [l...r]
    private void sort(int[]nums,int l,int r){
        if(l>=r)
            return ;
        int p = partition(nums,l,r) ;
        sort(nums,l,p-1) ;
        sort(nums,p+1,r);
    }

    private int partition(int[] nums, int l, int r) {
        int v = nums[l] ;
        int i = l + 1 ; //[l...i) 区间内元素小于等于v
        int j = r  ;    //(j...r] 区间内元素大于v

        while(true){
            while(i <= j && nums[i] <= v) i ++ ;
            while(i <= j && nums[j] > v ) j -- ;

            if(i > j) break;
            swap(nums,i,j);
            i++;j--;

        }
        swap(nums,l,j);
        return j;
    }

    private void swap(int[] arr,int a,int b){
        int temp = arr[a] ;
        arr[a] = arr[b] ;
        arr[b] = temp ;
    }
}
