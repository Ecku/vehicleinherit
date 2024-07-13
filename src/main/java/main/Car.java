package main;
public class Car  extends Vehicle{
    public Car(String type, String manufacturer, String model, int maxSpeed) {
        super(type, manufacturer, model,maxSpeed);
        //System.out.println("Car-olio luotu!");
    }

    public void drive() {
        System.out.println(this.manufacturer + " "+ this.model + " paahtaa tietä eteenpäin!");
        
    }
    
    public void printSpecs() {

        System.out.println("Auto: " + manufacturer + " " + model);
        System.out.println("Moottori: " + engine.getName() + " " + engine.getPower() + "kW");
        System.out.println("Huippunopeus: " + maxSpeed + "km/h");
    }
}
