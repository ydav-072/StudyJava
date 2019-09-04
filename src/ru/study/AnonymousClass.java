package ru.study;

class Popcorn{
    int var = 45;
    public void doSomething(){
        System.out.println("popcorn Class");
    }
}
// с помощью анонимных классов мы можем полиморфически переопределять некоторые свойства классов, а также интерфейсов

public class AnonymousClass {
    public static void main(String[] args) {
        Popcorn popcorn = new Popcorn(){ // here we created new class and it extends from Popcorn
                                        // but we override method doSomethingMethod()
            public void doSomething(){
                System.out.println("AnonymousClass");
            }
        };
        popcorn.doSomething();
        // some interface
        Comparable comparable = new Comparable() {
            @Override
            public int compareTo(Object o) {
                return 0;  
            }
        };
    }
}
