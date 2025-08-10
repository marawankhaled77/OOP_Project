import java.io.Serializable;

public class Trips  {
    public static final String TRIP_TYPE_INTERNAL = "INTERNAL";
    public static final String TRIP_TYPE_EXTERNAL = "EXTERNAL";
    public static final String TRIP_WAY_ONE_WAY = "ONE WAY";
    public static final String TRIP_WAY_ROUND_TRIP = "ROUND TRIP";

    private String tripType;
    private String source;
    private String destination;
    private String way;
    private int numStops;
    private int availableSeats;
    private double price;
    private Vehicle vehicle;
    private Driver driver;
    private int tripID;


    public Trips() {

    }

    public int getTripID() {
        return tripID;
    }


    public Trips(String tripType, String source, String destination, int numStops, double price, Vehicle vehicle, String way, Driver driver, int tripID) {

        if (!(tripType.equalsIgnoreCase(TRIP_TYPE_EXTERNAL) || tripType.equalsIgnoreCase(TRIP_TYPE_INTERNAL)))
            System.out.println("invalid input please try again with INTERNAL or EXTERNAL");

        else if (!(way.equalsIgnoreCase(TRIP_WAY_ONE_WAY) || way.equalsIgnoreCase(TRIP_WAY_ROUND_TRIP)))
            System.out.println("invalid input please try again with ONE WAY or ROUND TRIP");
        else {
            this.tripType = tripType;
            this.source = source;
            this.destination = destination;
            this.way = way;
            this.numStops = numStops;
            this.price = price;
            this.vehicle = vehicle;
            this.availableSeats = vehicle.getCapacity();
            this.driver = driver;
            this.tripID = tripID;

        }
    }

    public String getTripType() {
        return tripType;
    }

    public boolean setTripType(String tripType) {
        if (!(tripType.equalsIgnoreCase(TRIP_TYPE_EXTERNAL) || tripType.equalsIgnoreCase(TRIP_TYPE_INTERNAL))) {
            System.out.println("invalid input please try again with INTERNAL or EXTERNAL");
            return false;
        } else
            this.tripType = tripType;
        return true;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }


    public int getNumStops() {
        return numStops;
    }

    public void setNumStops(int numStops) {
        this.numStops = numStops;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }


    public String getWay() {
        return way;
    }

    public boolean setWay(String way) {
        if (!(way.equalsIgnoreCase(TRIP_WAY_ONE_WAY) || way.equalsIgnoreCase(TRIP_WAY_ROUND_TRIP))) {
            System.out.println("invalid input please try again with ONE WAY or ROUND TRIP");
            return false;
        } else
            this.way = way;
        return true;
    }

    public void setTripID(int id) {
        this.tripID= id;
    }
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.availableSeats = vehicle.getCapacity();
    }

    public boolean addSeat() {
        if (availableSeats > 0) {
            availableSeats--;
            return true;
        } else {
            System.out.println("Trip is full. No more seats available.");
            return false;
        }
    }


    public boolean removeSeat() {
        boolean flag;
        if (availableSeats < vehicle.getCapacity()) {
            availableSeats++;
            flag = true;
            return flag;
        } else {
            System.out.println("No seats available to remove.");
            flag = false;
            return flag;
        }
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public String TripDetails() {
        return "Trips{" +
                "tripType='" + tripType + '\'' +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", way='" + way + '\'' +
                ", numStops=" + numStops +
                ", availableSeats=" + availableSeats +
                ", price=" + price +
                ", vehicle=" + vehicle.getType() +
                "}";
    }



    @Override
    public String toString() {
        return tripType + "#"+source+"#"+destination+"#"+numStops+"#"+price+"#"+vehicle.getType()+"#"+vehicle.getLicensePlate()+"#"+vehicle.getCapacity()+"#"+way+"#"+driver.getName()+"#"+driver.getID()+"#"+driver.getUsername()+"#"+driver.getPassword()+"#"+tripID+"#";    }

}


