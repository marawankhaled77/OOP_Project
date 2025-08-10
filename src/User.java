import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class
User {
    Managerr m = new Managerr();

    private ArrayList<Driver> drivers=Managerr.getDrivers();
    private static ArrayList<Passenger> passengers = new ArrayList<>();


    public boolean CheckDriver(String username, String password) {

            boolean flag = false;
        for (int i = 0; i < Managerr.getDrivers().size(); i++) {
            Driver driver = m.getDrivers().get(i);
            if (driver.getUsername().equals(username) && driver.getPassword().equals(password)) {
                flag = true;
                return true;
            }break;
        }
        return false;
    }
    public Driver getDriver(String username, String password) {
        for (int i = 0; i <Managerr.getDrivers().size(); i++) {
            Driver driver = Managerr.getDrivers().get(i);
            if (driver.getUsername().equals(username) && driver.getPassword().equals(password)) {
                return driver;
            }break;

        }return null;

    }

    public Passenger getpassenger(String username, String password) {
       for (Passenger i : passengers){
           Passenger passenger = i;
            if (passenger.getUsername().equals(username) && passenger.getPassword().equals(password)) {
                return passenger;
            }break;

        }return null;
    }
    public ArrayList<Driver> getDrivers() {
        return drivers;
    }

    public static ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(ArrayList<Passenger> passengers){
         this.passengers = passengers;
    }



    public void registerPassenger() {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter name:");
        String name = input.nextLine();
        System.out.println("Enter username:");
        String user = input.nextLine();
        System.out.println("Enter id:");
        int id = input.nextInt();

        for (int i = 0; i < passengers.size(); i++) {
            if (passengers.get(i).getUsername().equals(user)) {
                System.out.println("This username is already taken\nPlease Enter another username");
                user = input.nextLine();
            }
        }
        System.out.println("Enter password :");
        String password = input.nextLine();
        password=input.nextLine();

        Passenger P = new Passenger(name, user, password );
        for (int i = 0; i < passengers.size(); i++) {
            if (passengers.get(i).getId() == id) {
                System.out.println("choose another one");
            }
        }
        P.setId(id);
        passengers.add(P);
        try {
            FileWriter pa = new FileWriter("Passengers.txt",true);
            pa.write(System.lineSeparator());
            pa.write(P.toString());
            pa.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public boolean LoginPassenger(String user, String password) {
        Scanner input = new Scanner(System.in);
////        System.out.println("Enter username :");
////        String user = input.nextLine();
////        String password;
        boolean userFound = false; // Flag to track if the user is found
        for (int i = 0; i < passengers.size(); i++) {
                        if (passengers.get(i).getUsername().equals(user)) {
                            userFound = true;

                            do{
                                System.out.println("Please Renter your password:");
                                password = input.nextLine();
                            }
                            while (!password.equals(passengers.get(i).getPassword()));


                                System.out.println("Correct Password");

                        }
        }
        if (!userFound) {
            System.out.println("You Don't Have an Account\n Please Register your Account to continue:");
            registerPassenger();// Invoke register method if user not found

        }
    return true;}

    public boolean loginManager(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter username :");
        String user = input.nextLine();
        String password;
        boolean userFound = false; // Flag to track if the user is found
                if (user.equals("mu")) {
                    userFound = true;

                    do {
                        System.out.println("Enter password :");
//                        System.out.println("Incorrect password !! \n Enter password again:");
                        password = input.nextLine();
                    } while (!password.equals("mu771"));
                    {
                        System.out.println("Correct Password");
                    }
                    System.out.println("Welcome:");
                }



        if (!userFound) {
            System.out.println("you are not the Manager");
            return false;
        }return true;

    }

}









    

