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
    public static void main(String[] args) throws IOException {
        List<City> cityList = CityUtils.GetListCitiesFromTxtFile();
        CityUtils.printCities(CityUtils.sortedCitiesByDistrictAndName(cityList));
    }
}
