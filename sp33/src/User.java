package sp33.src;
import java.util.Scanner;

public class User {
    Scanner input = new Scanner(System.in);
    String userName;
    String passWord;
    String UP;

<<<<<<< HEAD
    public void userLogin(String userName, String passWord) {
=======
    public void UserLogin(String userName, String passWord) {
>>>>>>> StartMenu
        this.userName = userName;
        this.passWord = passWord;

    }

    //---- getter, user login information ----


    //---- user login / register ---- WIP
<<<<<<< HEAD
    public String getUserLogin() {
        System.out.println("You are about to login to your account. Please write the following ..");
        System.out.println("Username:   ");
        userName = input.nextLine();
        System.out.println("Password:   ");
        passWord = input.nextLine();

        return userName + passWord;
    }

    private String userRegister() {
        System.out.println("You are about to register a new account. Please write the following ..");
        System.out.println("Username:   ");
        userName = input.nextLine();
        System.out.println("Password:   ");
        passWord = input.nextLine();
=======
    public boolean userLogin() {
        return passWord.equals("abc");
    }
    private String getUserRegister() {
        System.out.println("You are about to register a new account. Please write your desired ..");
        System.out.println("Username:   ");
         userName = input.nextLine();
        System.out.println("Password:   ");
         passWord = input.nextLine();
         UP = userName+passWord;
        return UP;
        //u=seb p=123
        //seb 123
        //Username: seb
        //password: 123
        //if username+password = seb123
>>>>>>> StartMenu

    }
    public String getLogin() {
        return UP;
    }

}