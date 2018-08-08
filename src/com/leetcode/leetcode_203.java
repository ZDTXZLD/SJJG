package com.leetcode;
/*
* 删除链表中的元素   给定值所有的元素
* */
/**public   class ListNode{
 *    int val;
 *    ListNode next;
 *    ListNode(int x){val=x;}
 * }
 */
public class leetcode_203 {
    public  ListNode  removeElements(ListNode head,int val){
         while(head!=null&&head.val==val){
             head=head.next;
         }
          if(head==null)
              return  null;
         ListNode prev=head;
         while(prev.next!=null){
             if(prev.next.val==val){
                 prev.next=prev.next.next;
             }
             else
                 prev=prev.next;
         }
        return  head;
    }
}
