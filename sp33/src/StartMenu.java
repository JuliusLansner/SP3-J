package sp33.src;

import java.util.Scanner;

public class StartMenu {

    private static final Scanner scanner = new Scanner(System.in);

    public static int loginScreen(String s) {
        System.out.println("Welcome to Jflix");
        System.out.println("Please choose an existing user, or create a new one");
        System.out.println("1 - login to user 1");
        System.out.println("2 - create a new user");
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
    public static void loginExistingUser (User user){
        if (user.equals(existingUser)){
            //display main menu?
        } else {
            return;
        }
    }
    public static void newUser(User user){
        if (user.equals(newUser)){
            //display create a new profile
        } else {
            return;
        }
    }
}


/*

Print a welcome/start menu - DONE

Takes a user input. Log in to existing profile or create a new profile.

If user choses an existing profile display MainMenu

If user choses to create a new profile display new profile class?


 */