package github.jasonpang23.data_structures.tree.trie.键值映射_677;

import github.jasonpang23.data_structures.tree.trie.Trie;

import java.util.TreeMap;

/**
 * 实现一个 MapSum 类里的两个方法，insert 和 sum。
 *
 * 对于方法 insert，你将得到一对（字符串，整数）的键值对。字符串表示键，整数表示值。如果键已经存在，那么原来的键值对将被替代成新的键值对。
 *
 * 对于方法 sum，你将得到一个表示前缀的字符串，你需要返回所有以该前缀开头的键的值的总和。
 *
 * 示例 1:
 *
 * 输入: insert("apple", 3), 输出: Null
 * 输入: sum("ap"), 输出: 3
 * 输入: insert("app", 2), 输出: Null
 * 输入: sum("ap"), 输出: 5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/map-sum-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MapSum {

    private Node root ;
    /** Initialize your data structure here. */
    public MapSum() {
        root = new Node();
    }

    public void insert(String key, int val) {
        Node cur = root ;
        // 处理单词中的每个字符
        for (char c : key.toCharArray()){
            //查看当前字母节点下是否挂载了该字母
            if(cur.next.get(c) == null){
                cur.next.put(c,new Node());
            }
            cur = cur.next.get(c) ;
        }
        cur.value = val ;
    }

    public int sum(String prefix) {
        Node cur = root ;

        char[] chars = prefix.toCharArray() ;
        for (char ch : chars){
            Node next = cur.next.get(ch);
            if(next == null)
                return 0  ;
            cur = next ;
        }
        return sum(cur) ;
    }

    private int sum(Node node){

        int res = node.value;

        for(char c : node.next.keySet()){
            res += sum(node.next.get(c)) ;
        }
        return res;
    }

    private class Node{
        public int value ;
        /**
         * 指向下一个字母节点
         */
        public TreeMap<Character, Node> next;

        public Node(int value){
            this.value = value ;
            next = new TreeMap<>();
        }

        public Node(){
            this(0) ;
        }
    }
}
