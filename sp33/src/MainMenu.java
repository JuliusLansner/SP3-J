package sp33.src;

import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {


    private String searchMovie() {
        JflixDB movies = new JflixDB();
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        ArrayList<Movie> search = movies.movieListCategorize(movies.getMovies());


        for (int i = 0; i < search.size(); i++) {
            if (search.get(i).name.equalsIgnoreCase(input)) {
                System.out.println(search.get(i).toString());
                return search.get(i).toString();
            }

        }

        return "Sorry we dont have that";
    }


    private String searchYear() {
        JflixDB movies = new JflixDB();
        ArrayList<Movie> search = movies.movieListCategorize(movies.getMovies());
        ArrayList<Movie> listing = new ArrayList<>();

        Scanner scan = new Scanner(System.in);
        System.out.println("What year would you like to search for: ");
        String input = scan.nextLine();


        for (int i = 0; i <search.size() ; i++) {
            if(search.get(i).year.contains(input)){
                listing.add(search.get(i));
            }

        }

        if(listing.size()<1){
            return "Sorry we dont have any movies from that year";
        }
        return "We have these movies for that year: "+listing;
    }

    private String searchgenre() {
        JflixDB movies = new JflixDB();
        ArrayList<Movie> search = movies.movieListCategorize(movies.getMovies());
        ArrayList<Movie> listing = new ArrayList<>();//An array to hold all the movies containing the genre in the input

        Scanner scan = new Scanner(System.in);
        System.out.println("What genre do you want: ");
        String input = (scan.nextLine());


        String input2 = input.replace(input.substring(0,1),input.substring(0,1).toUpperCase()); //Makes a new string that takes input and replaces first char with the same char to uppercase

        for (int i = 0; i <search.size() ; i++) {

            if(search.get(i).genre.contains(input2)){
                listing.add(search.get(i));
            }

        }

        if(listing.size()<1){
            return "Sorry we dont have that";
        }
        return "We have these movies for that genre : "+listing;
    }

    public String choice(){
      Scanner scan = new Scanner(System.in);
      MainMenu menu = new MainMenu();
        System.out.println("To search for movie type 1: ");
        System.out.println("To search sertain genre type 2: ");
        System.out.println("To search sertain year type 3: ");
      String input = scan.nextLine();


      if(input.equals("1")){
          System.out.println("Search for movie: ");
          return menu.searchMovie();
      }

      if(input.equals("2")){

            return menu.searchgenre();
      }

      if(input.equals("3")){
            
            return menu.searchYear();
      }

      return null;

    }



}
