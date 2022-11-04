package sp33.src;
import java.util.Scanner;

public class User {
    Scanner input = new Scanner(System.in);
    String userName;
    String passWord;

    public void userLogin(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;

    }

    //---- getter, user login information ----

        public String getUsername() {
                userName = input.nextLine();
                return userName;
            }

         public String getPassword() {
            passWord = input.nextLine();
                return passWord;
    }






}