package sp33.src;


import java.io.*;
import java.util.Scanner;

public class UserDB {
    //take info from user signup
    //get username and password, save in a text file

    String filepath = "Data/userDB.txt";
    MainMenu goToMainMenu = new MainMenu();
    String userData[];
    boolean loginSuccess;


   public String verifyUserLogin(String username, String password){
       String currentLine;


       User user = new User();
       user.getLogin();
       user.loginListCat(user.login);
       user.profilesArray();
        for (int i = 0; i <user.profilesArray().size() ; i++) {

            if (user.profilesArray().get(i).userName.equalsIgnoreCase(username) && user.profilesArray().get(i).passWord.equalsIgnoreCase(password)) {
                loginSuccess = true;
                System.out.println(user.profilesArray().get(i).userName);
                return user.profilesArray().get(i).userName;
            }
        }
       System.out.println(user.profilesArray());
       loginSuccess = false;
       return "Thats wrong";
   }


    // SIGNUP FUNCTION
    Scanner scanner = new Scanner(System.in);
    public void signup() throws IOException {

        System.out.println("Write your username:");

        BufferedWriter writer = new BufferedWriter(new FileWriter("Data/userDB.txt",true));

        String username = scanner.nextLine();

        System.out.println("Your new username is: " + username);
        System.out.println("Create your password: ");

        String password = scanner.nextLine();

        BufferedWriter writer1 = new BufferedWriter(new FileWriter("Data/userDB.txt", true));
        writer1.write(String.valueOf(username + ","));
        writer1.write(String.valueOf(password+";"));
        writer1.write("\n");
        writer1.close();


        System.out.println("Your new password is:" + password);

    }


}
