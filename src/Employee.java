import java.util.Scanner;

public class Employee {
    private String username, password, name;
    private int id;

    public Employee() {
    }
    public Employee(String name, int id, String username,String password) {
        this.name = name;
        this.id = id;
        this.username = username;
        this.password = password;
    }


    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return id;
    }


    public String getPassword() {
        return password;
    }


    public String getUsername(){

        return username;
    }
    public void setPassword() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your password: ");
        password = input.nextLine();

    }

    @Override
    public String toString() {
        return
                 name +"#" +
                 id + "#" +
                username+"#"+
                password+"#"
                ;
    }
}



