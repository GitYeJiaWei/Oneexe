package com.list;
/**
 * * A:泛型接口概述
 * 把泛型定义在接口上
 * B:定义格式
 * public interface 接口名<泛型类型>
 * C:案例演示
 * 泛型接口的使用
 */
public class Demo_Generic {
    public static void main(String[] args) {
        Demo demo =new Demo();
        demo.show(new Srudent(23,"lkas"));
    }
}

interface Inter<T>{
     void show(T t);
}

class Demo implements Inter<Srudent> {		//推荐用这种

	@Override
	public void show(Srudent t) {
		System.out.println(t.getName());
	}

}

/*class Demo<T> implements Inter<T>{         //没有必要在实现接口的时候给自己类加泛型

    @Override
    public void show(T t) {
        System.out.println(t);
    }
}*/
