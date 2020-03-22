package github.jasonpang23.data_structures.stack;

import github.jasonpang23.data_structures.array.Array;

/**
 * 基于数组实现的栈
 */

public class ArrayStack<E> implements Stack<E> {

    private Array<E> array ;

    public ArrayStack(){
        array = new Array<>() ;
    }

    public ArrayStack(int capacity){
        array = new Array<>(capacity) ;
    }

    /**
     * O(1)
     * @param e
     */
    @Override
    public void push(E e) {
        array.addLast(e);
    }

    /**
     * 0(1)
     * @return
     */
    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public int getSize() {
        return array.size();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity(){
        return array.getCapacity() ;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder() ;
        stringBuilder.append("stack: [") ;
        for (int i = 0; i < array.size(); i++) {
            stringBuilder.append(array.get(i));
            if(i != array.size() - 1){
                stringBuilder.append(",") ;
            }
        }
        stringBuilder.append("] top") ;
        return stringBuilder.toString();
    }
}
