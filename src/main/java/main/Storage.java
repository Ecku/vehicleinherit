package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Storage {
        private ArrayList<Vehicle> vehicles;
        final private String FILENAME;
        EventLogger eventLogger;

    public Storage(EventLogger eventLogger) {
            this.eventLogger = eventLogger;
            this.FILENAME = "vehicle.data";
            vehicles = new ArrayList<>();
        }
    
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        
    }

    public Vehicle getVehicleById(int id) {
        return vehicles.get(id);
    }

    public void listVehicles() {
               
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Car)  {  
                ((Car) (vehicle)).printSpecs();
                System.out.println();
            }
            else if (vehicle instanceof Plane)  { 
                ((Plane) (vehicle)).printSpecs();
                System.out.println();
            }
            else if (vehicle instanceof Ship)  {  
                ((Ship) (vehicle)).printSpecs();
                System.out.println();
            }
            
        }       

 /*       for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Plane)  { 
                ((Plane) (vehicle)).printSpecs();
                System.out.println();
            }
        }
       
        for (Vehicle vehicle : vehicles) {
            if (vehicle instanceof Ship)  {  
                ((Ship) (vehicle)).printSpecs();
                System.out.println();
            }
        }
*/
    }
    
    public void driveVehicles(int type) {
        if (type == 3) {
            for (Vehicle vehicle : vehicles) {
                if (vehicle instanceof Car)  {
                    ((Car) (vehicle)).drive();
                }
            }
        }
        else if(type == 4){
            for (Vehicle vehicle : vehicles) {
                if (vehicle instanceof Plane)  {
                    ((Plane) (vehicle)).fly();
                }
            }
        }
        else if(type == 5){
            for (Vehicle vehicle : vehicles) {
                if (vehicle instanceof Ship)  {
                    ((Ship) (vehicle)).sail();
                }
            }
        }

    }


    public void saveVehicles() {
        try {
            ObjectOutputStream vehicleWriter = new ObjectOutputStream(new FileOutputStream(FILENAME));
            vehicleWriter.writeObject(vehicles);
            vehicleWriter.close();
            eventLogger.writeLog("Ajoneuvot tallennettu tiedostoon");
        } catch (IOException e) {
            System.out.println("Ajoneuvojen tallentaminen ei onnistunut");
            e.printStackTrace();
        }
    }

      public void loadVehicles() {
        try {
            ObjectInputStream vehicleReader = new ObjectInputStream(new FileInputStream(FILENAME));
            vehicles = (ArrayList<Vehicle>) vehicleReader.readObject();
            vehicleReader.close();
            eventLogger.writeLog("Opiskelijat ladattu tiedostosta");
            for (Vehicle vehicle : vehicles) {
                // eventloggeria ei voida serialoida, asetetaan osoitteet manuaalisesti
                //student.putEventLogger(eventLogger);
            } 

        } catch (FileNotFoundException e) {
            System.out.println("Ajoneuvojen lukeminen ei onnistunut");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Ajoneuvojen lukeminen ei onnistunut");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Ajoneuvojen lukeminen ei onnistunut");
            e.printStackTrace();
        }
    }
}
