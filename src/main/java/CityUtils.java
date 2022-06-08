import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CityUtils {

    private  static final Path THE_PATH_TO_THE_LIST_OS_CITIES = Paths.get("src/main/resources/Сity_ru.txt");


    protected static List<City> GetListCitiesFromTxtFile() {
        List<City> cities = new ArrayList<>();
        try (Scanner scanner = new Scanner(THE_PATH_TO_THE_LIST_OS_CITIES)){
            while (scanner.hasNextLine()){
                cities.add(parse(scanner.nextLine()));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return cities;

    }
    public static void printCities(List<City> cities){
        cities.forEach(System.out::println);
    }

    private static City parse(String line){
       try(Scanner scanner = new Scanner(line)){
           scanner.useDelimiter(";");
           scanner.skip("\\d*");
           String name = scanner.next();
           String region = scanner.next();
           String district = scanner.next();
           String population = scanner.next();
           String foundation = "Информация отсутствует";
           if (scanner.hasNext()) {
               foundation = scanner.next();
           }
           return new City(name, region, district, population, foundation);
       }
    }

}
