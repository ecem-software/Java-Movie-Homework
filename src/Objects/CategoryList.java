package Objects;

import java.util.ArrayList;
import java.util.HashMap;

public class CategoryList {

    private HashMap<String,Category> categoryTable;

    public CategoryList(){
        this.categoryTable = new HashMap<String,Category>();
    }

    public void createCategory(String categoryName, String detail)
    {
        this.categoryTable.put(categoryName, new Category(categoryName, detail));
    }

    public ArrayList<String> getCategoryNames()
    {
        ArrayList<String> list= new ArrayList<>(this.categoryTable.keySet());
        return list;
    }

    public void addMovieToCategory(Movie movie, String categoryName)
    {
        categoryTable.get(categoryName).addMovie(movie);
    }

    public Category getCategoryByName(String categoryName)
    {
        return categoryTable.get(categoryName);
    }

}
