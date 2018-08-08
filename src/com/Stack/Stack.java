package com.Stack;

/*
* 栈也是一种线性结构
* 相对数组,栈对应的操作是数组的子集
* 只能从一端添加
*
* 栈是一种后进先出的数据结构(LIFO)
* */
/*
系统栈   记录方法的执行
Stack<E>
void push<E>    E pop()    E peek()   int getSize()   boolean isEmpty
* */
public interface Stack<E> {
     int  getSize();   //O(1)
     boolean isEmpty();  //O(1)
     void  push(E e);     //O(1)   均摊
     E   pop();            //O(1)  均摊
     E   peek();            //O(1)

}
