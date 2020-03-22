package github.jasonpang23.data_structures.queue;


/**
 * 使用动态数组的方式实现的循环队列
 * 使用两个指针进行滑动，因此插入和删除都是O(1)
 * @param <E>
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data  ;
    private int size   ;

    private int front;
    private int tail ;

    @SuppressWarnings("all")
    public LoopQueue(int capacity) {
        //浪费一个空间方便计算数组是否满了
        data = (E[]) new Object[capacity + 1];
    }

    public LoopQueue(){
        this(10) ;
    }

    @Override
    public void enqueue(E e) {
        //判断是否需要扩容
        if((tail + 1) % data.length == front){
            resize(getCapacity() * 2) ;
        }

        data[tail] = e ;
        tail = (tail + 1) % data.length ;
        size ++  ;
    }

    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new IllegalArgumentException("Queue is empty" );
        }
        E result = data[front] ;
        data[front] = null ;
        front = (front + 1) % data.length ;
        size -- ;
        if(size < getCapacity() / 4 && getCapacity() / 2 != 0){
            resize(getCapacity() / 2 );
        }
        return result ;
    }

    @Override
    public E front() {
        if(isEmpty()){
            throw new IllegalArgumentException("Queue is empty" );
        }
        return data[front] ;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    public int getCapacity(){
        // 数组中有一个空间是被浪费掉用来方便计算
        // 它不作为容量的一部分
        return data.length - 1 ;
    }

    @SuppressWarnings("all")
    private void resize(int capacity){
        E[] arr = (E[]) new Object[capacity + 1];
        for (int i = 0; i < size; i++) {
            arr[i] = data[(i + front) % data.length] ;
        }
        front = 0 ;
        tail = size ;
        data = arr ;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder() ;
        stringBuilder.append(String.format("Queue: size = %d , capacity = %d\n",size,getCapacity())) ;
        stringBuilder.append("front[") ;
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            stringBuilder.append(data[i]) ;
            if((i + 1) % data.length != tail){
                stringBuilder.append(",") ;
            }
        }
        stringBuilder.append("] tail") ;
        return stringBuilder.toString() ;
    }

    public static void main(String[] args) {

        LoopQueue<Integer> queue = new LoopQueue<>(3);
        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);

            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
