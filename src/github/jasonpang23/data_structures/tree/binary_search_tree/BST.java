package github.jasonpang23.data_structures.tree.binary_search_tree;

import java.util.LinkedList;
import java.util.Queue;

public class BST<E extends Comparable<E> > {

    private Node root ;
    private int size  ;


    public int size(){
        return size ;
    }

    public boolean isEmpty(){
        return size == 0 ;
    }

    public void add(E e){
        root = add(root,e) ;
    }

    private Node add(Node node ,E e){
        if(node == null){
            size ++ ;
            return new Node(e) ;
        }
        if(e.compareTo(node.data) > 0)
            node.left = add(node.left,e) ;
        else if(e.compareTo(node.data) < 0)
            node.right = add(node.right,e) ;

        return node ;

    }


    public boolean contains(E e){
        return contains(root,e) ;
    }

    private boolean contains(Node node,E e){
        if(node == null)
            return false ;
        if(e.compareTo(node.data) == 0)
            return true ;
        if(e.compareTo(node.data) > 0)
            return contains(node.right,e) ;
        else
            return contains(node.left,e) ;
    }

    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node node){
        if(node == null)
            return ;
        System.out.println(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node){
        if(node == null)
            return ;
        inOrder(node.left);
        System.out.println(node.data);
        inOrder(node.right);
    }

    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node){
        if(node == null)
            return ;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.data);
    }

    public void levelOrder(){
        Queue<Node> queue = new LinkedList<>() ;
        queue.add(root) ;

        while (!queue.isEmpty()){
            Node node = queue.remove();
            System.out.println(node.data);
            if(node.left != null)
                queue.add(node.left) ;
            else if(node.right != null)
                queue.add(node.right) ;

        }
    }

    public E minimum(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty!");
        return minimum(root).data ;
    }

    private Node minimum(Node node){
        if(node.left == null)
            return node;
        return minimum(node.left) ;
    }

    public E removeMin(){
        E e = minimum() ;
        root = removeMin(root) ;
        return e ;

    }

    private Node removeMin(Node node){
        if(node.left == null){
            Node right = node.right ;
            node.right = null ;
            size -- ;
            return right ;
        }

        node.left = removeMin(node.left) ;
        return node ;
    }

    public void remove(E e){
        root = remove(root,e) ;
    }

    private Node remove(Node node,E e){
        if(node == null)
            return null;

        if(e.compareTo(node.data) > 0){
            node.right = remove(node.right,e);
            return node ;
        }else if(e.compareTo(node.data) < 0){
            node.left = remove(node.left,e);
            return node ;

        }else{
            if(node.left == null){
                Node right = node.right;
                node.right = null ;
                size-- ;
                return right ;
            }else if(node.right == null){
                Node left = node.left;
                node.left = null ;
                size -- ;
                return left ;
            }else{
                Node successor =  minimum(node.right) ;
                successor.right = removeMin(node.right) ;
                successor.left = node.left ;
                node.left = null ;
                node.right = null;
                return successor ;
            }
        }
    }

    private class Node{
        E data  ;
        Node left ;
        Node right ;

        public Node(E data){
            this.data = data ;
        }
        public Node(E data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

    }


}
