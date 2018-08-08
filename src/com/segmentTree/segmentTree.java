package com.segmentTree;
/*
* ，每个节点存的是区间间的统计和   下列的区间再分为两个
*   每个阶段存储的是一个区间
*   不能被2平分不是一个满的二叉树   叶子节点不一定在最后一层
*   线段树满足平衡二叉树  最大深度和最小深度差距不超过1
*
*   区间有n个元素   数组需要多少个节点    满二差数  大改 2^h-1     最后一层2^(h-1)
*   最后一层的节点数大致等于前面所有层节点之和
*   如果n=2^k  只需要2n的空间             最坏情况 n=2^k+1
* */
//根节点是两个孩子节点信息的综合
/*
*            使用数组      使用线段树
* 更新         O(n)         O(logn)
* 查询         O(n)         O(logn)
* */
public class segmentTree<E> {
//线段树不考虑添加元素,区间固定
//开四倍的空间  使用空间换取效率
    private E[]data;
    private E[]tree; //讲线段树看成满的二叉树
    private Merger<E> merger;
    public segmentTree(E[]arr,Merger<E> merger){
         this.merger=merger;
        data=(E[])new Object[arr.length];
         for(int i=0;i<arr.length;i++)
             data[i]=arr[i];
         tree=(E[])new Object[4*arr.length];
         buildSegmentTree(0,0,data.length-1);
    }
    //在treeIndex位置创建区间 [l..r]的线段树
    private void buildSegmentTree(int treeIndex,int l,int r){

        if(l==r){
            tree[treeIndex]=data[l];
            return;
        }
        int leftTreeIndex=leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        int mid=l+(r-l)/2;
        //分为两个区间 l-mid   mid+1-r
        buildSegmentTree(leftTreeIndex,l,mid);
        buildSegmentTree(rightTreeIndex,mid+1,r);
        tree[treeIndex]=merger.merge(tree[leftTreeIndex],tree[rightTreeIndex]);

    }
    public E get(int index){
        if(index<0||index>data.length)
            throw new IllegalArgumentException("Index is illegal.");
        return data[index];
    }



    //返回完全二叉树的数组表示中,一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index){
        return 2*index+1;
    }

    //返回完全二叉树的数组表示中,一个索引所表示的元素的右孩子节点的索引
    private  int rightChild(int index) {
        return 2*index+2;
    }

    public String  toString(){
        StringBuilder  res=new StringBuilder();
        res.append("[");
        for(int i=0;i<tree.length;i++){
            if(tree[i]!=null)
                res.append(tree[i]);
            else
                res.append("null");
            if(i!=tree.length-1)
                res.append(',');
        }
        res.append(']');
        return  res.toString();
    }

    //线段树的区间查询
    //返回区间[queryL,queryR]的值
    public E query(int queryL,int queryR){
        if(queryL<0||queryL>=data.length||queryR<0||queryR>=data.length||queryL>queryR)
            throw new IllegalArgumentException("index is illegal");
        return query(0,0,data.length-1,queryL,queryR);
    }

    //在以treeID为根的线段树中[l..r]范围里，搜索区间[queryL,queryR]的值
    private E query(int treeIndex,int l,int r,int queryL,int queryR){
         if(l==queryL && r==queryR)
             return tree[treeIndex];
         int mid=l+(r-l)/2;
         int leftTreeIndex=leftChild(treeIndex);
         int rightTreeIndex=rightChild(treeIndex);
         if(queryL>=mid+1)
              return  query(rightTreeIndex,mid+1,r,queryL,queryR);
         else if(queryR<=mid)
               return  query(leftTreeIndex,l,mid,queryL,queryR);
         E leftResult=query(leftTreeIndex,l,mid,queryL,mid);
         E rightResullt=query(rightTreeIndex,mid+1,r,mid+1,queryR);
         return  merger.merge(leftResult,rightResullt);
    }

    //讲Index位置的值，更新为e
    public void set(int index,E e){
         if(index<0||index>=data.length)
             throw  new IllegalArgumentException("index is illegal");
         data[index]=e;
         set(0,0,data.length-1,index,e);
    }
      //在treeIndex为根的线段树进行更新Index值为e
    private void set(int treeIndex,int l,int r,int index,E e){
        if(l==r){
           tree[treeIndex]=e;
           return;
       }
       int mid=l+(r-l)/2;
       int leftTreeIndex=leftChild(treeIndex);
       int rightTreeIndex=rightChild(treeIndex);
       if(index>=mid+1)
           set(rightTreeIndex,mid+1,r,index,e);
       else
           set(leftTreeIndex,l,mid,index,e);
       tree[treeIndex]=merger.merge(tree[leftTreeIndex],tree[rightTreeIndex]);
    }

}
