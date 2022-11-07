package sp33.src;

public class Movie {
    String name;
    String genre;
    String year;
    String rating;
    public Movie(String name, String genre, String year,String rating){
        this.name = name;
        this.genre = genre;
        this.year = year;
        this.rating = rating;
    }
    @Override
    public String toString(){
        return name +""+genre+""+year+""+rating;
    }
}
