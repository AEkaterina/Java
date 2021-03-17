package by.Astapkina.bookshop.comics;

import by.Astapkina.bookshop.edition.Edition;

public class Comics extends Edition {
    ComType comType;

    public Comics() {
        super();
    }

    public Comics(String author, String name, int year, int num_of_pages, int cost, ComType type) {
        super(author, name, year, num_of_pages, cost);
        comType = type;
    }

    @Override
    public String toString() {
        return "Комикс " + getName() + ", типа " + comType + ". Автор " + getAuthor()
                + ", год издания " + getYear() + ", количество страниц " + getNum_of_pages()
                + ". Стоимость " + getCost();
    }
}
