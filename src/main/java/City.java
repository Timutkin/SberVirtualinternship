import lombok.NonNull;
import lombok.Value;

@Value
public class City {
    @NonNull
    String name;
    @NonNull
    String region;
    @NonNull
    String district;
    @NonNull
    String population;
    @NonNull
    String foundation;

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", district='" + district + '\'' +
                ", population='" + population + '\'' +
                ", foundation='" + foundation + '\'' +
                '}';
    }
}
