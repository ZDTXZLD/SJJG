package com.segmentTree;
//融合器 将两个值合到一个
public interface Merger<E> {
    E merge(E a,E b);
}
