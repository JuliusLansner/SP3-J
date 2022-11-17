package sp33.src;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class StartMenu extends UserDB{

    private final Scanner scanner = new Scanner(System.in);
    MainMenu goToMainMenu = new MainMenu();
    Choices gotoChoice = new Choices();
    public void loginScreen() throws IOException {
        System.out.println("Welcome to Jflix");
        System.out.println("Please choose an existing user, or create a new one");
        System.out.println("Login to user 1: Press 1");
        System.out.println("Create a new user: Press 2");
        System.out.println("Enter your choice: ");
        String answer = scanner.nextLine();
        if (answer.contains("1")) {
            loginExistingUser();

        }
        if(answer.contains("2")){
            signupuser();
        }
    }

   public String loginExistingUser() throws IOException {
        User user = new User();
            String name = verifyUserLogin(user.getUsername(), user.getPassword());
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

    public void signupuser()throws IOException {
        signup();

        System.out.println("Signed up, going to the login screen");
        loginScreen();
    }
}





