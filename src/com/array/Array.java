package com.array;
/*
* 动态数组的自己实现
*
* 增删改查    容量的大小
* size控制数组存放索引的长度
* */
public class Array<E> {
      private E[] data;
      private int size;
    /**
     * 构造函数,传入数组的容量capacity构造Array
     * @param capacity
     */
      public Array(int capacity){
          data=(E[])new Object[capacity];
          size=0;
      }
      public Array(E[]arr){
          data=(E[])new  Object[arr.length];
        for(int i=0;i<arr.length;i++)
            data[i]=arr[i];
        size=arr.length;
      }
    /*
     *  编译器提供的代码提示的一部分  默认的长度
     *   无参数的构造方法,默认数组的容量为10
     */
      public  Array(){
          this(10);
      }
      //获取数组中的元素个数
       public int getSize(){
          return  size;
       }
       //获取数组的容量
       public int  getCapacity(){
          return data.length;
       }
       //判断数组是否为空
       public boolean  isEmpty(){
          return size==0;
       }
       //向所有元素后添加一个新元素
       public void   addLast(E  e){
         add(size,e);
       }
       //在所有元素添加一个新的元素
        public   void  addFirst(E e){
             add(0,e);
        }
        //判断数组中是否有元素
        public boolean contains(E e){
          for(int i=0;i<size;i++){
              if(data[i].equals(e))
                  return  true;
          }
          return  false;
        }

        //查找数组中元素e所在的索引,如果不存在元素e，则返回-1
       public  int find(E e){
          for(int i=0;i<size;i++){
              if(data[i]==e);
              return  i;
          }
          return  -1;

       }
       //从数组中删除index位置的元素,返回删除的元素
       public E remove(int index){
           if(index<0||index>=size)
               throw new IllegalArgumentException("Remove failed.Index is illegal");
           E ret=data[index];
           for(int i=index+1;i<size;i++)
               data[i-1]=data[i];
           size--;
           data[size]=null;  //手动回收,优化代码
           if(size==data.length/4)     //防止复杂度震荡
               resize(data.length/2);
           return ret;
       }

       //从数组中删除第一个元素,返回删除的元素
        public E removeFirst(){
          return remove(0);
        }
        //从数组中删除最后一个元素,返回删除的元素
        public E removeLast(){
          return remove(size-1);
        }

        //从数组中删除元素e   只删除了一个
         public  void  removeElement(E e){
          int index=find(e);
          if(index!=1)
              remove(index);
         }

       //向指定index位置插入参数
       public void  add(int index,E e){
           if(index<0 || index > size)
               throw new IllegalArgumentException("Add failed,index is bad");
           if(size==data.length)
               resize(2*data.length);

           for(int i=size-1;i>=index;i--)
                 data[i+1]=data[i];
           data[index]= e;
           size++;
       }

         private void resize(int newCapacoty) {
              E[] newData=(E[])new Object[newCapacoty];
              for(int i=0;i<size;i++)
                  newData[i]=data[i];
              data=newData;
      }

    //获取index索引位置的元素
        public   E get(int index){
          if(index<0||index>=size)
              throw new IllegalArgumentException("Get failed.Index is illegal");
          return data[index];
       }
       //设置值
       public void set(int index ,E e){
          if(index<0||index>=size)
              throw new IllegalArgumentException("Get failed.Index is illegal");
          data[index]=e;
       }

       public void swap(int i,int j){
          if(i<0||i>size||j<0||j>=size)
              throw new IllegalArgumentException("Index is illegal");
             E t=data[i];
             data[i]=data[j];
             data[j]=t;
      }


       @Override
       public String toString(){
         StringBuilder  res=new StringBuilder();
         res.append(String.format("Array:size=%d,capacity=%d\n",size,data.length));
         res.append("[");
         for(int i=0;i<size;i++){
             res.append(data[i]);
             if(i!=size-1)
                 res.append(",");
         }
         res.append("]");
         return res.toString();
      }

      //获取最后一个值
      public E getLast(){
          return get(size-1);
      }
      public E getFirst(){
          return get(0);
      }


}
