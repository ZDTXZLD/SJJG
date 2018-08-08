package com.Trie;


import java.util.TreeMap;

/*
* 字典树   映射称为字典
* 字典 如果有n个条目 使用树结构 查询的时间复杂度是O(logn)
* 如果有100万个(2^20) logn大概为20
*
* Trie
* 查询的每个条目的时间复杂度 和字典中一共多少条目无关
* 时间复杂度为O(w) w为查询单词的长度
* 大多数单词的长度小于10
*
* 每个字符串为节点分开
* */
public class Trie {
     private class Node{
        public boolean isWord;  //是否已经找到一个单词
        public TreeMap<Character,Node> next;

        public Node(boolean isWord){
            this.isWord=isWord;
            next=new TreeMap<>();
        }
        public Node(){
            this(false);
        }
     }
    private  Node root;
     private  int size;
     public   Trie(){
         root=new Node();
         size=0;
     }
     //获取Trie中存储的单词数量
    public int getSize(){
         return size;
    }
    //向Trie中添加一个新的单词word
    public void  add(String word){
         Node cur=root;
         for(int i=0;i<word.length();i++){
             char c=word.charAt(i);
             if(cur.next.get(c)==null)
                 cur.next.put(c,new Node());
             cur=cur.next.get(c);
         }
         if(!cur.isWord){
             //已经在末尾了
             cur.isWord=true;
             size++;
         }
    }

    //查询单词word是否在Trie中
    public boolean contains(String word){
         Node cur=root;
         for(int i=0;i<word.length();i++){
             char c=word.charAt(i);
             if(cur.next.get(c)==null)
                 return false;
             cur=cur.next.get(c);
         }
         return cur.isWord;
     }

     //查询是否在Trie中有单词以prefix为前缀
     public  boolean isPrefix(String  prefix){
         Node cur=root;
        for(int i=0;i<prefix.length();i++){
            char c=prefix.charAt(i);
            if(cur.next.get(c)==null)
                return false;
            cur=cur.next.get(c);
        }
        return true;
     }
}
