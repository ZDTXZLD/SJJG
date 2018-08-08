package com.leetcode;

import java.util.LinkedList;
import java.util.List;

import com.Queue.PriorityQueue;
import java.util.TreeMap;

/*
*优先队列的问题  再10000000个元素中选出前100名
* 在N个元素中选出前M个元素
* 使用优先队列，维护当前看到的前M个元素   使用最小
*  题目:前K个高频元素
*
* */
public class leetcode_347 {

    private class Freq  implements  Comparable<Freq>{
        int e,freq;
        public Freq(int e,int freq){
            this.e=e;
            this.freq=freq;
        }
        public int compareTo(Freq another){
             if(this.freq<another.freq)
                 return 1;
             else if(this.freq>another.freq)
                 return -1;
             else
                 return 0;
        }
    }

    public List<Integer>  topKFrequent(int[]nums,int k){
        TreeMap<Integer,Integer>  map=new TreeMap<>();
        for(int num:nums){
            if(map.containsKey(num))
                  map.put(num,map.get(num)+1);
            else
                  map.put(num,1);
        }
        PriorityQueue<Freq>  pq=new PriorityQueue<>();
        for(int key:map.keySet()){
            if(pq.getSize()<k)
                pq.enqueue(new Freq(key,map.get(key)));
             else  if(map.get(key)>pq.getFront().freq){
                 pq.dequeue();
                 pq.enqueue(new Freq(key,map.get(key)));
            }
        }
        LinkedList<Integer> res=new LinkedList<>();
        while(!pq.isEmpty())
              res.add(pq.dequeue().e);
        return res;
    }


}
