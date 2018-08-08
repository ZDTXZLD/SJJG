package com.tree;

import com.array.Array;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public  static  void  main(String[]args){
        BST<Integer> bst=new BST<>();
//        int []nums={5,3,6,8,4,2};
//        for(int num:nums)
//            bst.add(num);
//        bst.preOrder();
//        System.out.println();
//        bst.inOrder();
//        System.out.println();
//        bst.postOrder();
//        System.out.println();
//        bst.preOrderNR();
//        System.out.println();
//        bst.levelOrder();
      int n=1000;
        Random random=new Random();
      for(int i=0;i<n;i++){
             bst.add(random.nextInt(1000));
      }
        ArrayList<Integer> nums =new ArrayList<>();
        while (!bst.isEmpty())
            nums.add(bst.removeMin());
        System.out.println(nums);

        for(int i=1;i<nums.size();i++){
            if(nums.get(i-1)>nums.get(i))
                throw new IllegalArgumentException("Error");
        }
        System.out.println("remove test complete");

    }
}
