package github.jasonpang23.data_structures.tree.trie;

import github.jasonpang23.data_structures.binary_search_tree.BST;
import github.jasonpang23.data_structures.set.BSTSet;

import java.util.ArrayList;
import java.util.List;

/**
 * 什么时Trie？
 * Trie查询每个条目的时间复杂度
 * 和条目总数无关
 * 时间复杂度为O(w)
 * w为查询单词的长度
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>() ;
        if(FileOperation.readFile("src/github/jasonpang23/data_structures/tree/trie/pride-and-prejudice.txt",words)){

            // 测试BSTSet
            long startTime = System.nanoTime() ;
            BSTSet<String> set = new BSTSet<>() ;
            for(String word:words)
                set.add(word);
            for (String word:words)
                set.contains(word) ;
            long endTime = System.nanoTime() ;
            double time = (endTime - startTime) / 1e9 ;
            System.out.println("Total different words:"+set.getSize());
            System.out.println("BSTSet :"+time+"s");

            // 测试Trie
            startTime = System.nanoTime() ;
            Trie trie = new Trie();
            for(String word:words)
                trie.add(word);
            for (String word:words)
                trie.contains(word) ;
            endTime = System.nanoTime() ;
            time = (endTime - startTime) / 1e9 ;
            System.out.println("Total different words:"+trie.getSize());
            System.out.println("BSTSet :"+time+"s");
        }
    }

}
