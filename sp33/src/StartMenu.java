package sp33.src;
import java.util.Scanner;
public class StartMenu extends UserDB{

    private final Scanner scanner = new Scanner(System.in);

    public void loginScreen() {
        System.out.println("Welcome to Jflix");
        System.out.println("Please choose an existing user, or create a new one");
        System.out.println("Login to user 1: Press 1");
        System.out.println("Create a new user: Press 2");
        System.out.println("Enter your choice: ");
        String answer;
        answer = scanner.nextLine();
        if (("1".equals(answer))) {
            loginExistingUser();
        }
        if ("2".equals(answer)) {
            System.out.println("ikke okay");
        }
    }

   public void loginExistingUser() {
        if (scanner.equals("1")) {
            verifyUserLogin(getUsername(), getPassword(), "Data/userDB.txt", ",");
        }
    }
}





   /* public static void newUser(User user){
        if (user.equals(2)){

            //display create a new profile
            //refer to createNewProfileMethod
        }
    }/*
}

/*
WHAT DOES THE STARTMENU CLASS NEED TO DO?
1. Print a welcome/start menu - DONE
2. Take a user input and process it. Either Log in to existing profile or create a new profile. - DONE? DOES IT WORK?
3. If a user chooses an existing profile display MainMenu
4. If a user chooses to create a new profile, display NewUser
*/
