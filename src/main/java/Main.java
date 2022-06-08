import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main{

    private static List<City> cities = new ArrayList();

    private  static final Path THE_PATH_TO_THE_LIST_OS_CITIES = Paths.get("C:\\Users\\1\\Desktop\\Yandex\\Сity_ru.txt");


    private static void AddsCitiesIntoListFromTxtFile() {
        try(Scanner scanner = new Scanner(THE_PATH_TO_THE_LIST_OS_CITIES)){
            while (scanner.hasNext()){
                String tempCity = scanner.nextLine();
                String[] list = tempCity.split(";");
                if (list.length == 6){
                    String name = list[1];
                    String region = list[2];
                    String district  = list[3];
                    String population  = list[4];
                    String foundation = list[5];
                    cities.add(new City(name, region,district,population, foundation));
                }
                else{
                    String name = list[1];
                    String region = list[2];
                    String district  = list[3];
                    String population  = list[4];
                    String foundation = "Информация отсутствует";
                    cities.add(new City(name, region,district,population, foundation));
                }

            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void printCities(){
        for (City city : cities){
            System.out.println(city);
        }
    }

    public static void main(String[] args) throws IOException {
        AddsCitiesIntoListFromTxtFile();
        printCities();
    }
}
