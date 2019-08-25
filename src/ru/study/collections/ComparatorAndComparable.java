package ru.study.collections;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

class Person implements Comparable<Person>{
    int age;
    public Person(int age) {
        this.age = age;
    }
    @Override
    public int compareTo(Person p){
        return this.age - p.age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                '}';
    }
}
class Person1{
    public Person1(int age1) {
        this.age1 = age1;
    }

    private int age1;
    @Override
    public String toString() {
        return "Person1{" +
                "age1=" + age1 +
                '}';
    }

    public int getAge1() {
        return age1;
    }

    public void setAge1(int age1) {
        this.age1 = age1;
    }
}
class ComparePerson1 implements Comparator<Person1>{
    @Override
    public int compare(Person1 p1, Person1 p2){
        return p1.getAge1() - p2.getAge1();
    }
}
public class ComparatorAndComparable {
    public static void main(String[] args) {
        Set set = new TreeSet();
        set.add(new Person(2));
        set.add(new Person(5));
        set.add(new Person(3));
        set.add(new Person(19));
        set.add(new Person(1));
        set.add(new Person(7));
        for (Object o : set){
            System.out.println(o);
        }

        Set set1 = new TreeSet(new ComparePerson1());
        set1.add(new Person1(2));
        set1.add(new Person1(5));
        set1.add(new Person1(3));
        set1.add(new Person1(19));
        set1.add(new Person1(1));
        set1.add(new Person1(7));
        for (Object o : set1){
            System.out.println(o);
        }
    }
}
