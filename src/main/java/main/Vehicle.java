package main;

import java.io.Serializable;

public class Vehicle implements Serializable {

    protected String type, manufacturer, model;
    protected int maxSpeed;
    protected Engine engine;
    
    
 
    
    public Vehicle(String type, String manufacturer, String model, int maxSpeed) {
        this.type = type;
        this.manufacturer = manufacturer;
        this.model = model;
        this.maxSpeed = maxSpeed;
        
        if (type.equalsIgnoreCase("Auto")) {
            this.engine = new Engine("V8", 300);
        }
        else if(type.equalsIgnoreCase("Lentokone")) {
            this.engine = new Engine("Suihkumoottori", 500);
        }
        else if(type.equalsIgnoreCase("Laiva")) {
            this.engine = new Engine("Wärtsilä Super", 1000);
        }       
        //“V8” ja 300, lentokoneella “Suihkumoottori” ja 500 sekä laivalla “Wärtsilä Super” ja 1000.
        
    }

    public String getType() {
        return type;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public Engine getEngine() {
        return engine;
    }
    
    
}
