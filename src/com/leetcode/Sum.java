package com.leetcode;

/*
    递归
* 递归求合
* 递归是将一个问题变成更小的问题  最基本的问题需要编写逻辑求解
* */
public class Sum {
   public   static   int sum(int[]arr){

       return  sum(arr,0);
   }
   //计算arr[l..n]这个区间的所有数字的和
   private  static  int  sum(int[]arr,int l ){
        if(l==arr.length)
            return  0;
        return  arr[l]+sum(arr,l+1);
   }

   public  static  void  main(String[]args){
       int nums[]={1,2,3,4,5,6,7,8};
       System.out.println((sum(nums)));
   }
}
