package sp33.src;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class JflixDB {
    // movie array
    ArrayList<String>movies = new ArrayList<>();
    ArrayList<String>series = new ArrayList<>();
    //seperating movies into objects
    ArrayList<Movie> movieList = new ArrayList<>();

    ArrayList<String>seriesList= new ArrayList<>();

    public void loadFiles(){
        getMovies();
        getSeries();
        seriesListCategorize(series);
        movieListCategorize(movies);
    }


    public ArrayList<String> getMovies(){
       // ArrayList<String>movies = new ArrayList<>();
        //not used anywhere
        //String movie;
        try {

            Scanner scan = new Scanner(new File("data/Movies.txt"));
            String str = scan.nextLine();

            while(scan.hasNextLine()){
                movies.add(scan.nextLine());
            }


        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }



        return movies;
    }




    public ArrayList<Movie> movieListCategorize(ArrayList<String> data) {


        String[] values = new String[0];
        for (int i = 0; i < data.size(); i++) {
            String s = data.get(i);// puts strings from data into s

            values = s.split(";");

            //Gives a variable for each index
            String name = values[0];
            String year = values[1];
            String genre = values[2];
            String rating = values[3];


            Movie movies1 = new Movie(name,genre,year,rating);
            //adds all the data on those values to the arraylist
            movieList.add(movies1);



        }


        return movieList;

    }

    public ArrayList<String> getSeries(){


        try {

            Scanner scan = new Scanner(new File("data/Series.txt"));
            String str = scan.nextLine();

            while(scan.hasNextLine()){
                series.add(scan.nextLine());
            }


        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }



        return series;
    }




    public ArrayList<Series> seriesListCategorize(ArrayList<String> data) {


        String[] values = new String[0];
        for (int i = 0; i < data.size(); i++) {
            String s = data.get(i);// puts strings from data into s

            values = s.split(";");

            //Gives a variable for each index
            String name = values[0];
            String year = values[1];
            String genre = values[2];
            String rating = values[3];
            String episodes = values[4];



            Series Series1 = new Series(name,year,genre,rating,episodes);
            //adds all the data on those values to the arraylist
            seriesList.add(Series1);



        }


        return seriesList;

    }

    public ArrayList<String> getWatchList(){
        ArrayList<String>linesToCheck = new ArrayList<>();

        try {

            Scanner scan = new Scanner(new File("data/ContentWatched.txt"));
            String str = scan.nextLine();

            while(scan.hasNextLine()){
                linesToCheck.add(scan.nextLine());
            }


        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }



        return linesToCheck;
    }


    public ArrayList<String> getSavedContentList(){
        ArrayList<String>linesToCheck = new ArrayList<>();

        try {

            Scanner scan = new Scanner(new File("data/SavedContent.txt"));
            String str = scan.nextLine();

            while(scan.hasNextLine()){
                linesToCheck.add(scan.nextLine());
            }


        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }



        return linesToCheck;
    }


}
