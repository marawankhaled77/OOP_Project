

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
    public class Main {
        public static void main(String[] args) {


            User u = new User();
            System.out.println(u.getPassengers());
            u.setPassengers(ReturnPa());
            System.out.println(u.getPassengers());
            Managerr m = new Managerr();
            m.setDrivers(ReturnDr());
            //System.out.println();
            m.setTrips(ReturnTR());
            m.setDriverCap(100);
//m.addDriver();
          // System.out.println(m.removeDriver(20100));


            Scanner input = new Scanner(System.in);
            System.out.println("Welcome to the transportation System ");
            System.out.println();
            System.out.println("1.Employee / 2.Passenger ");
            System.out.println("Please choose an option: ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("1 for manager / 2 for Driver");
                    int choice2 = input.nextInt();
                    switch (choice2) {
                        case 1:
                            if (u.loginManager()) {
                                System.out.println("You have successfully logged in");

                                System.out.println("1 for review trips , 2 for add trip , 3 for remove trip , 4 for Add driver, 5 assign driver");
                                int choice3 = input.nextInt();
                                switch (choice3){
                                    case 1:
                                        for (int i=0;i<m.getTrips().size();i++){
                                            System.out.println(m.getTrips().get(i).TripDetails());

                                        }break;
//
                                    case 2:m.addTrip();break;

//
//
                                    case 3:
                                        System.out.println("enter trip id");
                                        int tripId = input.nextInt();
                                        m.removeTrip(tripId);break;
                                    case 4:
                                        m.addDriver();break;
                                    case 5:
                                        System.out.println("enter trip id");
                                        int tripid=input.nextInt();
                                        System.out.println("Enter Driver id ");
                                        int driverid=input.nextInt();
                                        m.AssignDriver(tripid,driverid);


                                        break;}
                            }
                            break;  //case 1 switch2

                        case 2:
                            System.out.println("Enter username :");
                            String user = input.nextLine();
                            user=input.nextLine();
                            System.out.println("enter password :");
                            String password = input.nextLine();
                            if (u.CheckDriver(user, password)) {
                                for (int i=0;i<m.getDrivers().size();i++){
                                    Driver driver= u.getDriver(user,password);
                                    System.out.println(driver.getID());

                                    driver.tripdetails(driver.getID());

                                    break;  //switch1


                                }
                            }


                    }break;

                case 2:
                    System.out.println("1. for login / 2. for register");
                    int choice4 = input.nextInt();
                    switch (choice4) {
                        case 1:
                            System.out.println("Enter username :");
                            String user = input.nextLine();
                            user=input.nextLine();
                            System.out.println("enter password :");
                            String password = input.nextLine();

                            if (u.LoginPassenger(user, password)){
                                Passenger p = u.getpassenger(user,password);
                                System.out.println(p);
                                System.out.println("welcome to the transportation System");
                                System.out.println("1.for select and book your trip / 2.for review your cart / 3.for show your profile /4.for review tickets");
                                int choice5 = input.nextInt();
                                switch (choice5) {

                                    case 1:p.selectTrip();
                                        break;
                                    case 2:
                                        System.out.println("Your total price is: "+p.calcprice());
                                        break;
                                    case 3:p.PassengerDetails();
                                        break;
                                    case 4:p.reviewTicket();
                                        break;

                                }break;


                            }break;
                        case 2:u.registerPassenger();
                            System.out.println("register successfully");
                            break;


                    }


            }


            WriteDriver();

            WriteTrip();

            WritePassenger();

            WriteVehicle();


        }

        public static ArrayList<Driver> ReturnDr() {
            ArrayList<String> DIN = new ArrayList<>();
            ArrayList<Driver> DIND = new ArrayList<>();
            Driver d;
            String s1 = "";
            int s2 = 0;
            String s3 = "";
            String s4 = "";
            try {
                Scanner read = new Scanner(new File("Driver.txt"));
                while (read.hasNextLine()) {
                    String p = read.nextLine();
                    Scanner read1 = new Scanner(p);
                    read1.useDelimiter("#");
                    while (read1.hasNext()) {
                        DIN.add(read1.next());
                    }

                    for (int i = 0; i < DIN.size(); i++) {
                        switch (i) {
                            case 0:
                                s1 = DIN.get(i);
                                break;
                            case 1:
                                s2 = Integer.parseInt(DIN.get(i));
                                break;
                            case 2:
                                s3 = DIN.get(i);
                                break;
                            case 3:
                                s4 = DIN.get(i);
                                break;
                        }
                    }
                    d = new Driver(s1, s2, s3, s4);
                    DIND.add(d);
                    DIN.removeAll(DIN);
                }
            } catch (Exception e) {
                e.getMessage();
                e.printStackTrace();
            }
            return DIND;
        }

        public static void WriteDriver() {
            try {
                FileWriter d = new FileWriter("Driver.txt");
                for (int i = 0; i < Managerr.getDrivers().size(); i++) {
                    d.write(Managerr.getDrivers().get(i).toString());
                    d.write(System.lineSeparator());
                }
                d.close();

            } catch (Exception e) {
                e.getMessage();
                e.printStackTrace();
            }
        }

        public static ArrayList<Trips> ReturnTR() {
            ArrayList<String> TIN = new ArrayList<>();
            ArrayList<Trips> TINT = new ArrayList<>();
            Trips t;
            Driver d;
            Vehicle v;

            String tripType = "";
            String source = "";
            String destination = "";
            int numStops = 0;
            double price = 0;
            String vehicleType = "";
            String vehiclelic = "";
            int vehicleCap = 0;
            String way = "";
            String driverNAME = "";
            int driverId = 0;
            String driverUSNAME = "";
            String driverPass = "";
            int tripID = 0;
            try {
                Scanner read = new Scanner(new File("Trips.txt"));
                while (read.hasNextLine()) {
                    String p = read.nextLine();
                    Scanner read1 = new Scanner(p);
                    read1.useDelimiter("#");
                    while (read1.hasNext()) {
                        TIN.add(read1.next());
                    }

                    for (int i = 0; i < TIN.size(); i++) {
                        switch (i) {
                            case 0:
                                tripType = TIN.get(i);
                                break;
                            case 1:
                                source = TIN.get(i);
                                break;
                            case 2:
                                destination = TIN.get(i);
                                break;
                            case 3:
                                numStops = Integer.parseInt(TIN.get(i));
                                break;
                            case 4:
                                price = Double.parseDouble(TIN.get(i));
                                break;
                            case 5:
                                vehicleType = TIN.get(i);
                                break;
                            case 6:
                                vehiclelic = TIN.get(i);
                                break;
                            case 7:
                                vehicleCap = Integer.parseInt(TIN.get(i));
                                break;
                            case 8:
                                way = TIN.get(i);
                                break;
                            case 9:
                                driverNAME = TIN.get(i);
                                break;
                            case 10:
                                driverId = Integer.parseInt(TIN.get(i));
                                break;
                            case 11:
                                driverUSNAME = TIN.get(i);
                                break;
                            case 12:
                                driverPass = TIN.get(i);
                                break;
                            case 13:
                                tripID = Integer.parseInt(TIN.get(i));
                                break;
                        }
                    }
                    d = new Driver(driverNAME, driverId, driverUSNAME, driverPass);
                    v = new Vehicle(vehicleType, vehiclelic, vehicleCap);
                    t = new Trips(tripType, source, destination, numStops, price, v, way, d, tripID);
                    TINT.add(t);
                    TIN.removeAll(TIN);
                }
            } catch (Exception e) {
                e.getMessage();
                e.printStackTrace();
            }
            return TINT;
        }


        public static void WriteTrip() {
            try {
                FileWriter t = new FileWriter("Trips.txt");
                for (int i = 0; i < Managerr.getTrips().size(); i++) {
                    t.write(Managerr.getTrips().get(i).toString());
                    t.write(System.lineSeparator());
                }
                t.close();

            } catch (Exception e) {
                e.getMessage();
                e.printStackTrace();
            }
        }

        public static ArrayList<Passenger> ReturnPa() {
            ArrayList<String> PIN = new ArrayList<>();
            ArrayList<Passenger> PINP = new ArrayList<>();
            Passenger paa;

            String name = "";
            String userName = "";
            String Pass = "";
//        String tripSelect="";

            try {
                Scanner read = new Scanner(new File("Passengers.txt"));
                while (read.hasNextLine()) {
                    String p = read.nextLine();
                    Scanner read1 = new Scanner(p);
                    read1.useDelimiter("#");
                    while (read1.hasNext()) {
                        PIN.add(read1.next());
                    }

                    for (int i = 0; i < PIN.size(); i++) {
                        switch (i) {
                            case 0:
                                name = PIN.get(i);
                                break;
                            case 1:
                                userName = PIN.get(i);
                                break;
                            case 2:
                                Pass = PIN.get(i);
                                break;
//                        case 3:
//                            tripSelect= PIN.get(i);
                        }
                    }
                    paa = new Passenger(name, userName, Pass);
                    PINP.add(paa);
                    PIN.removeAll(PIN);
                }
            } catch (Exception e) {
                e.getMessage();
                e.printStackTrace();
            }
            return PINP;

        }


        public static void WritePassenger() {
            try {
                FileWriter p = new FileWriter("Passengers.txt");
                for (int i = 0; i < User.getPassengers().size(); i++) {
                    p.write(User.getPassengers().get(i).toString());
                    p.write(System.lineSeparator());
                }
                p.close();

            } catch (Exception e) {
                e.getMessage();
                e.printStackTrace();
            }
        }

        public static ArrayList<Vehicle> ReturnVi() {
            ArrayList<String> VIN = new ArrayList<>();
            ArrayList<Vehicle> VINV = new ArrayList<>();
            Vehicle v;

            String type = "";
            String lic = "";
            int cap = 0;

            try {
                Scanner read = new Scanner(new File("Vehicles.txt"));
                while (read.hasNextLine()) {
                    String p = read.nextLine();
                    Scanner read1 = new Scanner(p);
                    read1.useDelimiter("#");
                    while (read1.hasNext()) {
                        VIN.add(read1.next());
                    }

                    for (int i = 0; i < VIN.size(); i++) {
                        switch (i) {
                            case 0:
                                type = VIN.get(i);
                                break;
                            case 1:
                                lic = VIN.get(i);
                                break;
                            case 2:
                                cap = Integer.parseInt(VIN.get(i));
                                break;

                        }
                    }
                    v = new Vehicle(type, lic, cap);
                    VINV.add(v);
                    VIN.removeAll(VIN);
                }
            } catch (Exception e) {
                e.getMessage();
                e.printStackTrace();
            }
            return VINV;
        }

        public static void WriteVehicle() {
            try {
                FileWriter v = new FileWriter("Vehicles.txt");
                for (int i = 0; i < Managerr.getVehicles().size(); i++) {
                    v.write(Managerr.getVehicles().get(i).toString());
                    v.write(System.lineSeparator());
                }
                v.close();

            } catch (Exception e) {
                e.getMessage();
                e.printStackTrace();
            }
        }

    }


















