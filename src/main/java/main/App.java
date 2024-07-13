package main;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EventLogger eventLogger = new EventLogger();
        Storage storage = new Storage(eventLogger);
        boolean exit = false;
        Vehicle vehicle = null;
        eventLogger.writeLog("Ohjelma käynnistyy");


        while(!exit) {
            System.out.println("1) Luo uusi kulkuneuvo, 2) Listaa kulkuneuvot 3) Aja autoja, 4) Lennä lentokoneita, 5) Seilaa laivoja, 0) Lopeta ohjelma");

            if(sc.hasNext()) {
                int i = 0;
                String stringInput = sc.nextLine();
                i = Integer.parseInt(stringInput);

                switch(i) {
                    case 1:
                        System.out.println("Minkä kulkuneuvon haluat rakentaa? 1) auto, 2) lentokone, 3) laiva");
                        String typeString = sc.nextLine();
                        int type = Integer.parseInt(typeString);
                        
                        System.out.println("Anna kulkuneuvon valmistaja:");
                        typeString = sc.nextLine();
                        String valmistaja = typeString;
                        
                        System.out.println("Anna kulkuneuvon malli:");
                        typeString = sc.nextLine();
                        String malli = typeString;                       
                        
                        System.out.println("Anna kulkuneuvon huippunopeus:");
                        typeString = sc.nextLine();
                        int huippuNopeus = Integer.parseInt(typeString);  
                        
                        if(type == 1) {   
                            vehicle = new Car("Auto", valmistaja, malli, huippuNopeus);
                            storage.addVehicle(vehicle);
                        } else if(type == 2) {
                            vehicle = new Plane("Lentokone", valmistaja, malli, huippuNopeus);
                            storage.addVehicle(vehicle);                          
                        }  else if(type == 3) {
                            vehicle = new Ship("Laiva", valmistaja, malli, huippuNopeus);
                            storage.addVehicle(vehicle); 
                        }                         
                        break;
                        
                    case 2:
                        // Listaa kulkuneuvot
                        storage.listVehicles();                        
                        break;
                        
                    case 3:
                         storage.driveVehicles(i);
                        break;

                    case 4:
                        storage.driveVehicles(i);
                       break;

                    case 5:
                       storage.driveVehicles(i);
                      break;

                    case 6: 
                      storage.saveVehicles();
                      break;
                  case 7:
                      storage.loadVehicles();
                      break;
                  case 9:
                      eventLogger.readLog();
                      break;

                    case 0:
                        System.out.println("Kiitos ohjelman käytöstä.");
                        exit = true;
                        break;
                    default:
                        System.out.println("Syöte oli väärä");
                        break;

                }
            }

        }
        
        sc.close();
        eventLogger.writeLog("Ohjelma sulkeutuu");
    }
}
