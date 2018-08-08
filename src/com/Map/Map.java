package com.Map;

/*
* 映射  一一对应   字典 dict  一一对应  eg:单词----频率   数据库id---信息
* 存储(键值对) key,value  根据键查找值
* 容易使用链表或者二分搜索树实现
* */
public interface Map<K,V> {
    void  add(K key,V value);
    V  remove(K key);
    boolean contains(K key);
    V  get(K key);
    void set(K key,V value);
    int getSize();
    boolean isEmpty();


}
