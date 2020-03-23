package github.jasonpang23.data_structures.tree.avl;

import github.jasonpang23.data_structures.resources.FileOperation;

import java.util.ArrayList;

public class AVLTree<K extends Comparable<K> , V> {

    private Node root ;
    private int size ;

    public AVLTree(){
        root = null ;
        size = 0 ;
    }

    public void add(K key,V value){
        root = add(root,key,value) ;
    }

    public boolean contains(K key){
        return getNode(root,key) != null ;
    }

    public V get(K key){
        Node node = getNode(root,key);
        if(node != null)
            return node.value ;
        return null ;
    }

    public int getSize(){
        return size ;
    }

    public boolean isEmpty(){
        return size == 0 ;
    }

    public V remove(K key){
        Node deleteNode = getNode(root, key);
        if(deleteNode != null){
            root = remove(root, key);
            return deleteNode.value ;
        }
        return null ;
    }

    public void set(K key, V newValue){
        Node node = getNode(root, key);
        if(node == null)
            throw new IllegalArgumentException(key + " doesn't exist!");
        node.value = newValue;
    }

    public boolean isBST(){
        ArrayList<K> list = new ArrayList<>() ;
        inOrder(root,list) ;
        for (int i = 1; i < list.size(); i++) {
            if(list.get(i -1).compareTo(list.get(i)) > 0)
                return false ;
        }
        return true ;
    }

    // 判断该二叉树是否是一棵平衡二叉树
    public boolean isBalanced(){
        return isBalanced(root);
    }

    // 判断以Node为根的二叉树是否是一棵平衡二叉树，递归算法
    private boolean isBalanced(Node node){

        if(node == null)
            return true;

        int balanceFactor = getBalanceFactor(node);
        if(Math.abs(balanceFactor) > 1)
            return false;
        return isBalanced(node.left) && isBalanced(node.right);
    }

    private void inOrder(Node node , ArrayList<K> list){
        if(node == null)
            return ;
        inOrder(node.left,list);
        list.add(node.key) ;
        inOrder(node.right,list);
    }
    /**
     * 一个节点的平衡因子：该节点左节点与右节点高度的差
     * @param node
     * @return
     */
    private int getBalanceFactor(Node node){
        if(node == null)
            return 0;
        return getHeight(node.left) - getHeight(node.right) ;
    }

    private int getHeight(Node node){
        if(node == null)
            return 0;
        return node.height ;
    }

    private Node add(Node node,K key,V value){
        if(node == null){
            size ++ ;
            return new Node(key,value) ;
        }
        if(key.compareTo(node.key) > 0){
            node.right = add(node.right,key,value) ;
        }else if(key.compareTo(node.key) < 0){
            node.left = add(node.left,key,value) ;
        }else{
            node.value = value ;
        }

        //在回溯的过程中更新节点的高度
        node.height = Math.max(getHeight(node.left),getHeight(node.right)) + 1 ;

        int balanceFactor = getBalanceFactor(node) ;

        // LL
        //
        //        y                              x
        //       / \                           /   \
        //      x   T4     向右旋转 (y)        z     y
        //     / \       - - - - - - - ->    / \   / \
        //    z   T3                       T1  T2 T3 T4
        //   / \
        // T1   T2
        if(balanceFactor == 2 && getBalanceFactor(node.left) > 0){
            return rightRotate(node);
        }

        // RR
        //    y                             x
        //  /  \                          /   \
        // T1   x      向左旋转 (y)       y     z
        //     / \   - - - - - - - ->   / \   / \
        //   T2  z                     T1 T2 T3 T4
        //      / \
        //     T3 T4
        if(balanceFactor == -2 && getBalanceFactor(node.right) < 0){
            return leftRotate(node);
        }

        // LR
        //
        //        y
        //       / \
        //      x   T4     转为LL的情况
        //     / \       - - - - - - - ->
        //    T3   z
        //        / \
        //       T1 T2
        if(balanceFactor == 2 && getBalanceFactor(node.left) < 0){
            node.left = leftRotate(node.left);
            return rightRotate(node) ;
        }

        // RL
        //    y
        //  /  \
        // T1   x      转为RR的情况
        //     / \   - - - - - - - ->
        //   z  T2
        //  / \
        // T3 T4
        if(balanceFactor == -2 && getBalanceFactor(node.right) > 0){
            node.right = rightRotate(node.right);
            return leftRotate(node) ;
        }
        return node ;
    }

