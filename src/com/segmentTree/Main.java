package com.segmentTree;

import javax.swing.text.Segment;

public class Main {
    public static void  main(String[]args){
        Integer[] nums={-2,0,3,-5,2,-1};
        segmentTree<Integer> segTree=new segmentTree<>(nums,(a,b)->a+b);
        System.out.println(segTree);
        System.out.println(segTree.query(0,2));
        System.out.println(segTree.query(2,4));
        System.out.println(segTree.query(0,5));

    }
}
