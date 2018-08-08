package com.Heap;


import com.array.Array;

public class MaxHeap<E extends  Comparable> {
     private Array<E> data;
     public MaxHeap(int capacity){
         data=new Array<>(capacity);
     }

     public MaxHeap(){
       data=new Array<>();
     }

     public MaxHeap(E[]arr){
         data=new Array<>(arr);
         for(int i=arr.length-1;i>=0;i--)
             siftDown(i);
     }
     //返回堆中的元素个数
    public int size(){
         return  data.getSize();
    }
    //返回一个布尔值,便是队中是否为空
    public  boolean isEmpty(){
         return data.isEmpty();
     }
    //返回完全二叉树的数组表示中，一个索引所便是的元素的父亲节点的索引
    private int parent(int index){
         if(index==0)
             throw new  IllegalArgumentException("index does't   have parent");
         return (index-1)/2;
    }
    //返回完全二叉树的数组表示中,一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index){
         return index*2+1;
    }
    //返回完全二叉树的数组表示中,一个索引所表示的元素的右孩子的节点
    private int rightChild(int index) {
           return index*2+2;

     }
     //堆中添加一个元素相当于再最后面添加一个元素  从数组表示看,再索引为最后的元素添加进去
    //堆中添加元素
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k) {
        while (k>0 && data.get(parent(k)).compareTo(data.get(k))<0){
             data.swap(k,parent(k));
              k=parent(k);
        }
     }
     //查看队中最大元素
    public  E findMax(){
         if(data.getSize()==0)
             throw new IllegalArgumentException("heap is empty");
         return  data.get(0);
    }

    //取出堆中最大元素
    public  E extractMax(){
       E ret=findMax();
       data.swap(0,data.getSize()-1);
       data.removeLast();
       siftDown(0);

       return  ret;
    }

    private void siftDown(int k) {
               while (leftChild(k)<data.getSize()){
                   int j=leftChild(k);
                   if(j+1<data.getSize()&&data.get(j+1).compareTo(data.get(j))>0)
                       j=rightChild(k);
                   //data[j]是leftChild和rightChild的最大值
                   if(data.get(k).compareTo(data.get(j))>=0)
                       break;
                   data.swap(k,j);
                   k=j;
               }
     }
     //取出堆中最大得元素，并替换成元素e
    public  E repalce(E e){
         E ret=findMax();
         data.set(0,e);
         siftDown(0);
         return ret;
    }



}



