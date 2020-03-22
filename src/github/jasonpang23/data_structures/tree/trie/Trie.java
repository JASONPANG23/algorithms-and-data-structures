package github.jasonpang23.data_structures.tree.trie;
import java.util.TreeMap;


/**
 * Trie可以对单词进行快速的访问，前提是这个单词能够被
 * 分割成一个一个的单词，例如汉语、韩语、日文等
 * 这里的实现默认只支持英语字符
 */
public class Trie {

    // 存储整棵Trie树 根节点不存储任何数据
    private Node root ;
    private int size ;

    public Trie(){
        root = new Node() ;
        size = 0;
    }

    /**
     * 添加一个新的单词
     * @param word 单词
     */
    public void add(String word){
        Node cur = root ;
        // 处理单词中的每个字符
        for (char c : word.toCharArray()){
            //查看当前字母节点下是否挂载了该字母
            if(cur.next.get(c) == null){
                cur.next.put(c,new Node());
            }
            cur = cur.next.get(c) ;
        }
        // 此时cur指向单词的最后一个字母
        if(!cur.isWord){ // 如果在这个字母与它之前的字母没有构成一个单词，那么就构造它
            cur.isWord = true ;
            size ++ ;
        }
    }

    /**
     * 查询某个单词是否在trie中
     * @param word 单词
     * @return
     */
    public boolean contains(String word){
        Node cur = root ;
        char[] chars = word.toCharArray();
        for (char c : chars){

            Node next = cur.next.get(c);
            // 如果该单词的某个字母不存在trie中
            // 显扬要查询的单词是不存在的
            if(next == null)
                return false ;
            cur = next ;
        }
        // 假设trie中只存在panda
        // 要查询pan这个单词，显然是不存在的
        // 但是它能走到相应对应的字母节点
        // 所以还要判断一下走到最后的字母节点与它之前的字母是否是一个单词
        return cur.isWord ;
    }

    public int getSize(){
        return size ;
    }

    private class Node{
        /**
         * 标记当前节点是否是一个单词的结尾
         */
        public boolean isWord ;
        /**
         * 指向下一个字母节点
         */
        public TreeMap<Character,Node> next;

        public Node(boolean isWord){
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node(){
            this(false) ;
        }
    }
}
