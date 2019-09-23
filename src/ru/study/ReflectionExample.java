package ru.study;

import java.lang.reflect.*;

public class ReflectionExample {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        SomeClass someClass = new SomeClass();//standart create class

        // 3 main method to get object Class with reflection
        // we can get access to varible, method, constructor, create instance this class without 'new'
        Class cls = someClass.getClass();
        Class cls1 = SomeClass.class;
        Class cls2 = Class.forName("ru.study.SomeClass");
        //create instance this class without 'new'
        SomeClass someClass1 =(SomeClass)cls.newInstance();//deprecated
        System.out.println(cls.getName());
        //все объявленные конструкторы в классе получаем в массив
        System.out.println("");
        System.out.println("Constructors: ");
        Constructor[] constructors = cls.getDeclaredConstructors();
        for (Constructor constructor : constructors){
            System.out.println(constructor.getName());
            Parameter[] parameters = constructor.getParameters();
            for (Parameter parameter : parameters){
                System.out.println(parameter.getName());
                System.out.println(parameter.getType().getName());
            }
        }
        System.out.println("");
        System.out.println("Methods");
        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods){
            System.out.println(method.getName());
            Parameter[] parameters = method.getParameters();
            for (Parameter parameter : parameters){
                System.out.println(parameter.getName());
                System.out.println(parameter.getType().getName());
            }
            System.out.println(Modifier.toString(method.getModifiers()));
            System.out.println(method.getReturnType().getName());
        }
        System.out.println("");
        System.out.println("Field");
        Field[] fields = cls.getFields();
        for (Field field : fields){
            System.out.println(field.getName());
            System.out.println(field.getType().getName());
            field.setAccessible(true);
            System.out.println(Modifier.toString(field.getModifiers()));
        }
    }
}
class SomeClass{
    private int varible;
    public String str;

    public SomeClass(){

    }
    public SomeClass(String s){
        this.str = s;
    }

    public synchronized String someMethod(String s){
        System.out.println("this is" + s);
        return s;
    }
}
