import lombok.NonNull;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The type City utils.
 *
 * @author Timofey Utkin
 * @version 1.0  09.06.2022
 */
public class CityUtils {

    /**
     * The constant THE_PATH_TO_THE_LIST_OS_CITIES.
     */
    /*
     * The constant THE_PATH_TO_THE_LIST_OS_CITIES which
     * specifies the path to the file with the cities
     */
    private  static final Path THE_PATH_TO_THE_LIST_OS_CITIES = Paths.get("src/main/resources/Сity_ru.txt");

    /**
     * Get list cities from txt file list.
     *
     * @return the list
     */
    /*
     * Get list cities from txt file list.
     *
     * @return the list
     */
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

    /**
     * Print cities.
     *
     * @param cities the cities
     */
    public static void printCities(List<City> cities){
        cities.forEach(System.out::println);
    }

    /**
     * Parse city.
     *
     * @param line the line
     * @return the city
     */
    /*
     * Parse city.
     *
     * @param line the line
     * @return {@link City}
     */
    private static City parse(String line){
       try(Scanner scanner = new Scanner(line)){
           scanner.useDelimiter(";");
           scanner.skip("\\d*");
           String name = scanner.next();
           String region = scanner.next();
           String district = scanner.next();
           int population = scanner.nextInt();
           String foundation = "Информация отсутствует";
           if (scanner.hasNext()) {
               foundation = scanner.next();
           }
           return new City(name, region, district, population, foundation);
       }
    }


    /**
     * Sorted cities by district and name list.
     *
     * @param cities the cities
     * @return the list
     */
    /*
     * Sorted cities by district and name list.
     *
     * @param cities the cities
     * @return the list
     */
    protected static List<City> sortedCitiesByDistrictAndName(@NonNull List<City> cities) {
        Stream<City> cityStream = cities.stream().sorted(Comparator.comparing(City::getDistrict).thenComparing(City::getName));
        List<City> sortedListOfCities = cityStream.collect(Collectors.toList());
        return sortedListOfCities;
    }

    /**
     * Sorted cities by name list.
     *
     * @param cities the cities
     * @return the list
     */
    /*
     * Sorted cities by name list.
     *
     * @param cities the cities
     * @return the sorted list by name
     */
    protected static List<City> sortedCitiesByName(@NonNull List<City> cities) {
        Stream<City> cityStream = cities.stream().sorted(Comparator.comparing(o1-> o1.getName().toLowerCase(Locale.ROOT)));
        List<City> sortedListOfCities = cityStream.collect(Collectors.toList());
        return sortedListOfCities;
    }

    /**
     * Print city with max population.
     *
     * @param cities the cities
     */
    public static void printCityWithMaxPopulation(City[] cities){
        int maxPopulation = cities[0].getPopulation();
        int indexOfMaxPopulation = 0;
        for (int i = 1; i < cities.length; i++) {
            if(cities[i].getPopulation() > maxPopulation){
                maxPopulation = cities[i].getPopulation();
                indexOfMaxPopulation = i;
            }
        }
        System.out.printf("[%d]=%d",indexOfMaxPopulation,maxPopulation);
    }

    /**
     * To array list of cities city [ ].
     *
     * @param cities the cities
     * @return the city [ ]
     */
    public static City[] toArrayListOfCities(List<City> cities){
        return cities.toArray(new City[cities.size()]);
    }
}
