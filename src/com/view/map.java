package com.view;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

public class map {
    public static void main(String[] args){
        //线程不安全的
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("","");

        //Hashtable线程安全，但效率低，因为是Hashtable是使用synchronized的，所有线程竞争同一把锁
        Hashtable<String,String> hashtable =new Hashtable<>();
        hashtable.put("","");

        //不仅线程安全而且效率高，因为它包含一个segment数组，将数据分段存储，给每一段数据配一把锁，也就是所谓的锁分段技术
        ConcurrentHashMap<String,String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("","");
        concurrentHashMap.get("");
    }
}
