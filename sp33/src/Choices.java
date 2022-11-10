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
   String play = test.choice();// kører choice funktionen

System.out.println("press 1 to play");
System.out.println("press 2 to save");
String input = scan.nextLine();
//en writer til content watched filem
BufferedWriter writer = new BufferedWriter(new FileWriter("Data/ContentWatched.txt", true));
//en writer til savedcontent filen
BufferedWriter writer2 = new BufferedWriter(new FileWriter("Data/SavedContent.txt", true));


if(input.equals("1") && checkWatchList(username +" "+ play) == false) {
    writer.write("\n"+username +" "+ play);
    writer.close();
}else if(input.equals("1") && checkWatchList(username +" "+ play) == true){
    System.out.println("You already watched this");
}

if(input.equals("2") && checkSavedContentList(username + " " + play)==false) {
    writer2.write("\n" + username + " " + play);
    writer2.close();
}else if(input.equals("2") && checkSavedContentList(username + " " + play)==true){
    System.out.println("You already watched this");
        }

    }

public boolean checkWatchList(String input) {
JflixDB lineArray = new JflixDB();
lineArray.getWatchList();
    for (int i = 0; i <lineArray.getWatchList().size() ; i++) {
        if(lineArray.getWatchList().get(i).equalsIgnoreCase(input)){

            return true;
        }
    }
    
    return false;
 }

    public boolean checkSavedContentList(String input) {
        JflixDB lineArray = new JflixDB();
        lineArray.getSavedContentList();
        for (int i = 0; i <lineArray.getSavedContentList().size() ; i++) {
            if(lineArray.getSavedContentList().get(i).equalsIgnoreCase(input)){

                return true;
            }
        }

        return false;
    }
}
