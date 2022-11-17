package sp33.src;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class UserDB extends User {
    //take info from user signup
    //get username and password, save in a text file

    String filepath = "Data/userDB.txt";
    MainMenu goToMainMenu = new MainMenu();
    String userData[];
    boolean loginSuccess;

   public  boolean verifyUserLogin(String username, String password, String filepath, String splitter){

       String currentLine;
    try{
    //FileReader DBReader = new FileReader(filepath);
   // BufferedReader br = new BufferedReader(DBReader);

        //just testing some code...
        BufferedReader br = new BufferedReader(new FileReader("Data/userDB.txt"));

        //while loop storing next line to currentLine, if it's not equal to null. (not empty)
        //if it's NOT equal to null, there's more data in the file we want to read
        //if its equal to null there's nothing more we need to read.
    while((currentLine = br.readLine()) !=null){
        // each element of this array is gonna be determined by where a comma is. userData being split at current line, when splitter is met, which is a comma.
        userData = currentLine.split(splitter);
        // here, we check if the username and the password match ( userData[0] being username and [1] being password)
        // and they need to be on the same line of the text file. So if BOTH strings are true, then this if statement run.
        if(userData[0].equals(username) && userData[1].equals(password)){
            return loginSuccess = true;
        }
    }



    }
    //catch, a failsafe.
    catch (Exception e){
        System.out.println("it went wrong");
    }
        return loginSuccess = false;
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
