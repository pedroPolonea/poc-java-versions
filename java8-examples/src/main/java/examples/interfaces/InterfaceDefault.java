package examples.interfaces;


public class InterfaceDefault {

    public static void main(String[] args) {
        //Multiple inheritance example
        final Duck duck = new Duck();
        duck.averageSpeedFly(200,1);
        duck.averageSpeedSwim(100,1);
    }

    interface Fly {
        default void averageSpeedFly(final int distance, final int hours){
            System.out.println(distance/hours);
        }
    }

    interface Swim {
        default void averageSpeedSwim(final int distance, final int hours){
            System.out.println(distance/hours);
        }
    }

    static class Duck implements Fly, Swim{
        public Duck(){}
    }
}
