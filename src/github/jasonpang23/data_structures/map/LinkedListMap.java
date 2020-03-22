package github.jasonpang23.data_structures.map;

public class LinkedListMap<K,V> implements Map<K,V> {

    private Node dummyHead ;
    private int size ;

    public LinkedListMap(){
        dummyHead = new Node() ;
        size = 0 ;
    }

    @Override
    public void add(K k, V v) {
        Node node = getNode(k);
        if(node == null){
            dummyHead.next = new Node(k,v,dummyHead.next) ;
            size ++ ;
        }else{
            node.v = v ;
        }
    }

    @Override
    public V remove(K k) {
        Node pre = dummyHead ;
        while(pre.next != null){
            Node cur = pre.next ;
            if(cur.k.equals(k)){
                pre.next = cur.next ;
                V v = cur.v ;
                cur.next = null ;
                size -- ;
                return v ;
            }
            pre = pre.next ;
        }
        return null;

    }

    @Override
    public boolean contains(K k) {
        return getNode(k) != null;
    }

    @Override
    public V get(K k) {
        Node node = getNode(k);
        if(node != null)
            return node.v;
        return null ;
    }

    @Override
    public void set(K k, V v) {
        Node node = getNode(k);
        if(node != null){
            node.v = v;
        }else{
            throw new IllegalArgumentException(k+" doesn't exist") ;
        }
    }

    @Override
    public int size() {
        return size ;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private Node getNode(K k){

        Node cur = dummyHead.next ;
        while(cur != null){
            if(cur.k.equals(k))
                return cur ;
            cur = cur.next ;
        }
        return  null ;
    }

    private class Node{
        private K k ;
        private V v ;
        private Node next ;

        public Node(K k, V v, Node next) {
            this.k = k;
            this.v = v;
            this.next = next;
        }

        public Node(K k) {
            this.k = k;
        }

        public Node(){
            this.k = null;
            this.v = null;
            this.next = null;
        }

        @Override
        public String toString() {
            return "Key : "+k +" Value: " + v ;
        }
    }
}
