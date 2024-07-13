package main;

public class Ship extends Vehicle  {
    public Ship(String type, String manufacturer, String model, int maxSpeed) {
        super(type, manufacturer, model,maxSpeed);
        //System.out.println("Car-olio luotu!");
    }

    public void sail() {
        System.out.println(this.manufacturer + " "+ this.model + " seilaa merten ääriin!");
        
    } 
    
    public void printSpecs() {

        System.out.println("Laiva: " + manufacturer + " " + model);
        System.out.println("Moottori: " + engine.getName() + " " + engine.getPower() + "kW");
        System.out.println("Huippunopeus: " + maxSpeed + "km/h");
    }
}
