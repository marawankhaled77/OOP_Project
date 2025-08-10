import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Passenger  {
    private String name;
    private int id;
    private String ticketType ;
    private String password,username;
//        String tripS = getTripsSelected();
    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public Managerr m = new Managerr();
    private  ArrayList<Trips> tripsP = new ArrayList<>(m.getTrips());
    private ArrayList<Trips> tripsSelected = new ArrayList<Trips>();

    public Passenger(String name , String username , String password){
        this.name = name;
        this.password = password;
        this.username=username;
    }
//    public Passenger(String name,String username,String password,String tripselected){
//        this.name = name;
//        this.password = password;
//        this.username=username;
////        this.tripS = tripselected;
//    }

    public int getId() {
        return id;
    }

    public String getTripsSelected() {
        String a;
        ArrayList<String> aa= new ArrayList<String>();
        for (Trips i : tripsSelected) {
            a=i.TripDetails();
            aa.add(a);
        }
        return aa.toString();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void selectTrip() {
        for (int i = 0; i < Managerr.getTrips().size(); i++) {
            System.out.println((i + 1) + " " + Managerr.getTrips().get(i).TripDetails());
        }
        Scanner keyboard = new Scanner(System.in);
        System.out.println("choose the trip");
        int p = keyboard.nextInt();
        if (Managerr.getTrips().get(p - 1).addSeat())
            tripsSelected.add(Managerr.getTrips().get(p - 1));
        System.out.println("booked successfully");
        ticketType = tripsSelected.get(p - 1).getWay();
        //////////////////////////////////////////////////////////////////
        try {
            FileWriter pa = new FileWriter("Passengers.txt",true);
//            pa.write();
            pa.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cancelTrip(int index) {
        System.out.println("you want to cancel the trip ");
        System.out.println("1.yes ");
        System.out.println("2.No ");
        Scanner keyboard = new Scanner(System.in);
        int choose = keyboard.nextInt();
        if (choose == 1) {
            tripsSelected.get(index - 1).removeSeat();
            tripsSelected.remove(index - 1);
        } else if (choose == 2) {
            System.out.println("you still in trip");
        }
    }

    public void reviewTicket() {
        for (int i = 0; i < tripsSelected.size(); i++) {
            System.out.println((i + 1) + " " + tripsSelected.get(i).TripDetails());
        }
        System.out.println("select trip you want to review  please");
        Scanner keyboard = new Scanner(System.in);
        int choose = keyboard.nextInt();
        System.out.println(tripsSelected.get(choose - 1).TripDetails());
    }
public Passenger(){}


    public double calcprice(){
        double totalprice = 0;
        for (int i = 0; i < tripsSelected.size(); i++) {
         totalprice += tripsSelected.get(i).getPrice();
        }return totalprice;

    }


    public void PassengerDetails() {
        System.out.println("Passenger{" +
                "id= " + id + " " +
                ", name=" + name + '\''  + '\'' +
                '}'+getTripsSelected()) ;

    }

    @Override
    public String toString() {
        return
                 name +
                "#"+ username +
                "#" + password +
                "#" + id +
                "#" + ticketType +
                "#" + getTripsSelected() +
                "#";
    }
}





