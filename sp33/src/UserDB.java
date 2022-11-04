package sp33.src;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class UserDB extends User {


    //take info from user signup
    //get username and password, save in a text file
    public ArrayList<String> getUsers() {
        File file = new File("Data/userDB.txt");
        ArrayList<String> userData = new ArrayList<>();
        try {
            Scanner input = new Scanner(file);
            //pseudo kode
            if(){
                //mainmenu();
            }
        } catch (FileNotFoundException e) {
            userData = null;
        }

        return userData;
    }




    public ArrayList<String> movieListCategorize(ArrayList<String> data) {
        ArrayList<String> list = new ArrayList<>();

        String[] values = new String[0];
        for (int i = 0; i < data.size(); i++) {
            String s = data.get(i);// puts strings from data into s

            values = s.split(",");

            //Gives a variable for each index
            String name = values[1];
            String year = values[2];
            String genre = values[3];

            //adds all the arrays to the arraylist list
            list.add("\n" + name);
            list.add(year);
            list.add(genre);


        }
        //System.out.println(list);

        return list;

    }
}
