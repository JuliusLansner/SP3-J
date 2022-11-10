package sp33.src;

import javax.naming.directory.SearchResult;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Choices extends UserDB {
    String filepath = "Data/ContentWatched.txt";
    MainMenu test = new MainMenu();
    saveMenu save = new saveMenu();

    public void choiceFunction() throws IOException {
        Scanner scan = new Scanner(System.in);
        MainMenu mainmenu = new MainMenu();
        System.out.println("What user you want to use: ");
        String user = getUsername();
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
            System.out.println("already watched this");
        }

        if(input.equals("3")){
            removeRecord("SavedContent.txt","");
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
        //Delete from watch later list. Should be working.
         Scanner scanner;


        public void removeRecord(String filepath, String removeTerm){

            System.out.println("Please type the title of the content you wish to remove from your list: ");

            Scanner getInput = new Scanner(System.in);
            String id = getInput.nextLine();

            String tempFile = "temp.txt";
            //creating file objects
            File oldFile = new File(filepath);
            File newFile = new File(tempFile);

            String title;
            String year;
            String genre;
            String rating;
            String rating1;
            String rating2;
            String rating3;

            try {
                //write to tempFile using data from movielist
                FileWriter fw = new FileWriter(tempFile, true);
                //interact with FileWriter
                BufferedWriter bw = new BufferedWriter(fw);
                //take in what BufferedWriter has
                PrintWriter pw = new PrintWriter(bw);

                //read from the file
                scanner = new Scanner(new File(filepath));
                //each movie is seperated by , or new line
                scanner.useDelimiter("[,;\n]"); //removed ,

                while (scanner.hasNext()) {//changed from old scanner to new scanner
                    title = scanner.next();//changed from old scanner to new scanner
                    year = scanner.next();
                    genre = scanner.next();
                    rating = scanner.next();
                    rating1 = scanner.next();
                    rating2 = scanner.next();
                    rating3 = scanner.next();

                    if (!title.equalsIgnoreCase(id)) {
                        pw.println(title + "," + year + "," + genre + "," + rating + "," + rating1 + "," + rating2 + "," + rating3); //lappe løsning
                    }
                }
                scanner.close();//changed from old scanner to new scanner
                pw.flush();
                pw.close();
                oldFile.delete();
                File dump = new File(filepath);
                newFile.renameTo(dump);

                System.out.println("you have now removed: " + id);

            } catch (Exception e) {
                System.out.println("something went wrong");
            }

        }

}
