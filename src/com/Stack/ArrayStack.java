package com.Stack;

import com.array.Array;

public class ArrayStack<E>  implements  Stack<E>{
    //基于动态数组实现
    Array<E> array;
    public  ArrayStack(int capacity){
        array=new Array<>(capacity);
    }

    public  ArrayStack(){
        array=new Array<>();
    }
    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(E e) {
      array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }
    //获取最后一个元素
    @Override
    public E  peek() {
       return array.getLast();
    }

    //获取栈的容量
    public  int getCapacity(){
        return  array.getCapacity();
    }

    public String toString(){
        StringBuilder res=new StringBuilder();
        res.append("Stack:");
        res.append('[');
        for(int i=0;i<array.getSize();i++) {
            res.append(array.get(i));
            if(i!=array.getSize()-1)
                res.append(",");
        }
        res.append("] top");
        return res.toString();
    }
}
