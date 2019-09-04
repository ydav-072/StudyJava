package ru.study.generic;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
//h
public class GenericExample {
    public static void main(String[] args) {
        GenericExample genericExample = new GenericExample();
        genericExample.someMethod("it's String");
        genericExample.someMethod2(123, "String", new File("path"));
        NewClass<String>  someClass= new NewClass<>();
        someClass.var = "String";
        List<String> strings = new ArrayList<>();//now we can add only String in Collection
        List list = new ArrayList();//we can add every type in Collection it's very bad
    }
    //example generic method
    <T> T someMethod(T type){
        System.out.println("something do");
        return type;
    }
    <T, U, K> void someMethod2(T type, U u, K k){

    }
    <E> void someMethod3(){
        System.out.println("bla");
    }
}
//example generic Class and varible
class NewClass <T>{
    T var;
}
//для работы с ками-то методами мы может в дженерики наследовать другие интерфейсы,
// если мы наследуем класс тогда мы его указываем первым и получаем возможность использовать различные методы этих
//интерфейсов и классов, иначе нам доступны только методы Object
class  NewClass2<E extends Comparable & Serializable>{
}
// in byteCode we can see somthig this
class MyClass {
    Object type;
    Object someMethod(Object type){
        return type;
    }
}