package sp33.src;
import java.util.Scanner;

public class User {
    Scanner input = new Scanner(System.in);
    String userName;
    String passWord; //String+int?

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
        System.out.println("");


        return userName;
        return passWord;
    }
    //---- user: getter & setter ----
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord() {
        this.passWord = passWord;
    }
}
