package com.leetcode;
/*
* 递归深度  每调用一次自己  递归深度加一
* * */
public class leetcode_203_2 {

    public  ListNode removeElements(ListNode head,int val,int depth){
        //递归深度
        String depthString=genereateDepthString(depth);
        System.out.println(depthString);
        System.out.println("Call:remove"+val+"in"+head);
        if(head==null) {
           System.out.print(depthString);
           System.out.println("Return"+head);
            return head;
        }
        ListNode res=removeElements(head.next,val,depth+1);
        System.out.println(depthString);
        System.out.println("After remove"+val+":"+res);
        ListNode ret;
        if(head.val==val)
           ret=res;
        else {
            head.next=res;
            ret= head;
        }
        System.out.println(depthString);
        return  ret;

    }

    private String genereateDepthString(int depth) {
       StringBuilder res=new StringBuilder();
       for(int i=0;i<depth;i++)
           res.append("--");
       return  res.toString();
    }

    public  static  void  main(String[]args){

        int[]nums={1,2,3,4,5,6,7,8};
        ListNode  head=new ListNode(nums);
        System.out.println(head);
        ListNode res=(new leetcode_203_2()).removeElements(head,5,0);
        System.out.println(res);
    }
}
