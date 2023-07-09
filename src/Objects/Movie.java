package Objects;

import java.util.ArrayList;

public class Movie {

    public String name;

    public String star;


    public String movieTime;

    public Movie(String name)
    {
        this.name = name;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getMovieTime() {
        return movieTime;
    }

    public void setMovieTime(String movieTime) {
        this.movieTime = movieTime;
    }

}
