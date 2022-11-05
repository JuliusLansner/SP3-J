package sp33.src;

public class Movie {
    private String name;
    private String genre;
    private String year;
    private String rating;

    public Movie(String name,String genre,String year,String rating){
        this.name = name;
        this.year=year;
        this.genre = genre;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", year='" + year + '\'' +
                ", rating='" + rating + '\'' +
                '}';
    }
}
