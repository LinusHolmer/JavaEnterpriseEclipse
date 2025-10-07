package org.example;

public class AnimalUtil {

    public static void checkAnimal(IAnimal animal) {
        if (animal instanceof IMammal) {
            System.out.println("Mammal");
        }

        if (animal instanceof IReptile) {
            System.out.println("Reptile");
        }
    }

}
