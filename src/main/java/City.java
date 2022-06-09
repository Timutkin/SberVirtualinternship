import lombok.NonNull;
import lombok.Value;
import lombok.experimental.NonFinal;

/**
 * The type City.
 * @author Timofey Utkin
 * @version 1.0
 * 09.06.2022
 */
@Value
/**
 * @Value all fields are made private and final by default,
 * and setters are not generated. The class itself is also made final by default,
 * toString(), equals() and hashCode() methods are also generated, each field gets
 * a getter method, and a constructor that covers every argument (except final fields
 * that are initialized in the field declaration) is also generated.
 */
@NonFinal
public class City {
    /**
     * The Name.
     */
    @NonNull
    String name;
    /**
     * The Region.
     */
    @NonNull
    String region;
    /**
     * The District.
     */
    @NonNull
    String district;
    /**
     * The Population.
     */
    @NonNull
    String population;
    /**
     * The Foundation.
     */
    @NonNull
    String foundation;

    /**
     * To string string.
     *
     * @return the string
     */
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
