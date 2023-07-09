package Objects;

public class Platform {

    private String name;

    public CategoryList getCategoryList() {
        return categoryList;
    }

    private CategoryList categoryList;

    public Platform(String name){
        this.name=name;
        this.categoryList = new CategoryList();
    }

    public void createCategory(String categoryName, String detail)
    {
        this.categoryList.createCategory(categoryName, detail);
    }

    public void addMovieToCategory(Movie movie, String categoryName)
    {
        categoryList.addMovieToCategory(movie,categoryName);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
