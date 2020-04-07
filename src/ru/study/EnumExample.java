package ru.study;

public class EnumExample {
    enum CoffeSize {SMALL(100), MEDIUM(200), BIG(400){
        String getCoffeClass(){
            return "B";
        }
    };
     String CoffeClass = "A";
     int milliliters;
     //constructor
     CoffeSize (int milliliters){
         this.milliliters = milliliters;
     }
     //some method
        int getMilliliters(){
         return milliliters;
        }
        String getCoffeClass(){
         return getCoffeClass();
        }
    }

    public static void main(String[] args) {
        CoffeSize coffeSize = CoffeSize.BIG;
        System.out.println(coffeSize);
        System.out.println(coffeSize.getMilliliters());
        System.out.println(coffeSize.getCoffeClass());
    }
}
