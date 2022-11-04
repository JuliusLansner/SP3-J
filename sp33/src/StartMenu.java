package sp33.src;
import java.util.Scanner;
public class StartMenu {
    private static final Scanner scanner = new Scanner(System.in);

    public static int loginScreen() {
        System.out.println("Welcome to Jflix");
        System.out.println("Please choose an existing user, or create a new one");
        System.out.println("Login to user 1: Press 1");
        System.out.println("Create a new user: Press 2");
        System.out.println("Enter your choice: ");
        String answer;
        while (true) {
            answer = scanner.nextLine();
            if (("1".equals(answer))) {
                return 1;
            }
            if ("2".equals(answer)) {
                return 2;
            }
            System.out.println("You must choose option 1 or 2. Try again");
        }
    }
    public static void loginExistingUser(User user){
        if (user.equals(existingUser)){
            //display main menu?
        }
    }
    public static void newUser(User user){
        if (user.equals(newUser)){
            //display create a new profile
            //refer to createNewProfileMethod
        }
    }
}

/*
WHAT DOES THE STARTMENU CLASS NEED TO DO?
1. Print a welcome/start menu - DONE
2. Take a user input and process it. Either Log in to existing profile or create a new profile. - DONE? DOES IT WORK?
3. If a user chooses an existing profile display MainMenu
4. If a user chooses to create a new profile, display NewUser
*/