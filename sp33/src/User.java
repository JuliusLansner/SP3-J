package sp33.src;
import java.util.Scanner;

public class User {
    Scanner input = new Scanner(System.in);
    String userName;
    String passWord;
    String UP;

    public void UserLogin(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;

    }

    //---- getter, user login information ----


    //---- user login / register ---- WIP
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

    }
    public String getLogin() {
        return UP;
    }

}