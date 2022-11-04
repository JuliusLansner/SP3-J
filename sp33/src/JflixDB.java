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
                data.add(input.nextLine());//Adds input on the next line.
            }
        } catch (FileNotFoundException e) {
            data = null;
        }

        return data;
    }

    public ArrayList<String> movieListCategorize(ArrayList<String> data) {
        ArrayList<String> list = new ArrayList<>();

        String[] values = new String[0];
        for (int i = 0; i < data.size(); i++) {
            String s = data.get(i);// puts strings from data into s

            values = s.split(";");

            //Gives a variable for each index
            String name = values[0];


            //adds all the data on those values to the arraylist
            list.add(name);



        }
        //System.out.println(list);

        return list;

    }


    public ArrayList<String> yearListCategorize(ArrayList<String> data) {
        ArrayList<String> list = new ArrayList<>();

        String[] values = new String[0];
        for (int i = 0; i < data.size(); i++) {
            String s = data.get(i);// puts strings from data into s

            values = s.split(";");

            //Gives a variable for each index
            String name = values[0];
            String year = values[1];


            //adds all the data on those values to the arraylist
            list.add(year+name);




        }
        //System.out.println(list);

        return list;

    }


}
