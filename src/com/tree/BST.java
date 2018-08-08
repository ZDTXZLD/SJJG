package com.tree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//BST数必须有可比较性
public class BST<E extends  Comparable<E>> {
   //二分搜索树节点
   private class Node{
      public E e;
      public  Node  left,right;
      public  Node(E e){
          this.e=e;
          left=null;
          right=null;
      }
   }
   private  Node  root;
   private  int  size;
   public  BST(){
       root=null;
       size=0;
   }
   public   int size(){
       return  size;
   }
    public  boolean isEmpty(){
       return  size==0;
    }

    /**
     *   向二分搜索树添加新元素  这个二分搜索树不包含重复元素
     *   左子树小于等于节点;或者右节点大于节点
     *   二分搜索树添加元素的非递归算法和链表很像   递归算法有很高的开销
     *   树结构  递归比非递归简单
     */
     public  void  add(E e){
         //第一种  进行非空判断
         /*
         *              if(root==null){
             root=new Node(e);
             size++;
         }else
             add(root,e);
         * */
            root=add(root,e);
     }
     //向以node为根的二分搜索数插入元素E,递归算法
    private  Node add(Node node,E e){
         //第一种   void 无返回值
//      if(e.equals(node.e))
//          return;
//      else  if(e.compareTo(node.e)<0 && node.left==null){
//          node.left=new Node(e);
//          size++;
//          return;
//      }
//      else  if(e.compareTo(node.e)>0 && node.right==null){
//          node.right=new Node(e);
//          size++;
//          return;
//      }
//      if(e.compareTo(node.e)<0)
//          add(node.left,e);
//      else
//          add(node.right,e);
//    }
     // 向以node为根的二分搜索树中插入元素e,递归算法
        // 返回插入新节点后二分搜索树的根
     if(node==null){
         size++;
         return new Node(e);
     }
     if(e.compareTo(node.e)<0){
         node.left=add(node.left,e);
     }else if(e.compareTo(node.e)>0){
         node.right=add(node.right,e);
     }
       return  node;
     }
     //判断是否有
     public  boolean contains(E e){
          return  contains(root,e);
     }
     //看以node为跟的二分搜索树中是否包含元素e.递归算法
     private  boolean contains(Node node,E e){
         if(node==null)
             return false;
         if(e.compareTo(node.e)==0)
              return  true;
         else if(e.compareTo(node.e)<0)
              return  contains(node.left,e);
         else //e.compareTo(node.e)>0
              return  contains(node.right,e);
     }
     //遍历操作就是所有节点都访问一遍
     //遍历操作,左子树和右子树都要注意
    //二分搜索树前序遍历
    public void preOrder(){
         preOrder(root);
     }
     //前序遍历以node为根的二分搜索树,递归算法
     private  void preOrder(Node node) {
         if (node == null)
             return;
             System.out.println(node.e);
             preOrder(node.left);
             preOrder(node.right);
     }
     //中序遍历
    public void inOrder(){
         inOrder(root);
    }
    //中序遍历以node为根的二分搜索树,递归算法
    private  void  inOrder(Node node){
         if(node==null)
             return;
         inOrder(node.left);
         System.out.println(node.e);
         inOrder(node.right);
    }

