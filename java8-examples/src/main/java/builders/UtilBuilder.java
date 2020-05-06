package builders;

import com.github.javafaker.Faker;

public class UtilBuilder {

    public static Long newId(){
        long leftLimit = 1L;
        long rightLimit = 500L;
        return leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
    }

    public static String newName(){
        return  new Faker().name().firstName();
    }

    public static String newTitle(){
        return  new Faker().gameOfThrones().city();
    }

    public static int newNumberPages(){
        return  new Faker().number().numberBetween(100,500);
    }
}
