package github.jasonpang23.data_structures.queue;

import github.jasonpang23.data_structures.array.Array;

/**
 * 基于动态数组实现的队列
 * 由于队列是在两头操作的，并且动态数组在第一个位置的插入或是删除都是O(n)级别的
 * 所以这种实现效率较低
 * @param <E>
 */
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array ;

    public ArrayQueue(int capacity){
        array = new Array<>(capacity) ;
    }
    public ArrayQueue(){
        this(10) ;
    }

    @Override
    public void enqueue(E e) {
        array.addFirst(e);
    }

    /**
     * O(1)
     * @return
     */
    @Override
    public E dequeue() {
        return array.removeLast();
    }

    /**
     * O(n)
     * @return
     */
    @Override
    public E front() {
        return array.getfirst();
    }

    @Override
    public int getSize() {
        return array.size();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder() ;
        stringBuilder.append("tail [") ;
        for (int i = 0; i < array.size(); i++) {
            stringBuilder.append(array.get(i)) ;
            if(i != array.size() - 1)
                stringBuilder.append(",") ;
        }
        stringBuilder.append("] front") ;
        return stringBuilder.toString() ;
    }
}
