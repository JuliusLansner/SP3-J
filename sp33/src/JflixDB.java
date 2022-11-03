package sp33.src;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class JflixDB {

    public JflixDB(){

    }

    public  ArrayList<String> getMovies() {
        File file = new File("Data/Movies.txt");
        ArrayList<String> data = new ArrayList<>();
        try {
            Scanner input = new Scanner(file);
            String str = input.nextLine();//ignorer header

            while (input.hasNextLine()) {
                data.add("\n,"+input.nextLine());//Adds input on the next line.
            }
        } catch (FileNotFoundException e) {
            data = null;
        }

        return data;
    }

    public ArrayList<String> movieListCategorize(ArrayList<String> data){
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < data.size(); i++) {
            String s = data.get(i);// puts strings from data into s

            String[] values = s.split(",");// Makes an array with each string from data, and splits them for each comma

           //Gives a variable for each index on the lines.
            String name = values[0];
            String year = values[1];
            String genre = values[2];

            //adds all the arrays to the arraylist list
            list.add(name);
            list.add(year);
            list.add(genre);

        }

        return list;

    }


}