    //后序遍历
    public void postOrder(){
         postOrder(root);
    }
    //后序遍历以Node为根的二分搜索树,递归算法
    private void postOrder(Node node){
         if(node==null)
             return;
         postOrder(node.left);
         postOrder(node.right);
         System.out.println(node.e);
    }
     public  String toSting(){
         StringBuilder res=new StringBuilder();
         generateBSTString(root,0,res);
         return  res.toString();
     }
      //生成以node为根节点,深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node, int depth, StringBuilder res) {
           if(node==null) {
               res.append(generateBSTString(depth)+"null\n");
               return;
           }
           res.append(generateBSTString(depth)+node.e+"\n");
           generateBSTString(node.left,depth+1,res);
           generateBSTString(node.right,depth+1,res);
     }
     private  String generateBSTString(int depth){
          StringBuilder res=new StringBuilder();
          for(int i=0;i<depth;i++)
              res.append("--");
          return  res.toString();
     }

     //二分搜索树前序遍历的非递归实现   利用栈来模拟栈    前序 先压右孩子再压左孩子 因为是反的
     public  void  preOrderNR(){
         Stack<Node>  stack=new Stack<>();
         stack.push(root);
         while (!stack.isEmpty()){
             Node cur=stack.pop();
             System.out.println(cur.e);
             if(cur.right!=null)
                  stack.push(cur.right);
             if(cur.left!=null)
                  stack.push(cur.left);
         }
     }

     //二分搜索树的层序遍历 从头开始从头遍历  广度优先遍历 逐层向下在广度下扩展
     //使用队列实现  左孩子 右孩子入队  下来拿出左孩子的左右孩子入队 用于搜索策略上
    public  void  levelOrder(){
        Queue<Node>  q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node cur=q.remove();
            System.out.println(cur.e);
            if(cur.left!=null)
                q.add(cur.left);
            if(cur.right!=null)
                q.add(cur.right);
        }
     }


    //寻找二分搜索树的最小元素
    public E minimum(){
         if(size==0)
             throw new IllegalArgumentException("Bst is  Empty");
         return  minimum(root).e;
    }
    //返回node为根的二分搜索树的最小值
    private  Node minimum(Node node){
         if(node.left==null)
             return  node;
         return  minimum(node.left);
    }
    //寻找二分搜索树的最大元素
    public E maximum(){
        if(size==0)
            throw new IllegalArgumentException("Bst is  Empty");
        return  maximum(root).e;
    }
    //返回以node为根的二分搜索书的最大值
    private Node  maximum(Node node){
         if(node.right==null)
             return  node;
         return  maximum(node.right);
    }

    //删除最小值所在的节点  返回值
    public  E removeMin(){
         E ret=minimum();
         root= removeMin(root);
         return  ret;
    }
    //删除以node为根的二分搜索树的最小接待你
    //返回删除节点后的二分搜索树的根
    private  Node removeMin(Node node){
         if(node.left==null){
             Node  rightNode=node.right;
             node.right=null;
             size--;
             return rightNode;
         }
         node.left=removeMin(node.left);
         return  node;
     }

     //删除二分搜索树中的最大值所在节点
    public  E removeMax(){
         E ret=maximum();
         root=removeMax(root);
         return ret;
    }
    //删除掉以Node为根的二分搜索树
    //返回删除节点后的新二分搜索树的根
    public  Node removeMax(Node node){
         if(node.right==null) {
             Node leftNode = node.right;
             node.left = null;
             size--;
             return leftNode;
         }
         node.right=removeMax(node.right);
         return  node;
    }

    //从二分搜索树删除元素为e的节点
    public  void  remove(E e){
      root=remove(root,e);
    }
    //删除以node为根的二分搜索树中值为e的节点,递归算法
    //返回删除节点后新的二分搜索树的根
    private  Node remove(Node node,E e){

         if(node==null)
             return  null;
         if(e.compareTo(node.e)<0){
             node.left=remove(node.left,e);
             return  node;
         }
         else if(e.compareTo(node.e)>0){
             node.right=remove(node.right,e);
             return node;
         }
         else {  //e==node.e
             //待删除节点左子树为空的情况
             if(node.left==null){
                 Node rightNode=node.right;
                 node.right=null;
                 size--;
                 return rightNode;
             }
             //待删除节点右子树为空的情况
             if(node.right==null){
                 Node leftNode=node.left;
                 node.left=null;
                 size--;
                 return leftNode;
             }
             //删除节点左右子树均不为空
             //找到比待删除节点大的最小节点,待删除节点右子树的最小节点
             //用这个节点顶替待删除节点的位置
             Node succrssor=minimum(node.right);
             succrssor.right=removeMin(node.right);
             succrssor.left=node.left;
             node.left=node.right=null;
             return succrssor;
         }
     }

}
