package sp33.src;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
public class StartMenu extends UserDB{

    private final Scanner scanner = new Scanner(System.in);
    MainMenu goToMainMenu = new MainMenu();
    Choices gotoChoice = new Choices();


    public String loginExistingUser() throws IOException {
        User user = new User();
        String name = verifyOld(user.getUsername(), user.getPassword());
        loginCheck();
        return name;
    }
    public void loginCheck() throws IOException {
        if (loginSuccess == true){
            System.out.println("Login sucessful...");
            //goToMainMenu.choice();
        } else if(loginSuccess == false){
            System.out.println("Wrong info, try again..");
            loginExistingUser();
        }
    }

    public void signupuser() throws IOException, SQLException {
        signup();

        System.out.println("Signed up, going to the login screen");

    }
}





