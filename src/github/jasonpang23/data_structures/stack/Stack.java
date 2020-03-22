package github.jasonpang23.data_structures.stack;

public interface Stack<E> {
    void push(E e) ;
    E pop() ;
    E peek() ;
    int getSize() ;
    boolean isEmpty() ;
}
