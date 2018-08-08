package com.array;
/*
* 数组最大优点：快速查询. s
* 数组最好应用 索引有语意
*
* 索引没有语义,如何表示没有数组
* 如何添加元素,如何删除元素
*
* */
public class Main {

    public static void main(String[] args) {
//        int[] arr = new int[20];
//        for (int i = 0; i < arr.length; i++)
//            arr[i] = i;
//        int[] scores = new int[]{100, 90, 66};
//        for (int j = 0; j < scores.length; j++)
//            System.out.print(scores[j]+" ");
//        for (int score : scores)
//            System.out.print(score+" ");
//        scores[0]=98;
//        for(int score:scores)
//            System.out.print(score+" ");
       Array<Integer> arr=new Array<>(20);
       for(int i=0;i<10;i++) {
           arr.addLast(i);
       }
       arr.add(1,100);
       System.out.println(arr);
       arr.addLast(-1);
       System.out.println(arr);
//       System.out.println(arr);
//       arr.add(1,100);
//       System.out.println(arr);
//       arr.addLast(-1);
//       System.out.println(arr);
//
//        arr.remove(2);
//        System.out.println(arr);
//
//        arr.removeElement(4);
//        arr.removeFirst();
//        System.out.println(arr);


    }

}
