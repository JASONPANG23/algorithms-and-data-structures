package github.jasonpang23.data_structures.map;

import java.util.ArrayList;

public class BSTMap<K extends Comparable<K>,V> implements Map<K,V> {


    private Node root;
    private int size ;

    public BSTMap(){
        root = null ;
        size = 0 ;
    }

    @Override
    public void add(K k, V v) {
        root = add(root,k,v) ;
    }

    private Node add(Node node,K k,V v){
        if(node == null){
            size ++ ;
            return new Node(k,v) ;
        }

        if(k.compareTo(node.k) > 0)
            node.right = add(node.right,k,v) ;
        else if(k.compareTo(node.k) < 0)
            node.left = add(node.left,k,v);
        else
            node.v = v ;

        return node ;

    }

    @Override
    public V remove(K k) {
        Node node = getNode(k);
        if(node == null)
            return null ;
        root = remove(root,k) ;
        return node.v;

    }
    private Node remove(Node node,K k){
        if(node == null)
            return null ;

        if(k.compareTo(node.k) > 0)
            node.right = remove(node.right,k) ;
        else if(k.compareTo(node.k) < 0)
            node.left = remove(node.left,k) ;
        else{
            if(node.left == null){
                Node right = node.right;
                node.right = null ;
                size -- ;
                return right ;
            }else if(node.right == null){
                Node left = node.left ;
                node.left = null ;
                size -- ;
                return left ;
            }else{
                Node successor = minimun(node.right);
                successor.right =  removeMinimun(node.right) ;
                successor.left = node.left ;
                node.right = null ;
                node.left = null ;
                return successor ;
            }
        }
        return node ;
    }

    private Node minimun(Node node){
        if(node == null)
            return null ;
        while(node.left != null)
            node = node.left;
        return node ;
    }

    private Node removeMinimun(Node node){

        if(node == null)
            return null ;

        if(node.left == null){
            Node right = node.right;
            node.right = null ;
            size -- ;
            return right ;
        }

        node.left = removeMinimun(node.left) ;
        return node ;
    }

    @Override
    public boolean contains(K k) {
        return getNode(root, k) != null;
    }

    @Override
    public V get(K k) {

        Node node = getNode(k);
        return node == null ? null : node.v ;
    }

    @Override
    public void set(K k, V v) {
        Node node = getNode(root, k);
        if(node == null)
            throw new IllegalArgumentException(k + " doesn't exist!");

        node.v = v;
    }

    private Node getNode(K k){
        return getNode(root,k) ;
    }

    private Node getNode(Node node,K k){
        if(node == null)
            return null ;
        if(k.compareTo(node.k) > 0)
            return getNode(node.right,k) ;
        else if(k.compareTo(node.k) < 0)
            return getNode(node.left,k) ;
        else
            return node ;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size== 0;
    }


    private class Node{
        K k ;
        V v ;
        Node left ;
        Node right;

        public Node(K k, V v, Node left, Node right) {
            this.k = k;
            this.v = v;
            this.left = left;
            this.right = right;
        }

        public Node(K k ,V v){
            this.k = k;
            this.v = v;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("src/com/jason/data_structures/map/pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            BSTMap<String, Integer> map = new BSTMap<>();
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.size());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }

        System.out.println();
    }
}
