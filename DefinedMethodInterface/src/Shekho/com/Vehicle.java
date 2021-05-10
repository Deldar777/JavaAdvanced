package Shekho.com;

public interface Vehicle {
    void accelerate();
    void stop();
    default void drift(){
        System.out.println("Vehicle is drifting");
    }
}
