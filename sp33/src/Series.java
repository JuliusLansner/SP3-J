package sp33.src;

public class Series {
    String name;
    String genre;
    String year;
    String episodes;
    String rating;

    public Series(String name, String year, String genre,String rating,String episodes){
        this.name = name;
        this.genre = genre;
        this.year = year;
        this.rating = rating;
        this.episodes = episodes;
    }

    @Override
    public String toString(){
        return name +""+year+""+genre+""+rating+""+episodes;
    }
}
