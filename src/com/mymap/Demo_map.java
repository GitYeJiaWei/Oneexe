package com.mymap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * * A:Map集合的功能概述
 * a:添加功能
 * V put(K key,V value):添加元素。
 * 如果键是第一次存储，就直接存储元素，返回null
 * 如果键不是第一次存在，就用值把以前的值替换掉，返回以前的值
 * b:删除功能
 * void clear():移除所有的键值对元素
 * V remove(Object key)：根据键删除键值对元素，并把值返回
 * c:判断功能
 * boolean containsKey(Object key)：判断集合是否包含指定的键
 * boolean containsValue(Object value):判断集合是否包含指定的值
 * boolean isEmpty()：判断集合是否为空
 * d:获取功能
 * Set<Map.Entry<K,V>> entrySet():
 * V get(Object key):根据键获取值
 * Set<K> keySet():获取集合中所有键的集合
 * Collection<V> values():获取集合中所有值的集合
 * e:长度功能
 * int size()：返回集合中的键值对的个数
 * 面试题
 * 	 * HashMap和Hashtable的区别
 * 	 * 共同点:
 * 	 * 底层都是哈希算法,都是双列集合
 * 	 * 区别:
 * 	 * 1,HashMap是线程不安全的,效率高,JDK1.2版本
 * 	 *   Hashtable是线程安全的,效率低,JDK1.0版本的
 * 	 * 2,HashMap可以存储null键和null值
 * 	 *   Hashtable不可以存储null键和null值
 */
public class Demo_map {
    public static void main(String[] args){
        demo1();
    }

    public static void demo1(){
        Map<String,Integer> map = new HashMap<>();
        map.put("张三", 23);
        map.put("李四", 24);
        map.put("王五", 25);
        map.put("赵六", 26);

        Collection<Integer> c = map.values();
        System.out.println(c);
        System.out.println(map);
        System.out.println(map.get("zhaosan"));

        System.out.println(map.containsKey("张三"));
        System.out.println(map.containsValue(12));

        for (String key:map.keySet()){          //获取所有的KEY值
            System.out.println(key);
        }

        for (Integer values:map.values()){      //获取所有的value值
            System.out.println(values);
        }

        for (Map.Entry<String,Integer> map1:map.entrySet()){       //获取键值对对象
            System.out.println(map1.getKey()+"--"+map1.getValue());
        }

        HashMap<String, Integer> hm = new HashMap<>();
        hm.put(null, 23);
        hm.put(null,24);
        hm.put("李四", null);
        System.out.println(hm.get(null));

		Hashtable<String, Integer> ht = new Hashtable<>();
		//ht.put(null, 23);                     //hashtable不能存储Null值，hashmap可以存储null
		//ht.put("张三", null);
        ht.put("zhangsan",12);
		System.out.println(ht);

    }
}
