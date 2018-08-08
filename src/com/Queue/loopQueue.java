package com.Queue;

/*
* 循环队列,   再一次队列完之后  队尾指针又指向头指针
* void enqueue(E) O(1) 均摊
* void dequeue()  O(1) 均摊
* void getFront() O(1)
* int getSize()   O(1)
* boolean isEmpty()  O(1)
* */
public class loopQueue<E> implements Queue<E> {
    //容纳需要加一
    private E[] data;
    //入队元素的最新索引
    private int tail;
    //队首索引
    private int front;
    //队列长度
    private int size;

    public loopQueue(int capacity){
        data =(E[])  new Object[capacity+1];
        front=0;
        tail=0;
        size=0;
    }

    public loopQueue(){
        this(10);
    }
    @Override
    public void enqueue(E e) {
        if((tail+1)%data.length==front)
            resize(getCapacity()*2);
        data[tail]=e;
        tail=(tail+1)%data.length;
        size++;
    }


    private void resize(int newCapacity) {
        E[] newData=(E[])new Object[newCapacity+1];
        for(int i=0;i<size;i++)
            newData[i]=data[(i+front)%data.length];
        data=newData;
        front=0;
        tail=size;
    }

    @Override
    public E dequeue() {
       if(isEmpty())
           throw new IllegalArgumentException("Cannnot  dequeue from an empty queue");
       E ret=data[front];
       data[front]=null;
       front=(front+1)%data.length;
       size--;
       if(size==getCapacity()/4 && getCapacity()/2!=0)
           resize(getCapacity()/2);
       return ret;
    }

    @Override
    public E getFront() {
        if(isEmpty())
            throw new IllegalArgumentException("Queue is Empty");
        return  data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front==tail;
    }
    public int getCapacity(){
        return data.length-1;
    }
    @Override
    public String  toString(){
        StringBuilder  res=new StringBuilder();
        res.append(String.format("Queue:size=%d,capacity=%d\n",size,getCapacity()));
        res.append("front [");
        for(int i=front;i!=tail;i=(i+1)%data.length){
            res.append(data[i]);
            if((i+1)%data.length!=tail)
                res.append(",");
        }
        res.append("] tail");
        return res.toString();
    }
    public static void main(String[]args)
    {
        loopQueue<Integer>  queue=new loopQueue<>();
        for(int i=0;i<10;i++){
            queue.enqueue(i);
            System.out.println(queue);
            if(i%3==2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
