package sp33.src;

import javax.naming.directory.SearchResult;
import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Choices extends UserDB {
    String filepath = "Data/ContentWatched.txt";
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
        SaveDeleteFunctions savedelete = new SaveDeleteFunctions();
//Hvis man vælger play
        if (input.equals("1") && checkWatchList(name + " " + play) == false) {
            writer.write("\n" + name + " " + play);
            writer.close();
        } else if (input.equals("1") && checkWatchList(name + " " + play) == true) {
            System.out.println("already watched this");
        }

//Hvis man vælger savecontent
        if (input.equals("2") && checkSavedContentList(name + " " + play) == false) {
            //writer2.write("\n" + name + " " + play);
            //writer2.close();
            savedelete.watchLater(name+" "+play);
        } else if (input.equals("2") && checkSavedContentList(name + " " + play) == true) {
            System.out.println("already saved this");
        }

        if(input.equals("3")){
            //removeRecord("Data/SavedContent.txt");
            savedelete.deleteContent(name+" "+play);
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
    }



    public boolean checkSavedContentList(String input) {
        JflixDB lineArray = new JflixDB();
        lineArray.getSavedContentList();
        for (int i = 0; i < lineArray.getSavedContentList().size(); i++) {
            if (lineArray.getSavedContentList().get(i).equalsIgnoreCase(input)) {

                return true;
            }
        }

        return false;

    }
        Scanner scanner;
        public void removeRecord(String filepath){
            User user1 = new User();
            System.out.println("To confirm write your username: ");
            String user = user1.getUsername();

            System.out.println("Please type the title of the content you wish to remove from your list: ");
            System.out.println("Please note that the input is case sensitive. Write the title exactly as it is stored.");
            System.out.println("If you wish to delete all of your saved content, type your username.");

            Scanner getInput = new Scanner(System.in);
            String id = getInput.nextLine();

            String tempFile = "Data/temp.txt";
            //creating file objects
            File oldFile = new File(filepath);
            File newFile = new File(tempFile);

            String title;
            String genre;
            String year;
            String rating;

            //reading and writing to the files
            try {
                //write to tempFile
                FileWriter fw = new FileWriter(tempFile, true);
                //interact with FileWriter
                BufferedWriter bw = new BufferedWriter(fw);
                //take in what BufferedWriter has
                PrintWriter pw = new PrintWriter(bw);

                //reads from the file
                scanner = new Scanner(new File(filepath));
                scanner.useDelimiter("[,\n]");

                //go through the loop until there are no more lines to read
                while (scanner.hasNext()) {
                    title = scanner.next();
                    genre = scanner.next();
                    year = scanner.next();
                    rating = scanner.next();
                    //If !input add line to temp.txt
                    if (!title.contains(id)) {
                        pw.println(title+","+genre+","+year+","+rating);
                    }
                }
                scanner.close();
                pw.flush();
                pw.close(); //no more writing to file
                oldFile.delete(); //deletes the old file
                File dump = new File(filepath);
                newFile.renameTo(dump);

                System.out.println("you have now removed: " + id);

            } catch (Exception e) {
                System.out.println("something went wrong");
            }
        }
}
