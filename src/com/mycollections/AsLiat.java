package com.mycollections;

import java.util.*;

/**
 * 数组转换成集合
 * 数组转换成集合虽然不能增加或减少元素,但是可以用集合的思想操作数组,也就是说可以使用其他集合中的方法
 */
public class AsLiat {
    public static void main(String[] args){
        //集合转数组,加泛型的
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        String[] arr = list.toArray(new String[10]);		//当集合转换数组时,数组长度如果是小于等于集合的size时,转换后的数组长度等于集合的size
        //如果数组的长度大于了size,分配的数组长度就和你指定的长度一样
        for (String string : arr) {
            System.out.println(string);
        }

        demo2();
        demo3();
        demo4();
        demo5();
        demo6();
    }

    public static void demo2() {
        //int[] arr = {11,22,33,44,55};
        //List<int[]> mycollections = Arrays.asList(arr);			基本数据类型的数组转换成集合,会将整个数组当作一个对象转换
        //System.out.println(mycollections);
        Integer[] arr = {11,22,33,44,55};					//将数组转换成集合,数组必须是引用数据类型
        List<Integer> list = Arrays.asList(arr);
        System.out.println(list);
    }

    public static void demo3() {
        String[] arr ={"asdf","asd","ads","ads"};
        List<String> list = Arrays.asList(arr);
        System.out.println(list);
    }

    public static void demo4(){
        ArrayList list = new ArrayList();				//创建集合对象
        list.add(new Srudent(12,"张三"));
        list.add(new Srudent(12,"张三"));
        list.add(new Srudent(34,"李四"));
        list.add(new Srudent(34,"李四"));


        ArrayList newList = getSingle(list);			//调用方法去除重复
        System.out.println(newList.size());

        list.remove(new Srudent(34,"李四"));
        System.out.println(list.size());

    }

    /*
     * 创建新集合将重复元素去掉
     * 1,明确返回值类型,返回ArrayList
     * 2,明确参数列表ArrayList
     *
     * 分析:
     * 1,创建新集合
     * 2,根据传入的集合(老集合)获取迭代器
     * 3,遍历老集合
     * 4,通过新集合判断是否包含老集合中的元素,如果包含就不添加,如果不包含就添加
     */
    public static ArrayList getSingle(ArrayList list) {
        ArrayList newList = new ArrayList<>();					//1,创建新集合
        Iterator it = list.iterator();							//2,根据传入的集合(老集合)获取迭代器

        while(it.hasNext()) {									//3,遍历老集合
            Object obj = it.next();								//记录住每一个元素
            if(!newList.contains(obj)) {						//如果新集合中不包含老集合中的元素
                newList.add(obj);								//将该元素添加
            }
        }

        return newList;
    }

    public static void demo5(){
        LinkedList list = new LinkedList();
        list.addFirst("a");
        list.addFirst("b");
        list.addFirst("c");
        list.addFirst("d");
        list.addLast("e");

        //System.out.println(mycollections.getFirst());
        //System.out.println(mycollections.getLast());
        //System.out.println(mycollections.removeFirst());
        //System.out.println(mycollections.removeLast());

        System.out.println(list.get(1));
        System.out.println(list);          /*dcbae*/

    }

    public static void demo6(){
        Stack s = new Stack();
        s.push("a");                  //进栈
        s.push("b");

        while (!s.empty()){                 //判断栈结构是否为空
            System.out.println(s.pop());    //弹栈
        }
    }
}
