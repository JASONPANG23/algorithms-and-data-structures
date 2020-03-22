package github.jasonpang23.data_structures.linkelist;

/**
 * 单向链表
 * @param <E>
 */
public class LinkedList<E>  {
    private int size  ;
    private Node dummyHead ;

    public LinkedList(){
        dummyHead = new Node(null,null) ;
    }

    public int getSize(){
        return size;
    }

    public void add(int index ,E e){

        if(index < 0 || index > size)
            throw new IllegalArgumentException("add filed , index is illegal")  ;

        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next ;
        }
        pre.next = new Node(e,pre.next) ;
        size ++ ;
    }
    public void addFirst(E e){
        add(0,e);
    }
    public void addLast(E e){
        add(size,e);
    }

    public boolean contains(E e){

        for(Node cur = dummyHead.next ; cur!=null ;cur = cur.next){
            if(cur.data.equals(e))
                return true ;
        }
        return false ;
    }

    public E get(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed,index is illegal");

        Node cur = dummyHead.next ;
        for (int i = 0; i < index; i++) {
            cur = cur.next ;
        }
        return cur.data ;
    }

    public E getFirst(){
        return get(0) ;
    }

    public E getLast(){
        return get(size - 1) ;
    }

    public E remove(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Remove filed , index is illegal") ;
        Node pre = dummyHead ;
        for (int i = 0; i < index; i++) {
            pre = pre.next ;
        }
        Node deleteNode = pre.next ;
        E result = deleteNode.data ;
        pre.next = deleteNode.next ;
        deleteNode.next = null ;
        size -- ;
        return result;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size - 1);
    }

    public E removeElement(E e){
        Node pre = dummyHead ;
        while (pre.next != null){
            Node cur = pre.next ;
            if(cur.data.equals(e)){
                pre.next = cur.next ;
                cur.next = null ;
                size -- ;
                return cur.data ;
            }

            pre = pre.next ;
        }
        return null ;
    }


    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder() ;
        stringBuilder.append("head :") ;

        for(Node cur = dummyHead.next; cur != null ; cur = cur.next){
            stringBuilder.append(cur).append("->");
        }
        stringBuilder.append("null") ;
        return stringBuilder.toString();
    }

    private class Node{
        E data ;
        Node next ;

        public Node(E e , Node next){
            this.data = e ;
            this.next = next ;
        }

        public Node(){
            data = null ;
            next = null ;
        }

        @Override
        public String toString() {
            return data.toString() ;
        }
    }
}
