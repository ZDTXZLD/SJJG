package com.Set;

import com.tree.BST;

//基于二分搜索树创建的集合
public class BSTSet <E extends  Comparable<E>>implements  Set<E> {

    private BST<E>  bst;
    public  BSTSet(){
        bst=new BST<>();
    }
    public int getSize(){
        return bst.size();
    }
    public boolean isEmpty(){
        return  bst.isEmpty();
    }

    public  void add(E e){
        bst.add(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    public void remove(E e){
       bst.remove(e);
    }
}
