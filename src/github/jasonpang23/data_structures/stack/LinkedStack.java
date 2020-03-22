package github.jasonpang23.data_structures.stack;


import github.jasonpang23.data_structures.linkelist.LinkedList;

public class LinkedStack<E> implements Stack<E> {

    private LinkedList<E> linkedList ;

    public LinkedStack(){
        linkedList = new LinkedList<>() ;
    }

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public E peek() {
        return linkedList.getFirst();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder() ;
        stringBuilder.append("stack top ") ;
        stringBuilder.append(linkedList) ;
        return stringBuilder.toString() ;

    }
}
