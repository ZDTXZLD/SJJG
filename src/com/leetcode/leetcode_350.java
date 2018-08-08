package com.leetcode;

import java.util.ArrayList;
import java.util.TreeMap;

//两个数组的交集 包含重重复元素
public class leetcode_350 {
    public  int[] intersect(int[] num1,int[]num2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : num1) {
            if (!map.containsKey(num))
                map.put(num, 1);
            else
                map.put(num, map.get(num) + 1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : num2) {
            if (map.containsKey(num)) {
                list.add(num);
                map.put(num, map.get(num) - 1);
                if (map.get(num) == 0)
                    map.remove(num);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
                   res[i] = list.get(i);
            return res;
    }
}
