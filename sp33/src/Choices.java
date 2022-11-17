package sp33.src;

import javax.naming.directory.SearchResult;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Choices extends UserDB {
    String filepath = "Data/ContentWatched.txt";
    MainMenu test = new MainMenu();


    public void choiceFunction() throws IOException {
        User user1 = new User();
        user1.profilesArray();


        Scanner scan = new Scanner(System.in);
        MainMenu mainmenu = new MainMenu();
        System.out.println("What user you want to use: ");
        String user = user1.getUsername();
        String play = test.choice();// kører choice funktionen

        System.out.println("press 1 to play");
        System.out.println("press 2 to save");
        System.out.println("press 3 to delete something");
        String input = scan.nextLine();
//en writer til content watched filem
        BufferedWriter writer = new BufferedWriter(new FileWriter("Data/ContentWatched.txt", true));
//en writer til savedcontent filen
        BufferedWriter writer2 = new BufferedWriter(new FileWriter("Data/SavedContent.txt", true));
//Hvis man vælger play
        if (input.equals("1") && checkWatchList(user + " " + play) == false) {
            writer.write("\n" + user + " " + play);
            writer.close();
        } else if (input.equals("1") && checkWatchList(user + " " + play) == true) {
            System.out.println("already watched this");
        }

//Hvis man vælger savecontent
        if (input.equals("2") && checkSavedContentList(user + " " + play) == false) {
            writer2.write("\n" + user + " " + play);
            writer2.close();
        } else if (input.equals("2") && checkSavedContentList(user + " " + play) == true) {
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
