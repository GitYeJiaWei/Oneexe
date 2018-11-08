package com.mycollections;
/**
 * * A:泛型接口概述
 * 把泛型定义在接口上
 * B:定义格式
 * public interface 接口名<泛型类型>
 * C:案例演示
 * 泛型接口的使用
 *
 * 	 * * A:泛型通配符<?>
 * 			* 任意类型，如果没有明确，那么就是Object以及任意的Java类了
 * 		* B:? extends E
 * 			* 向下限定，E及其子类
 * 		* C:? super E
 * 			* 向上限定，E及其父类
 *
 */
public class Demo_Generic {
    public static void main(String[] args) {
        InfoImpl info = new InfoImpl("skjdf");
        System.out.println(info.getVar());

        Demo<String> demo = new Demo<>("asfwef");
        System.out.println(demo.getVar());
    }
}

interface Info<T>{        // 在接口上定义泛型
    public T getVar() ; // 定义抽象方法，抽象方法的返回值就是泛型类型
    public void setVar(T x);
}

//非泛型类
class InfoImpl implements Info<String>{   // 定义泛型接口的子类
    private String var ;                // 定义属性
    public InfoImpl(String var){        // 通过构造方法设置属性内容
        this.setVar(var) ;
    }
    @Override
    public void setVar(String var){
        this.var = var ;
    }
    @Override
    public String getVar(){
        return this.var ;
    }
}

//泛型类
//在这个类中，我们构造了一个泛型类InfoImpl<T>，然后把泛型变量T传给了Info<T>，这说明接口和泛型类使用的都是同一个泛型变量。
class Demo<T> implements Info<T>{
    private T var;

    public Demo(T vart){
        this.setVar(vart);
    }

    @Override
    public T getVar() {
        return this.var;
    }

    @Override
    public void setVar(T x) {
        this.var = x;
    }
}
