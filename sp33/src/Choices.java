package sp33.src;

import javax.naming.directory.SearchResult;
import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Choices extends UserDB {
    String filepath = "Data/ContentWatched.txt";
<<<<<<< Updated upstream
MainMenu test = new MainMenu();
    saveMenu save = new saveMenu();
    public void choiceFunction() throws IOException {
Scanner scan = new Scanner(System.in);
MainMenu mainmenu = new MainMenu();
   String play = test.choice();// kører choice funktionen

System.out.println("press 1 to play the movie");
String input = scan.nextLine();
BufferedWriter writer = new BufferedWriter(new FileWriter("Data/ContentWatched.txt", true));

if(input.equals("1") && checkWatchList(userName +" "+ play) == false) {
    writer.write("\n"+userName +" "+ play);
    writer.close();
}else{
    System.out.println("You already watched this");
}
=======
    MainMenu test = new MainMenu();


    public void choiceFunction() throws IOException, SQLException {
        User user1 = new User();
        user1.profilesArray();
        String name ="";

        Scanner scan = new Scanner(System.in);
        MainMenu mainmenu = new MainMenu();
        StartMenu login = new StartMenu();

        System.out.println("Welcome to Jflix");
        System.out.println("Please choose an existing user, or create a new one");
        System.out.println("Login to user 1: Press 1");
        System.out.println("Create a new user: Press 2");
        System.out.println("Enter your choice: ");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        if (answer.contains("1")) {
            name = login.loginExistingUser();

        }
        if(answer.contains("2")){
            login.signupuser();
        }


       String play = mainmenu.choice();



        System.out.println("press 1 to play");
        System.out.println("press 2 to save");
        System.out.println("press 3 to delete something");
        String input = scan.nextLine();
//en writer til content watched filem
        BufferedWriter writer = new BufferedWriter(new FileWriter("Data/ContentWatched.txt", true));
//en writer til savedcontent filen
        BufferedWriter writer2 = new BufferedWriter(new FileWriter("Data/SavedContent.txt", true));
//Hvis man vælger play
        if (input.equals("1") && checkWatchList(name + " " + play) == false) {
            writer.write("\n" + name + " " + play);
            writer.close();
        } else if (input.equals("1") && checkWatchList(name + " " + play) == true) {
            System.out.println("already watched this");
        }

//Hvis man vælger savecontent
        if (input.equals("2") && checkSavedContentList(name + " " + play) == false) {
            writer2.write("\n" + name + " " + play);
            writer2.close();
        } else if (input.equals("2") && checkSavedContentList(name + " " + play) == true) {
            System.out.println("already saved this");
        }

        if(input.equals("3")){
            removeRecord("Data/SavedContent.txt");
        }

    }

    public boolean checkWatchList(String input) {
        JflixDB lineArray = new JflixDB();
        lineArray.getWatchList();
        for (int i = 0; i < lineArray.getWatchList().size(); i++) {
            if (lineArray.getWatchList().get(i).equalsIgnoreCase(input)) {

                return true;
            }
        }

        return false;
>>>>>>> Stashed changes
    }

public boolean checkWatchList(String input) {
JflixDB lineArray = new JflixDB();
lineArray.getWatchList();
    for (int i = 0; i <lineArray.getWatchList().size() ; i++) {
        if(lineArray.getWatchList().get(i).equalsIgnoreCase(input)){
            System.out.println("true");
            return true;
        }
    }
    System.out.println("false");
    return false;
 }
}