    // 对节点y进行向右旋转操作，返回旋转后新的根节点x
    //        y                              x
    //       / \                           /   \
    //      x   T4     向右旋转 (y)        z     y
    //     / \       - - - - - - - ->    / \   / \
    //    z   T3                       T1  T2 T3 T4
    //   / \
    // T1   T2
    private Node rightRotate(Node y){
        Node x = y.left;
        Node T3 = x.right;

        // 向右旋转过程
        x.right = y;
        y.left = T3;

        // 更新height
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }

    // 对节点y进行向左旋转操作，返回旋转后新的根节点x
    //    y                             x
    //  /  \                          /   \
    // T1   x      向左旋转 (y)       y     z
    //     / \   - - - - - - - ->   / \   / \
    //   T2  z                     T1 T2 T3 T4
    //      / \
    //     T3 T4
    private Node leftRotate(Node y){
        Node x = y.right ;
        Node t2 = x.left ;
        x.left = y ;
        y.right = t2  ;


        y.height = Math.max(getHeight(y.left),getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left),getHeight(x.right)) + 1;
        return x ;

    }

    private Node getNode(Node node ,K key){
        if(node == null)
            return null;

        if(key.equals(node.key))
            return node;
        else if(key.compareTo(node.key) < 0)
            return getNode(node.left, key);
        else
            return getNode(node.right, key);

    }

    private Node remove(Node node,K key){
        if(node == null)
            return null ;

        // 当删除完一个节点后 remove 方法会返回一颗新的二叉树
        // 使用retNode存储，然后调整这棵新二叉树的平衡
        Node retNode ;
        if(key.compareTo(node.key) > 0){
            node.right = remove(node.right,key) ;
            retNode = node ;
        }else if(key.compareTo(node.key) < 0){
            node.left = remove(node.left,key) ;
            retNode = node ;
        }else{
            if(node.left == null){
                Node right = node.right;
                node.right = null ;
                size -- ;
                retNode = right ;
            }else if(node.right == null){
                Node left = node.left ;
                node.left = null  ;
                size -- ;
                retNode = left ;

            }else{
                Node successor = minimun(node.right) ;
                successor.right = remove(node.right,successor.key) ;
                successor.left = node.left ;
                node.left = null ;
                node.right = null ;
                retNode = successor ;
            }
        }

        if(retNode == null)
            return null;

        //删除完一个节点后remove函数会返回一个新的二叉树
        //在返回给上一级节点时先调整结构
        //在回溯的过程中更新节点的高度
        retNode.height = Math.max(getHeight(retNode.left),getHeight(retNode.right)) + 1 ;

        int balanceFactor = getBalanceFactor(retNode) ;

        // LL
        if(balanceFactor > 1 && getBalanceFactor(retNode.left) >= 0){
            return rightRotate(retNode);
        }

        // RR
        if(balanceFactor < -1 && getBalanceFactor(retNode.right) <= 0){
            return leftRotate(retNode);
        }

        // LR
        if(balanceFactor > 1 && getBalanceFactor(retNode.left) < 0){
            retNode.left = leftRotate(retNode.left);
            return rightRotate(retNode) ;
        }

        // RL
        if(balanceFactor < -1 && getBalanceFactor(retNode.right) > 0){
            retNode.right = rightRotate(retNode.right);
            return leftRotate(retNode) ;
        }
        return retNode ;
    }

    private Node minimun(Node node){
        if(node.left == null)
            return node ;
        else
            return minimun(node.left) ;
    }

    private class Node{
        public K key;
        public V value;
        public Node left ;
        public Node right;
        public int height ;

        public Node(K key,V value){
            this.key = key ;
            this.value = value ;
            this.left = this.right = null ;
            height = 1 ;
        }
    }

    public static void main(String[] args){

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("src/github/jasonpang23/data_structures/resources/pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            AVLTree<String, Integer> map = new AVLTree<>();
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
            System.out.println("Is BST: "+map.isBST());
            System.out.println("Is BalanceTree: "+map.isBalanced());

            for (String word:words){
                map.remove(word);
                if(!map.isBST() || !map.isBalanced()){
                    throw new RuntimeException("error");
                }
            }
        }

        System.out.println();
    }
}
