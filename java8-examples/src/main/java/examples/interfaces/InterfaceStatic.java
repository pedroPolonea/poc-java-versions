package examples.interfaces;

public class InterfaceStatic {

    public static void main(String[] args) {
        Fly.averageSpeedFly(200, 2);
        Swim.averageSpeedSwim(100,1);
    }

    interface Fly {
        static void averageSpeedFly(final int distance, final int hours){
            System.out.println(distance/hours);
        }
    }

    interface Swim {
        static void averageSpeedSwim(final int distance, final int hours){
            System.out.println(distance/hours);
        }
    }
}
