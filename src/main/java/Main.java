import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * The type Main.
 */
public class Main{
    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String[] args){
        List<City> cities = CityUtils.GetListCitiesFromTxtFile();
        findCountOfCityInEachRegion(cities);
    }

    /**
     * Find by simple brute force.
     *
     * @param cities the cities
     */
    private static void findBySimpleBruteForce(List<City> cities){
        City[] mass = CityUtils.toArrayListOfCities(cities);
        short indexOfCityWithMaxPopulation = 0;
        int maxPopulation = mass[0].getPopulation();
        for (int i = 1; i < mass.length ; i++) {
            if (mass[i].getPopulation() > maxPopulation){
                maxPopulation = mass[i].getPopulation();
                indexOfCityWithMaxPopulation = (short) i;
            }
        }
        System.out.println(String.format("[%d]=%d", indexOfCityWithMaxPopulation, maxPopulation));
    }

    /**
     * Find max population.
     *
     * @param cities the cities
     */
    private static void findMaxPopulation(List<City> cities) {
        System.out.println(cities.stream().max(Comparator.comparing(City::getPopulation)));
    }

    /**
     * Swap.
     *
     * @param <T>         the type parameter
     * @param elements    the elements
     * @param firstIndex  the first index
     * @param secondIndex the second index
     */
    private static <T> void swap(T[] elements, int firstIndex, int secondIndex){
        T temp = elements[firstIndex];
        elements[firstIndex] = elements[secondIndex];
        elements[secondIndex] = temp;
    }

    /**
     * Find by insertion sort.
     *
     * @param cities the cities
     */
    private static void findByInsertionSort(List<City> cities) {
        City[] mass = CityUtils.toArrayListOfCities(cities);
        for (int i = 0; i < mass.length ; i++) {
            for (int j = i; j > 0 && mass[j-1].getPopulation()> mass[j].getPopulation(); j--) {
                swap(mass, j, j-1);
            }
        }
        System.out.println(String.format("[%d]=%d",mass.length-1, mass[mass.length-1].getPopulation()));
    }

    /**
     * Find count of city in each region.
     *
     * @param cities the cities
     */
    private static void findCountOfCityInEachRegion(List<City> cities){
        Map<String, Long> groupOfRegions = cities.stream()
                .collect(Collectors.groupingBy(City::getRegion, Collectors.counting()));
        for (Map.Entry<String,Long> map : groupOfRegions.entrySet()){
            System.out.println(MessageFormat.format("{0} - {1} ",map.getKey(), map.getValue()));
        }
    }

}
