package by.Astapkina;

public class Souvenir {
    public int id;
    public String name;
    public int requisites;
    public int date;
    public int price;

    @Override
    public String toString() {
        return "Souvenir{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", requisites=" + requisites +
                ", date=" + date +
                ", price=" + price +
                '}';
    }
}
