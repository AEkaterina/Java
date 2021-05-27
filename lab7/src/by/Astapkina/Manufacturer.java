package by.Astapkina;

public class Manufacturer {
    public int requisites;
    public String name;
    public String country;

    public Manufacturer() {
    }

    public Manufacturer(int requisites, String name, String country) {
        this.requisites = requisites;
        this.name = name;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "requisites=" + requisites +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    public int getRequisites() {
        return requisites;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public void setRequisites(int requisites) {
        this.requisites = requisites;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
