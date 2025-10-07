package org.example;



public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        /* Funkar inte - java: cannot find symbol
            symbol:   method of(java.lang.String,java.lang.String,java.lang.String)
            location: interface java.util.List
        List<String> names = List.of("Alice", "Bob", "Charlie");

        ------------------------------------------------------------------------------------------
        Funkar inte - java: illegal start of expression

        int day = 3;

        String result = switch (day) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            default -> "Unkown";
        };

        System.out.println(result);
        */

        RealRecord realRecord = new RealRecord("hello");
        System.out.println(realRecord);
        System.out.println(realRecord.name()); // .name är som getter för name
        /*
        realRecord.name = "test";
        realRecord.setName("test"); // bara getters inga setters
         */


        // lyser inte upp :(
        int week = 2;

        switch (week) {
            case 1:
                System.out.println("week 1");
                break;
            case 2:
                System.out.println("week 2");
                break;
            default:
                System.out.println("wrong week");
        }


        Dog dog = new Dog();
        Lizard lizard = new Lizard();

        AnimalUtil.checkAnimal(dog);
        AnimalUtil.checkAnimal(lizard);



    }
}