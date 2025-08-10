import java.io.Serializable;

public class Vehicle  {
    private String type,licensePlate;
    private int capacity;




    public Vehicle(String typee, String licensePlate, int capacity) {
        if(typee.equalsIgnoreCase("bus")||typee.equalsIgnoreCase("minibus")||typee.equalsIgnoreCase("limousine"))
        type = typee;
        this.licensePlate = licensePlate;
        this.capacity = capacity;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getType() {
        return type;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public int getCapacity() {                   
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean setType(String type) {
        boolean flag;
        if(type.equalsIgnoreCase("bus")||type.equalsIgnoreCase("minibus")||type.equalsIgnoreCase("limousine")){
            this.type=type;
            flag=true;
        }else flag=false;
        return flag;
    }
    public void DisplayInfo(){
        System.out.println("type of Vehicle is "+type+" the capacity is "+capacity+" licensePlate is "+licensePlate);
    }
@Override
    public String toString() {
        return
                 type + "#" +
                 licensePlate + "#" +
                 capacity +"#"
                ;
    }
}
