package by.Astapkina;

public class Manufacturer {
    public int requisites;
    public String name;
    public String country;

    @Override
    public String toString() {
        return "Manufacturer{" +
                "requisites=" + requisites +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
