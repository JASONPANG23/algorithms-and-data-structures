package github.jasonpang23.data_structures.queue;

/**
 *
 * 基于链表这种数据结构实现的队列
 * 分别使用head和tail指针维护链表的结构
 * 插入的删除都是O(1)
 * @param <E>
 */
public class LinkedListQueue<E> implements Queue<E> {

    private Node head;
    private Node tail ;
    private int size;

    public LinkedListQueue(){
        head = null ;
        tail = null ;
        size = 0 ;
    }

    @Override
    public void enqueue(E e) {
        if(tail == null){
            tail = new Node(e) ;
            head = tail ;
        }else{
            tail.next = new Node(e) ;
            tail = tail.next ;
        }
        size ++ ;
    }

    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.") ;
        }
        Node node = head;
        E data = node.e ;
        head = head.next;
        node.next = null;

        if(head == null){
            tail = null ;
        }

        size -- ;
        return data ;

    }

    @Override
    public E front() {
        return head.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder() ;
        stringBuilder.append("front : ");
        for (Node node = head; node != null; node = node.next) {
            stringBuilder.append(node);
            if(node .next != null){
                stringBuilder.append(",") ;
            }
        }
        return stringBuilder.toString() ;
    }

    private class Node{
        E e ;
        Node next ;

        public Node(E e) {
            this.e = e;
            this.next = null ;
        }

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        @Override
        public String toString() {
            return e.toString() ;
        }
    }
}
