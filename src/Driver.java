import java.io.Serializable;
import java.util.ArrayList;

public class

  Driver extends Employee  {
    Managerr m= new Managerr();
    private ArrayList<Trips> trips= new ArrayList<>(m.getTrips());

    public Driver(String name,int id,String username,String password) {
        super(name,id,username,password);
    }

    public void tripdetails(int id) {
        for (int i = 0; i < m.getTrips().size(); i++) {
            if (id == m.getTrips().get(i).getDriver().getID()) {
                System.out.println(m.getTrips().get(i).TripDetails());
            } else {
                System.out.println("no trips");
            }
        }
    }
    public int  getID(){
        int id = super.getID();
        return id;
    }
    public String getName(){
        String name = super.getName();
        return name;
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }

    public String getPassword(){
        String password = super.getPassword();
        return password;
    }
    @Override
    public String toString() {
        return  getName()+
                "#" +getID()+
                "#" +getUsername()+
                "#"+getPassword()+"#"
                ;
    }
}




