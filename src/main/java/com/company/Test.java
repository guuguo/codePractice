package com.company;

public class Test {
    public static final String s1 = "我是s1";
    public  final String s2 = "我是s2";
    public  static String s3 = "我是s3";
    public  static String s4 = "我是s3";
    public  final int i1 = 250;
    public  final int i2 = 250;
    public  final int i3 = 980;
    public  final int i4 = 980;
    public final Student student= new Student();
    static {
        String s_local="初始化了";
        System.out.println(s_local);
    }
}

class Student{
    String name="你好啊";
}