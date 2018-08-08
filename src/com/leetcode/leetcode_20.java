package com.leetcode;


import com.Stack.ArrayStack;

/*
* 括号匹配  使用栈解决  匹配括号'(''[''{'是否与')'']''}'
* */
public class leetcode_20 {

    public  boolean isValid(String s){
        ArrayStack<Character> stack = new ArrayStack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('||c=='['||c=='{')
                stack.push(c);
            else{
                if(stack.isEmpty())
                    return false;
                char topChar=stack.pop();
                if(c==')'&&topChar!='(')
                    return false;
                if(c==']'&&topChar!='[')
                    return false;
                if(c=='{'&&topChar!='}')
                    return false;
            }
        }
       return  stack.isEmpty();
    }

    public static void main(String[]args){
      System.out.println((new leetcode_20()).isValid("[](){}"));
        System.out.println((new leetcode_20()).isValid("[()]{}"));
        System.out.println((new leetcode_20()).isValid("[()]{}}"));
    }

}
