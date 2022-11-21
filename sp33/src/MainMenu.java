package sp33.src;

import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {

//Search for movie related stuff
    private String searchMovie() {
        JflixDB movies = new JflixDB();
        JflixDB2 movies2 = new JflixDB2();

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        ArrayList<Movie> search = movies.movieListCategorize(movies2.MakeResultSetMovieList());


        for (int i = 0; i < search.size(); i++) {
            if (search.get(i).name.equalsIgnoreCase(input)) {
                System.out.println(search.get(i).toString());
                return search.get(i).toString();
            }

        }
        System.out.println("Sorry we dont have that");
        System.out.println("Try to search again: ");
        searchMovie();
        return null;
    }


    private String searchYear() {
        JflixDB movies = new JflixDB();
        JflixDB2 movies2 = new JflixDB2();
        ArrayList<Movie> search = movies.movieListCategorize(movies2.MakeResultSetMovieList());
        ArrayList<Movie> listing = new ArrayList<>();

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        if(input.length()<4){
            System.out.println("Sorry! We dont have any movies for that year..");
           return searchYear();
        }

        for (int i = 0; i <search.size() ; i++) {
            if(search.get(i).year.contains(input)){
                listing.add(search.get(i));
            }

        }


        System.out.println("We have these movies for that year: ");
        System.out.println(listing);
        return ""+listing;
    }

    private String searchgenre() {
        MainMenu menu = new MainMenu();
        JflixDB movies = new JflixDB();
        JflixDB2 movies2 = new JflixDB2();
        ArrayList<Movie> search = movies.movieListCategorize(movies2.MakeResultSetMovieList());
        ArrayList<Movie> listing = new ArrayList<>();//An array to hold all the movies containing the genre in the input

        Scanner scan = new Scanner(System.in);
        String input = (scan.nextLine());


        String input2 = input.replace(input.substring(0,1),input.substring(0,1).toUpperCase()); //Makes a new string that takes input and replaces first char with the same char to uppercase

        if(input2.length()<=3){ //If input is to short restarts funktion
            System.out.println("Sorry! We dont have that genre..");

            return menu.searchgenre();
        }

        for (int i = 0; i <search.size() ; i++) {

            if(search.get(i).genre.contains(input2)){
                listing.add(search.get(i));
            }

        }

        if(listing.size()<1){
            System.out.println("Try again");
            return menu.searchgenre();
        }
        System.out.println(listing);
        return "We have these movies for that genre : "+listing;
    }

    //Search for series related stuff
    private String searchSeries() {
        JflixDB series = new JflixDB();
        JflixDB2 series2 = new JflixDB2();
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        ArrayList<Series> search = series.seriesListCategorize(series2.MakeResultSetSeriesList());


        for (int i = 0; i < search.size(); i++) {
            if (search.get(i).name.equalsIgnoreCase(input)) {
                System.out.println(search.get(i).toString());
                return search.get(i).toString();
            }

        }
        System.out.println("Sorry we dont have that");
        System.out.println("Try to search again: ");

        return searchSeries();
    }


    private String searchSeriesYear() {
        JflixDB series = new JflixDB();
        JflixDB2 series2 = new JflixDB2();
        ArrayList<Series> search = series.seriesListCategorize(series2.MakeResultSetSeriesList());
        ArrayList<Series> listing = new ArrayList<>();

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        if(input.length()<4){
            System.out.println("Sorry! We dont have any movies for that year..");
            searchSeriesYear();
        }

        for (int i = 0; i <search.size() ; i++) {
            if(search.get(i).year.contains(input)){
                listing.add(search.get(i));
            }

        }

        if(listing.size()<1){
            System.out.println("Sorry we dont have any series from that year");

            return  searchSeriesYear();
        }
        System.out.println(listing);
        return "We have these movies for that year: "+listing;
    }

    private String searchSeriesGenre() {
        JflixDB series = new JflixDB(); // Her bruges txt filer.
        JflixDB2 series2 = new JflixDB2();// Her bruges database.
        ArrayList<Series> search = series.seriesListCategorize(series2.MakeResultSetSeriesList());
        ArrayList<Series> listing = new ArrayList<>();//An array to hold all the series containing the genre in the input

        Scanner scan = new Scanner(System.in);
        String input = (scan.nextLine());


        String input2 = input.replace(input.substring(0,1),input.substring(0,1).toUpperCase()); //Makes a new string that takes input and replaces first char with the same char to uppercase

        if(input2.length()<=3){ //If input is to short restarts funktion
            System.out.println("Sorry! We dont have that genre..");
            return searchgenre();
        }

        for (int i = 0; i <search.size() ; i++) {

            if(search.get(i).genre.contains(input2)){
                listing.add(search.get(i));
            }

        }

        System.out.println(listing);
        return "We have these movies for that genre : "+listing;
    }


//Choice gathers all the functions above in one function the user can use to navigate to what they want.
    public String choice(){
      //Choose to search for movies or series
        Scanner scan = new Scanner(System.in);
      MainMenu menu = new MainMenu();
        System.out.println("To search for movie, type 1: ");
        System.out.println("To search for series, type 2: ");
      String input = scan.nextLine();

if(input.equalsIgnoreCase("1")) { // if movie is chosen, you get these choices.
    System.out.println("To search for movie, type 1: ");
    System.out.println("To search sertain genre, type 2: ");
    System.out.println("To search sertain year, type 3: ");

    String input2 = scan.nextLine();

    if (input2.equals("1")) { //if input is 1 search for a specifik movie..
        System.out.println("Search for movie: ");
        return menu.searchMovie();
    }

    if (input2.equals("2")) {
        System.out.println("What genre do you want?: ");
        menu.searchgenre();
        System.out.println("Choose a movie from the list: ");
        return menu.searchMovie();
    }

    if (input2.equals("3")) {
        System.out.println("What year would you like to search for?: ");
        menu.searchYear();
        System.out.println("Pick a movie from the list: ");
        return menu.searchMovie();
    }
}

if(input.equalsIgnoreCase("2")){ //searches for series related stuff..
    System.out.println("To search for series, type 1: ");
    System.out.println("To search certain genre, type 2: ");
    System.out.println("To search certain year, type 3: ");
    String input3 = scan.nextLine();

    if (input3.equals("1")) {
        System.out.println("Search for series: ");
        return menu.searchSeries();
    }

    if (input3.equals("2")) {
        Scanner choose = new Scanner(System.in);
        System.out.println("What genre do you want?: ");
        menu.searchSeriesGenre();


        System.out.println("Pick a series from the list");
        return menu.searchSeries();
    }

    if (input3.equals("3")) {
        System.out.println("What year would you like to search for?: ");
        menu.searchSeriesYear();
        System.out.println("Pick a series from the list");
        return menu.searchSeries();
    }
}
        System.out.println("You have to type in one of the numbers '1' or '2': ");
        menu.choice();
      return null;
    }



}
