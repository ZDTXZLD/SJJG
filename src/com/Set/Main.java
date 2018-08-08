package com.Set;

import java.util.ArrayList;
/*
*       LinkedListSet  add  O(n)                                contains  O(n)    remove  O(n)
*       BSTSet              O(H)  平均O(logn)满的二叉树 最差成链表O(N)     O(H) O(logn)              O(H) H为深度
* */
public class Main {

    private static  double testSet(Set<String>set,String filename){
        long startTime=System.nanoTime();
        System.out.println(filename);
        ArrayList<String> words=new ArrayList<>();
        if(FileOperation.readFile(filename,words)){
            System.out.println("Total wordd:"+words.size());
            for(String word:words)
                set.add(word);
            System.out.println("Total different words"+set.getSize());
        }
        long endTime=System.nanoTime();
        return  (endTime-startTime)/10000000.0;
    }
    public static void main(String[]args){
      String filename="test.txt";
      BSTSet<String> bstSet=new BSTSet<>();
      double time1=testSet(bstSet,filename);
      System.out.println("BST Set:"+time1);

      LinkedListSet<String> linkedListSet=new LinkedListSet<>();
      double time2=testSet(linkedListSet,filename);
      System.out.println("Linked List Set"+time2);


    }
}
