package github.jasonpang23.data_structures.set.唯一摩尔斯密码词_804;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] arr = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        Set<String> set = new HashSet<>() ;
        for(String string : words){
            StringBuilder stringBuilderg = new StringBuilder() ;
            char[] chars = string.toCharArray();
            for (char aChar : chars) {
                stringBuilderg.append(arr[aChar - 'a']);
            }
            set.add(stringBuilderg.toString()) ;
        }

        return set.size() ;
    }
}