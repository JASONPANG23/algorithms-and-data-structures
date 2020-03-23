package github.jasonpang23.验证回文串_125;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase() ;
        int l = 0 ;
        int r = s.length() -1 ;
        while(l < r){

            while(l < r && !Character.isLetterOrDigit(s.charAt(l)))  l ++ ;
            while(l < r && !Character.isLetterOrDigit(s.charAt(r)))  r-- ;
            if(s.charAt(l) == s.charAt(r)){
                l ++ ;
                r -- ;
            }else{
                return false ;
            }

        }
        return true ;
    }

    public static void main(String[] args) {
        boolean result = new Solution().isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(result);
        result = new Solution().isPalindrome("race a car");
        System.out.println(result);
    }
}
