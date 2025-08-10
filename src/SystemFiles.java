import java.io.File;
import java.io.IOException;

public class SystemFiles {
    public static void main(String[] args) {

        //
        try {
            File Trips = new File("Trips.txt");
            if (Trips.createNewFile()) {
                System.out.println("File created: "+Trips.getName());
            }
            else {
                System.out.println("File already exists.");
            }
        }catch (IOException e) {
            System.out.println("an error occurred.");
            e.printStackTrace();
        }
        //
        try {
            File Passengers = new File("Passengers.txt");
            if (Passengers.createNewFile()) {
                System.out.println("File created: "+Passengers.getName());
            }
            else {
                System.out.println("File already exists.");
            }
        }catch (IOException e) {
            System.out.println("an error occurred.");
            e.printStackTrace();
        }
        //
        try {
            File Drivers = new File("Driver.txt");
            if (Drivers.createNewFile()) {
                System.out.println("File created: "+Drivers.getName());
            }
            else {
                System.out.println("File already exists.");
            }
        }catch (IOException e) {
            System.out.println("an error occurred.");
            e.printStackTrace();
        }
        //
        try {
            File Manager = new File("Manager.txt");
            if (Manager.createNewFile()) {
                System.out.println("File created: "+Manager.getName());
            }
            else {
                System.out.println("File already exists.");
            }
        }catch (IOException e) {
            System.out.println("an error occurred.");
            e.printStackTrace();
        }
        //
        try {
            File Vehicles = new File("Vehicles.txt");
            if (Vehicles.createNewFile()) {
                System.out.println("File created: "+Vehicles.getName());
            }
            else {
                System.out.println("File already exists.");
            }
        }catch (IOException e) {
            System.out.println("an error occurred.");
            e.printStackTrace();
        }

    }
}

