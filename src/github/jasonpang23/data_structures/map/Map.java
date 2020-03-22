package github.jasonpang23.data_structures.map;

public interface Map<K,V> {
    void add(K k ,V v) ;
    V remove(K k) ;
    boolean contains(K k) ;
    V get(K k) ;
    void set(K k,V v) ;
    int size() ;
    boolean isEmpty() ;
}
