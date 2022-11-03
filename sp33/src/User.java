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

    //---- get user login information ----
    public String getUserName(String userName) {
        return userName;
    }
    public String getPassWord(String passWord) {
        return passWord;
    }

    //---- user login / register ---- WIP
    public boolean userLogin() {
        if(passWord.equals("abc")) {
            return true;
        }
        return false;
    }
    private String userRegister() {
        System.out.println("You are about to register a new account. Please write your desired ..");
        System.out.println("Username: ");
        String userName = String.valueOf(input.nextInt());
        System.out.println("Password: ");
        String passWord = String.valueOf(input.nextInt());

        String userLoginInfo = userName + passWord;
        return userLoginInfo;
    }
}
