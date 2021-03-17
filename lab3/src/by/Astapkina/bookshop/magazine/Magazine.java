package by.Astapkina.bookshop.magazine;

import by.Astapkina.bookshop.edition.Edition;

public class Magazine extends Edition {
    public Magazine(String author, String name, int year, int num_of_pages, int cost) {
        super(author, name, year, num_of_pages, cost);
    }

    public Magazine() {
        super();
    }

    @Override
    public String toString() {
        return "Журнал " + getName() + ", издатель " + getAuthor() + " года выпуска " + getYear()
                + ", количество страниц " + getNum_of_pages() + ", стоимость " + getCost();
    }
}
