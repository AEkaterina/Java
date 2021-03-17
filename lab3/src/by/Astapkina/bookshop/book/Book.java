package by.Astapkina.bookshop.book;

import by.Astapkina.bookshop.edition.Edition;

public class Book extends Edition {
    class Publisher {
        public String name;
        public Book book;

        public Publisher(String name) {
            book=Book.this;
            this.name = name;
        }
    }

    public Publisher publisher;
    BookType bookType;

    public Book () {
        super();
    }

    public Book (String author, String name, int year, int cost, int num_of_pages, String publish, BookType type) {
            super(author, name, year, num_of_pages, cost);
            publisher = new Publisher(publish);
            bookType = type;
    }

    @Override
    public String toString() {
        return "Книга " + getName() + " автора " + getAuthor() + ", года издания " + getYear()
                + ", количество страниц" + getNum_of_pages() + ", стоимостью " + getCost()
                + ". Издатель " + publisher.name + ", жанр " + bookType;
    }
}
