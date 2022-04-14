package View;

public class Movie {

    private String name;
    private String date;
    private String rating;

    public Movie(String name, String date, String rating) {

        this.date = date;
        this.name = name;
        this.rating = rating;

    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getRating() {
        return rating;
    }

}
