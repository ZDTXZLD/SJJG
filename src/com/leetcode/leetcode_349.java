package com.leetcode;

import java.util.ArrayList;
import java.util.TreeSet;

/*
* 两个数组的交集   不考虑重复元素
* */
public class leetcode_349 {
    public int[] intersection(int[]num1,int[]num2){
        TreeSet<Integer> set = new TreeSet<>();
        for(int num:num1)
            set.add(num);
        ArrayList<Integer> list = new ArrayList<>();
        for(int num:num2) {
            if (set.contains(num)) {
                list.add(num);
                set.remove(num);
            }
        }
        int []res=new int[list.size()];
        for(int i=0;i<list.size();i++){
            res[i]=list.get(i);
        }
        return res;
      }
}
