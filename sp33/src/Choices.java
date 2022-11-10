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
}else{
    System.out.println("You already watched this");
}

if(input.equals("2")){
    writer2.write("\n"+ username +" "+ play);
    writer.close();
}else{
    System.out.println("It's already here stupid");
}
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
