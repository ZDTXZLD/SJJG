package com.LinkedList;

/*
 * 链表  适合增删   查表头  O(1)
 * addLast(e) O(n)      addFirst(e)  O(1)         add(index,e)   O(n/2)=O(n)
 * 修改   O(n)    set(index,e)  O(n)
 * 查找  get(inedx) O(n)   contains(e)   O(n)
 * */
public class LinkedList<E> {
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    //虚拟的头节点
    Node dummyhead;
    //长度
    int size;

    public LinkedList() {
        dummyhead = new Node(null, null);
        size = 0;
    }

    //返回链表中个数
    public int getSize() {
        return size;
    }

    //返回链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //在链表头添加新的元素e
    public void addFirst(E e) {
//            Node node=new Node(e);
//            node.next=head;
//            head=node;

        dummyhead = new Node(null, new Node(e, dummyhead.next));
        size++;
    }

    //在链表中间添加元素   关键:找到待添加节点的前一个节点  顺序很重要
    //使用链表通常不使用索引
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed.Illegal index.");
        Node prev = dummyhead.next;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size++;
    }

    //在链表末尾添加新的元素e
    public void addLast(E e) {
        add(size, e);
    }

    //获取链表的第index(0-based)个位置的元素
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed,Illegal Index.");
        Node cur = dummyhead.next;
        for (int i = 0; i < index; i++)
            cur = cur.next;
        return cur.e;
    }

    //获得链表的第一个元素
    public E getFirst() {
        return get(0);
    }

    //获取链表的最后一个元素
    public E getLast() {
        return get(size - 1);
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Update failed");

        Node cur = dummyhead.next;
        for (int i = 0; i < index; i++)
            cur = cur.next;
        cur.e = e;
    }

    //查找链表中是否有元素e
    public boolean contains(E e) {
        Node cur = dummyhead.next;
        while (cur != null) {
            if (cur.e.equals(e))
                return true;
            cur = cur.next;
        }
        return false;
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
//        Node cur=dummyhead.next;
//        while (cur!=null){
//            res.append(cur+"->");
//            cur=cur.next;
//        }
        for (Node cur = dummyhead.next; cur != null; cur = cur.next) {
            res.append(cur + "->");
        }
        res.append("Null");
//        return  res.toString();
        return res.toString();
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    //从链表中删除元素
    public E remove(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed.Illegal index.");
        Node prev = dummyhead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;
        return retNode.e;
    }

    public void removeElement(E e) {
        Node  prev=dummyhead;
        while(prev.next!=null){
            if(prev.next.e.equals(e))
                break;
            prev=prev.next;
        }
        if(prev.next!=null){
            Node delNode=prev.next;
            prev.next=delNode.next;
            delNode.next=null;
        }
    }

}

