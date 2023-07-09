package Objects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PlatformList {
    private HashMap<String,Platform> platformMap;

    public PlatformList(){
        this.platformMap = new HashMap<String,Platform>();
    }

    public void createPlatform(String platformName)
    {
        this.platformMap.put(platformName, new Platform(platformName));
    }

    public void createCategory(String categoryName, String detail)
    {
        for(Map.Entry<String,Platform> entry : this.platformMap.entrySet())
        {
            entry.getValue().createCategory(categoryName, detail);
        }
    }

    public ArrayList<String> getPlatformNames()
    {
        ArrayList<String> list= new ArrayList<>(this.platformMap.keySet());
        return list;
    }

    public ArrayList<String> getCategoryNamesByPlatform(String platformName)
    {
        Platform plat = this.platformMap.get(platformName);
        CategoryList catList = plat.getCategoryList();
        return catList.getCategoryNames();
    }

    public void addMovieToCategoryByPlatform(Movie movie, String platformName, String categoryName)
    {
        Platform plat = this.platformMap.get(platformName);
        plat.addMovieToCategory(movie, categoryName);
    }

    public Platform getPlatformByName(String platformName)
    {
        return platformMap.get(platformName);
    }

}
