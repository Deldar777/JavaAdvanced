package Shekho.com;

public class Motorcycle implements Vehicle{

    @Override
    public void accelerate() {
        System.out.println("Motorcycle is accelerating");
    }

    @Override
    public void stop() {
        System.out.println("Motorcycle is stopping");
    }

    public void Wheelie(){
        System.out.println("Motorcycle is doing wheelie");
    }
}
