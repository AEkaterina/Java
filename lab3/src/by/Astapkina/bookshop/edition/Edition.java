package by.Astapkina.bookshop.edition;

public abstract class Edition {
    public String author;
    public String name;
    public int year;
    public int num_of_pages;
    public int cost;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year < 1800 && year > 2022) {
            System.out.println("Неверная дата издания");
        }
        else {
            this.year = year;
        }
    }

    public int getNum_of_pages() {
        return num_of_pages;
    }

    public void setNum_of_pages(int num_of_pages) {
        if (num_of_pages > 0) {
            this.num_of_pages = num_of_pages;
        }
        else {
            System.out.println("Число страниц не может быть отрицательным!");
        }
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        if (cost > 0 ) {
            this.cost = cost;
        }
        else {
            System.out.println("Цена не может быть отрицательной!");
        }
    }

    public Edition(String author, String name, int year, int num_of_pages, int cost) {
        this.author = author;
        this.name = name;
        this.year = year;
        this.num_of_pages = num_of_pages;
        this.cost = cost;
    }

    public Edition() {
    }
}
