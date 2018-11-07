package com.list;


import com.view.Equals;

public class Srudent {
    private int age;
    private String name;

    public Srudent(int age1,String name1){
        this.age =age1;
        this.name=name1;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //底层比较的是地址，重写该方法比较其内容
    @Override
    public boolean equals(Object obj) {
        if (this == obj)						//调用的对象和传入的对象是同一个对象
            return true;						//直接返回true
        if (obj == null)						//传入的对象为null
            return false;						//返回false
        if (getClass() != obj.getClass())		//判断两个对象对应的字节码文件是否是同一个字节码
            return false;						//如果不是直接返回false
        Srudent other = (Srudent) obj;			//向下转型
        if (age != other.age)					//调用对象的年龄不等于传入对象的年龄
            return false;						//返回false
        if (name == null) {						//调用对象的姓名为null
            if (other.name != null)				//传入对象的姓名不为null
                return false;					//返回false
        } else if (!name.equals(other.name))	//调用对象的姓名不等于传入对象的姓名
            return false;						//返回false
        return true;							//返回true
    }

    @Override
    public String toString() {
        return "name:"+this.name+" age:"+this.age;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

   /* @Override
    public boolean equals(Object obj) {
        if (obj instanceof Srudent){
            Srudent srudent = (Srudent) obj;
            if (this.name.equals(srudent.name) && this.age ==srudent.age){
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }*/
}
