package github.jasonpang23.反转字符串中的元音字母_345;

import java.util.Arrays;

/**
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "hello"
 * 输出: "holle"
 * 示例 2:
 * <p>
 * 输入: "leetcode"
 * 输出: "leotcede"
 * 说明:
 * 元音字母不包含字母"y"。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray() ;
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            while (l < r && isVowel(chars[l])) l++;
            while (l < r && isVowel(chars[r])) r--;
            if(l < r){
                swap(chars,l,r) ;
                l ++ ;
                r -- ;
            }
        }

        return new String(chars);
    }

    private boolean isVowel(char c) {
        return c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u'
                && c != 'A' && c != 'E' && c != 'I' && c != 'O' && c!='U';
    }

    private void swap(char [] chars ,int a,int b){
        char temp = chars[a] ;
        chars[a] = chars[b] ;
        chars[b] = temp ;
    }

    public static void main(String[] args) {
        String result = new Solution().reverseVowels("hello");
        System.out.println(result);
    }

}
