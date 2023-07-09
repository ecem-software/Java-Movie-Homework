package Objects;
import java.util.HashSet;

public class Category {
    private String name;

    private String detail;
    public HashSet<Movie> movieHs;

    public Category(String name, String detail)
    {
        this.name = name;
        this.detail = detail;
        this.movieHs = new HashSet<Movie>();
    }

    public void addMovie(Movie movie)
    {
        this.movieHs.add(movie);
    }

    public int getMovieCount()
    {
        return this.movieHs.size();
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
