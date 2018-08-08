package com.Queue;

import com.Heap.MaxHeap;

/*
* 区别主要再出队  优先级最高的元素 先出
* 入队操作，出队操作    入队O(1)  出队O(n)
* 顺序线性结构          入队O(n)  出队O(1)
* 堆                     O(logn)   O(logn)
* */
//优先队列
public class PriorityQueue<E extends  Comparable<E>>  implements  Queue<E>{

private MaxHeap<E> maxHeap;
public  PriorityQueue(){
 maxHeap=new MaxHeap<>();
}
 @Override
 public void enqueue(E e) {
        maxHeap.add(e);
 }

 @Override
 public E dequeue() {
       return  maxHeap.extractMax();
 }

 @Override
 public E getFront() {
         return maxHeap.findMax();
 }

 @Override
 public int getSize() {
       return maxHeap.size();
 }

 @Override
 public boolean isEmpty() {
        return maxHeap.isEmpty();
 }
}
