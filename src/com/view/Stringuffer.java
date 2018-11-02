package com.view;

/*String和StringBuffer分别作为参数传递问题
			*
	基本数据类型的值传递,不改变其值
	引用数据类型的值传递,改变其值*/
public class Stringuffer {
    public static void main(String[] args){
        StringBuffer sb =new StringBuffer("asdf");
        sb.append("54");
        sb.append(true);
        sb.append(6546);                                        //可以把任意类型数据添加到字符串缓冲区里面,并返回字符串缓冲区本身
        sb.insert(3, "heima");						//在指定位置添加元素,如果没有指定位置的索引就会报索引越界异常

        System.out.println(sb.toString());
        sb.deleteCharAt(4);                                     //删除指定位置的字符，并返回本身
        System.out.println(sb.toString());
        sb.delete(2,5);                                         //删除从指定位置开始指定位置结束的内容，并返回本身,删除的时候是包含头,不包含尾
        System.out.println(sb.toString());

        sb.replace(0,3,"1234");                 //从start开始到end用str替换
        System.out.println(sb.toString());
        sb.reverse();                                             //字符串反转
        System.out.println(sb.toString());

        String str3 = sb.substring(4, 7);                          //截取从指定位置开始到结束位置，包括开始位置，不包括结束位置
        System.out.println(str3);                                  //注意:返回值类型不再是StringBuffer本身

        String str1 = new String(sb);                              //通过构造将StringBuffer转换为String
        System.out.println(str1);
    }
}
