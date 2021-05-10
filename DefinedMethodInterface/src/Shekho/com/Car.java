package Shekho.com;

public class Car implements Vehicle{
    @Override
    public void accelerate() {
        System.out.println("Car is accelerating");
    }

    @Override
    public void stop() {
        System.out.println("Car is stopping");
    }
}
