package github.jasonpang23.data_structures.tree.trie.添加与搜索单词_数据结构设计_211;

import github.jasonpang23.data_structures.tree.trie.Trie;

import java.util.TreeMap;

/**
 * 设计一个支持以下两种操作的数据结构：
 *
 * void addWord(word)
 * bool search(word)
 *
 * search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。
 *
 * 示例:
 *
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 *
 * 说明:
 *
 * 你可以假设所有单词都是由小写字母 a-z 组成的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-and-search-word-data-structure-design
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class WordDictionary {

    private Node root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Node() ;
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
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
        }
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(root,word,0) ;
    }

    private boolean search(Node node,String word,int index){
        if(index == word.length())
            return node.isWord ;
        char ch = word.charAt(index) ;
        if(ch != '.'){
            if(node.next.get(ch) == null)
                return false ;
            return search(node.next.get(ch),word,index+1) ;
        }else{
            // 遍历该字母节点下的所有节点
            for (char nextChar : node.next.keySet()){
                boolean result = search(node.next.get(nextChar),word,index + 1) ;
                if(result)
                    return result ;
            }
            return false ;
        }
    }

    private class Node{
        /**
         * 标记当前节点是否是一个单词的结尾
         */
        public boolean isWord ;
        /**
         * 指向下一个字母节点
         */
        public TreeMap<Character, Node> next;

        public Node(boolean isWord){
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node(){
            this(false) ;
        }
    }
}
