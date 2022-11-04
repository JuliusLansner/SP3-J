package sp33.src;
import java.util.Scanner;

public class User {
    Scanner input = new Scanner(System.in);
    String userName;
    String passWord;
    String UP;

    public String userLogin(String userName, String passWord) {

            this.userName = userName;
            this.passWord = passWord;

            return ":)";
        }

    //---- getter, user login information ----
    public String getUserName() {
        return userName;
    }
    public String getPassWord() {
        return passWord;
    }

    //---- user login / register ----
    public String getUserLogin () {
        System.out.println("You are about to login to your account. Please write the following ..");
        System.out.println("Username:   ");
        userName = input.nextLine();
        System.out.println("Password:   ");
        passWord = input.nextLine();

        return userName + passWord;
    }
    private String userRegister () {
        System.out.println("You are about to register a new account. Please write the following ..");
        System.out.println("Username:   ");
        userName = input.nextLine();
        System.out.println("Password:   ");
        passWord = input.nextLine();

        return userName + passWord;
    }


            /*
            private String getUserRegister () {
                System.out.println("You are about to register a new account. Please write your desired ..");
                System.out.println("Username:   ");
                userName = input.nextLine();
                System.out.println("Password:   ");
                passWord = input.nextLine();
                UP = userName + passWord;
                return UP;


            }
            public String getLogin () {
                return UP;

             */
}
