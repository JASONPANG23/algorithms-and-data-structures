package github.jasonpang23.data_structures.queue;

import java.util.Random;

public class Main {


    private static double testQueue(Queue<Integer> q , int opCount){

        Random random = new Random();
        long startTime = System.nanoTime() ;
        for (int i = 0; i < opCount; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }
        long endTime = System.nanoTime() ;

        return (endTime - startTime) / 1e9 ;
    }


    public static void main(String[] args) {

        Queue<Integer> queue = new ArrayQueue<>(10);
        double time = testQueue(queue,100000);
        System.out.println(time);

        queue = new LoopQueue<>(10) ;
        time = testQueue(queue,100000);
        System.out.println(time);

        queue = new LinkedListQueue<>() ;
        time = testQueue(queue,100000);
        System.out.println(time);


//        Queue<Integer> queue = new LinkedListQueue<>();
//        for (int i = 0; i < 5; i++) {
//            queue.enqueue(i);
//            System.out.println(queue);
//        }
//        for (int i = 0; i < 5; i++) {
//            queue.dequeue();
//            System.out.println(queue);
//        }
    }
}
