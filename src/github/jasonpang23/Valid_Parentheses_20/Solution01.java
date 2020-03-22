package github.jasonpang23.Valid_Parentheses_20;

import java.util.LinkedList;
import java.util.List;

public class Solution01 {
    public boolean isValid(String s) {

        if("".equals(s))
            return true ;

        char[] chArr = s.toCharArray() ;
        if(chArr.length % 2 != 0)
            return false ;

        List<Character> list = new LinkedList<>() ;
        int top = 0 ;
        for(char ch : chArr){
            if(ch=='{' || ch == '(' || ch =='['){
                list.add(top++,ch) ;
            }else{
                if(top == 0) return false ;
                char c = list.remove(--top);
                if(c == '(' && ch != ')') return false ;
                if(c == '{' && ch != '}') return false ;
                if(c == '[' && ch != ']') return false ;
            }
        }
        return top == 0;
    }
}
