package ru.study;

import java.io.IOException;

public class OverloadExample {
    public static int someMethod(int a, int b) throws IOException{
        return a+b;
    }
    protected final double someMethod(double a){
        return a;
    }

    public static void main(String[] args) throws Exception {
        OverloadExample overloadExample = new OverloadExample();
        OverloadChild overloadExampleChild = new OverloadChild();
        overloadExampleChild.someMethod(2);
        System.out.println(overloadExampleChild.someMethod(true));
        System.out.println(overloadExample.someMethod(12, 3));
        System.out.println(overloadExample.someMethod(3.1));
    }
}

class OverloadChild extends OverloadExample{
    void someMethod (int a) throws Exception {
        System.out.println("child int");
    }
    protected boolean someMethod(boolean b){
        return b;
    }
}