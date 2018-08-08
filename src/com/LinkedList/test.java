package com.LinkedList;

import com.Stack.ArrayStack;
import com.Stack.Stack;

import java.util.Random;

/*
* 测试ArrayStack和LinkListStack的时间
* */
public class test {
    //测试使用q运行opCount个push和pop操作所需要的时间
    private static  double testStack(Stack<Integer> stack, int opCount){
        long startTime=System.nanoTime();

        Random random = new Random();
        for(int i=0;i<opCount;i++)
            stack.push(random.nextInt(Integer.MAX_VALUE));
        for(int i=0;i<opCount;i++)
            stack.pop();
        long endTime=System.nanoTime();
        return (endTime-startTime)/1000000000.0;
    }
    public static  void main(String[]args){

        int opCount=10000000;
        ArrayStack<Integer> arrayStack=new ArrayStack<>();
        double time1=testStack(arrayStack,opCount);
        System.out.println("ArrayStack,time:"+time1+"ss");

      LinkedListStack<Integer>  linkedListStack=new LinkedListStack<>();
      double time2=testStack(linkedListStack,opCount);
      System.out.println("LinkedListStack,time:"+time2+"s");

    }
}
