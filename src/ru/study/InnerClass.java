package ru.study;
// в основном используются в программировании приложений на ПК(Swift)
// для обработки нажатых кнопок в приложении
// имеют полный доступ к классу в котором созданы
public class InnerClass {

    private int i = 5;
    public static void main(String[] args) {
        //first method to use and Create InnerClass
        InnerClass innerClass = new InnerClass();
        innerClass.someMethod();
        //second
        InnerClass innerClass1 = new InnerClass();
        InnerClassExample innerClassExample1 = innerClass1.new InnerClassExample();
        innerClassExample1.doSomethingMethod(99);
    }

    public void someMethod(){
        InnerClassExample innerClassExample = new InnerClassExample();
        innerClassExample.doSomethingMethod();
    }

    class InnerClassExample{
        int i = 8;
        public void doSomethingMethod(){
            System.out.println("Inner Example Class " + i);
        }
        public void doSomethingMethod(int j){
            System.out.println("Inner Example Class " + j);
        }
    }
}
