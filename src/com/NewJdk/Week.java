package com.NewJdk;

public class Week {
    public static final Week MON = new Week("星期一");
    public static final Week TUE = new Week("星期二");
    public static final Week WED = new Week("星期三");

    private String name;
    private Week(String name){
        this.name = name;
    }						//私有构造,不让其他类创建本类对象
    public String getName() {
        return name;
    }
}
