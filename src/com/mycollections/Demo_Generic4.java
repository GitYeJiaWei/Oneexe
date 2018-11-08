package com.mycollections;

import java.util.List;
//使用Class<T>传递泛型类Class对象

public class Demo_Generic4 {
    public static void main(String[] args){

    }

    //有时，我们会遇到一个情况，比如，我们在使用JSON解析字符串的时候，代码一般是这样的
    public static List<SuccessModel> parseArray(String response){
        List<SuccessModel> modelList = parseArray(response, SuccessModel.class);
        return modelList;
    }


    //把SuccessModel单独抽出来做为泛型变量,Class<T> object来传递类的class对象,返回值中存在泛型
    public static <T> List<T> parseArray(String response,Class<T> object){
        List<T> modelList = parseArray(response, object);
        return modelList;
    }


}
//要泛型的类
class SuccessModel {
    private boolean success;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
