package main;

public class Plane extends Vehicle {
    public Plane(String type, String manufacturer, String model, int maxSpeed) {
        super(type, manufacturer, model,maxSpeed);
        //System.out.println("Car-olio luotu!");
    }

    public void fly() {
        System.out.println(this.manufacturer + " "+ this.model + " lentää kohteeseen!");
        
    }  
    
    public void printSpecs() {

        System.out.println("Lentokone: " + manufacturer + " " + model);
        System.out.println("Moottori: " + engine.getName() + " " + engine.getPower() + "kW");
        System.out.println("Huippunopeus: " + maxSpeed + "km/h");
    }
}
