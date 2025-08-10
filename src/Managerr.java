import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Scanner;
public class Managerr extends Employee  {

    private static ArrayList<Driver> drivers = new ArrayList<>();
    private static ArrayList<Vehicle> vehicles = new ArrayList<>();
    private static ArrayList<Trips> trips = new ArrayList<>();
    private static int DriverCap;



    public static ArrayList<Trips> getTrips() {
        return trips;
    }

    public static int getDriverCap() {
        return DriverCap;
    }

    public static ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public static ArrayList<Driver> getDrivers() {
        return drivers;

    }
    public void setTrips(ArrayList<Trips> trips) {
        this.trips = trips;
    }
    public void setDrivers(ArrayList<Driver> drivers) {
        this.drivers = drivers;
    }

    public Managerr (){}


    public Managerr(String name, int id, String username, String password) {
        super(name, id, username, password);
    }

    public void setDriverCap(int driverCap) {
        DriverCap = driverCap;
    }

    public boolean addDriver() {

        if (DriverCap != 0) {
            Scanner kk = new Scanner(System.in);
            System.out.println("enter name of driver");
            String name = kk.nextLine();
            System.out.println("enter id of driver");
            int id = kk.nextInt();
            System.out.println("enter username of driver");
            String username = kk.next();

            System.out.println("enter password of driver");
            String password = kk.next();
            Driver driver = new Driver(name, id, username, password);
            drivers.add(driver);
            DriverCap--;
          try {
                FileWriter Driver = new FileWriter("Driver.txt",true);
                Driver.write(System.lineSeparator());
                Driver.write(driver.toString());
                Driver.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        } else return false;

    }

    public boolean removeDriver(int id) {
        for (int i = 0; i < drivers.size(); i++) {
            if (drivers.get(i).getID()==id) {
                drivers.remove(i);
                return true;
            }
        }
        return false;
    }



    public boolean addTrip() {
        Trips t = new Trips();
        Scanner kk = new Scanner(System.in);

        System.out.println("enter Type of trip");
        String type = kk.nextLine();
        t.setTripType(type);

        System.out.println("enter source of trip");
        String source = kk.nextLine();
        t.setSource(source);

        System.out.println("enter destination of trip");
        String destination = kk.nextLine();
        t.setDestination(destination);

        System.out.println("enter way of trip");
        String way = kk.nextLine();
        t.setWay(way);

        System.out.println("enter nofstops of trip");
        int noofstops = kk.nextInt();
        t.setNumStops(noofstops);

        System.out.println("enter vehicle details of this trip");

        System.out.println("type of vehicle");
        kk.nextLine();  // Add this line to consume the leftover newline
        String vehicleType = kk.nextLine();

        System.out.println("licensePlate");
        String licensePlate = kk.nextLine();

        System.out.println("Capacity");
        int capacity = kk.nextInt();
        kk.nextLine();  // Consume newline left-over

        Vehicle v = new Vehicle(vehicleType, licensePlate, capacity);
        t.setVehicle(v);
        vehicles.add(v);

        System.out.println("enter availbleseats of trip");
        int availableSeats = kk.nextInt();

        System.out.println("enter price of trip");
        double price = kk.nextDouble();
        t.setPrice(price);
        System.out.println("Enter Id of Trip");
        int idT = kk.nextInt();
        t.setTripID(idT);
        System.out.println("Assign Driver for this Trip (by his 'ID')");
        int assignDriverID = kk.nextInt();
        kk.nextLine();
        int indexDriver =0;
        for (int i = 0 ; i < drivers.size(); i++) {
            if (drivers.get(i).getID() == (assignDriverID)) {
                trips.add(t);
                System.out.println(AssignDriver(idT,drivers.get(i).getID()));
            }
        }


        idT++;
        try {
            FileWriter T = new FileWriter("Trips.txt",true);
            T.write(System.lineSeparator());
            T.write(t.toString());
            T.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return true;

    }

            public boolean removeTrip(int id) {
                   for (Trips trip : trips) {
                       if (trip.getTripID()==(id)) {
                       trips.remove(trip);
                return true;
            }
        }
        return false;
    }



    public boolean AssignDriver (int tripId,int driverId){
        for (Trips i : trips) {
            if (i.getTripID()==(tripId)) { // Assuming Trip class has a getTripID() method
            for (Driver d : Managerr.getDrivers()) {
                if (d.getID()==(driverId)) {
                    i.setDriver(d);
                }
            }
                return true;
            }
        }
        System.out.println("Trip with ID " + tripId +" not found.");
        return false;

    }
    public void GenerateReport( int tripId){
        for (Trips i : trips) {
            if (i.getTripID()==(tripId)) {
                System.out.println(i.TripDetails());
                System.out.println("Driver name:"+i.getDriver().getName()+",Driver ID : "+i.getDriver().getID());
                System.out.println("Vehicle Type :"+i.getVehicle().getType()+" ,Vehicle LicensePlate:"+i.getVehicle().getLicensePlate()+" ,Vehicle Capacity:"+i.getVehicle().getCapacity());
            }
        }


    }

    }

