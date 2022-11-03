package sp33.src;
import java.util.Scanner;

public class User {
    Scanner input = new Scanner(System.in);
    String userName;
    String passWord;

    public User(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    //---- getter, user login information ----
    public String getUserName() {
        return userName;
    }
    public String getPassWord() {
        return passWord;
    }

    //---- user login / register ---- WIP
    public boolean userLogin() {
        return passWord.equals("abc");
    }
    private String userRegister() {
        System.out.println("You are about to register a new account. Please write your desired ..");
        System.out.println("Username:   ");
        String userName = input.nextLine();
        System.out.println("Password:   ");
        String passWord = input.nextLine();

        return userName + passWord;
    }
}