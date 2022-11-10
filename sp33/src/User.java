package sp33.src;
import java.util.ArrayList;
import java.util.Scanner;

public class User{
    Scanner input = new Scanner(System.in);
    String userName;
    String passWord;

    ArrayList<String> username = new ArrayList();



    //---- getter, user login information ----

    public String getUsername() {
        System.out.println("Username: ");
        userName = input.nextLine();
        username.add(userName);
        return userName;
    }

    public String getPassword() {
        System.out.println("Password: ");
        passWord = input.nextLine();
        return passWord;
    }






}