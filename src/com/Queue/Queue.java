package com.Queue;
/*
* 队列是一种先进先出的数据结构
* FIFO
* */
public interface Queue<E> {

    void enqueue(E e);    //O(1)  均摊
    E dequeue();           //O(n)
    E  getFront();         //O(1)
    int getSize();         //O(1)
    boolean isEmpty();    //O(1)


}
