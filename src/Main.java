import Objects.Category;
import Objects.PlatformList;
import Objects.Movie;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashSet;
public class Main {
    public static void main(String[] args) {
        PlatformList platList = new PlatformList();
        Scanner scan = new Scanner(System.in);
        scan.useDelimiter("\\n");

        boolean quit = false;
        while(!quit){
            System.out.print("Please choose the user type: \n1- Client \n2- Admin\n0- Quit\n");
            int userType = scan.nextInt();
            
            // Client Section
            
            if (userType == 1) {

                ArrayList<String> platformNames = platList.getPlatformNames();
                String out = "";
                int index = 1;
                for (String name : platformNames) {
                    out += Integer.toString(index) + "-" + name + " ";
                    index++;
                }
                System.out.print("Choose the platform : "+out);
                int platIndex = scan.nextInt();
                String platName = "";

                if (platIndex >= 1 && platIndex <= platformNames.size()) {
                    platName = platformNames.get(platIndex - 1);
                } else {
                    System.out.println("Invalid platform selection. Please choose a valid platform.");
                    System.out.println("Please enter a value from the admin section.");
                    continue;
                }
                
                // Display available categories for the selected platform
                
                ArrayList<String> categoryNames = platList.getCategoryNamesByPlatform(platName);
                String out2 = "";
                int index2 = 1;
                for (String name : categoryNames) {
                    out2 += Integer.toString(index2) + "-" + name + ": "+platList.getPlatformByName(platName).getCategoryList().getCategoryByName(categoryNames.get(index2-1)).getDetail()+"\n";
                    index2++;
                }
                System.out.print("Choose the category :\n"+out2);
                int catIndex = scan.nextInt();
                String catName = categoryNames.get(catIndex-1);

                HashSet<Movie> movieSet = platList.getPlatformByName(platName).getCategoryList().getCategoryByName(catName).movieHs;

                System.out.print("This category has "+ movieSet.size() +" movies.\n");
                for(Movie mov : movieSet){
                    System.out.print("-- "+mov.name+"\n");
                    System.out.print("\tStar: "+mov.getStar()+"\n");
                    System.out.print("\tTime: "+mov.getMovieTime()+"\n");
                }

                System.out.print("Press 0 to turn back.\n");
                int back = scan.nextInt();


            } else if (userType == 2) {
                boolean exit = false;
                while(!exit){
                    System.out.print("Please choose one of below items to add:\n1-Platform\n2-Category\n3-Movie\n0-Back\n");
                    int adminChoice = scan.nextInt();

                    switch(adminChoice) {
                        case 1:
                            System.out.print("Please enter platform name: ");
                            String platformName = scan.next(); // Yeni bir platform oluşturmak için platform adını kullanıcıdan alır.
                            platList.createPlatform(platformName);
                            break;
                        case 2:
                            System.out.print("Please enter category name: ");
                            String categoryName = scan.next();

                            System.out.print("Please enter category detail: ");
                            String categoryDetail = scan.next();

                            platList.createCategory(categoryName, categoryDetail);
                            break;
                        case 3:
                            ArrayList<String> platformNames = platList.getPlatformNames();
                            String out = "";
                            int index = 1;
                            for (String name : platformNames) {
                                out += Integer.toString(index) + "-" + name + " ";
                                index++;
                            }
                            System.out.print("Choose the platform : "+out);
                            int platIndex = scan.nextInt();
                            String platName = platformNames.get(platIndex-1);

                            ArrayList<String> categoryNames = platList.getCategoryNamesByPlatform(platName);
                            String out2 = "";
                            int index2 = 1;
                            for (String name : categoryNames) {
                                out2 += Integer.toString(index2) + "-" + name + " ";
                                index2++;
                            }
                            System.out.print("Choose the category : "+out2);
                            int catIndex = scan.nextInt();
                            String catName = categoryNames.get(catIndex-1);

                            System.out.print("Please enter movie name: ");
                            String movieName = scan.next();
                            Movie mov = new Movie(movieName);

                            System.out.print("Please enter Star name: ");
                            String starName = scan.next();
                            mov.setStar(starName);

                            System.out.print("Please enter movie time: ");
                            String movieTime = scan.next();
                            mov.setMovieTime(movieTime);

                            platList.addMovieToCategoryByPlatform(mov, platName, catName);

                            break;
                        default:
                            exit = true;
                            break;
                    }

                }
            }
            else
            {
                quit = true;
            }
        }


    }
}
