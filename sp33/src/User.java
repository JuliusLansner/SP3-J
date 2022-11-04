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
    public String getUserName() {
        userName = input.nextLine();
        return userName;
    }

    public String getPassWord() {
        passWord = input.nextLine();
        return passWord;
    }







    




  /* If we want to be able to change username and password at a later time
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;

   */
}
