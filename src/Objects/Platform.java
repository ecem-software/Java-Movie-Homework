package Objects;

public class Platform {

    private String name;

    public CategoryList getCategoryList() {
        return categoryList;
    }

    private CategoryList categoryList;

    public Platform(String name){
        this.name=name;
        this.categoryList = new CategoryList(); //Platforma ait kategorileri içeren bir CategoryList özelliğidir.
    }

    public void createCategory(String categoryName, String detail) // Belirli bir kategori adı ve detay bilgisi alarak, platforma ait kategorilerin oluşturulmasını categoryList üzerinden gerçekleştirir.
    {
        this.categoryList.createCategory(categoryName, detail);
    }

    public void addMovieToCategory(Movie movie, String categoryName)
    {
        categoryList.addMovieToCategory(movie,categoryName);
    }

    public String getName() {
        return name;
    } //Platformun adını döndürür.

    public void setName(String name) {
        this.name = name;
    }
}
