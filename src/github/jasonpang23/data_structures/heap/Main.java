package github.jasonpang23.data_structures.heap;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int n = (int)1e6;
        MaxHeap<Integer> maxHeap = new MaxHeap<>() ;
        Random random = new Random() ;
        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }

        int[] arr = new int[n] ;
        for (int i = 0; i < n; i++) {
            arr[i] = maxHeap.extractMax() ;
        }

        for (int i = 1; i < n; i++) {
            if(arr[i] > arr[i -1])
                throw new RuntimeException("Error") ;
        }
        System.out.println("Testing the maxHeap completed.");
    }
}
