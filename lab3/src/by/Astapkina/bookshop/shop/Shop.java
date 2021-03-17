package by.Astapkina.bookshop.shop;

import by.Astapkina.bookshop.edition.Edition;
import by.Astapkina.bookshop.greetingCard.GreetingCard;

import java.util.ArrayList;

public class Shop {
    String name;

    public Shop(String name) {
        this.name = name;
    }
    public Shop() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    ArrayList<Edition> book = new ArrayList<>();

    public void setBook(ArrayList<Edition> book) {      //инициал магазина
        if (book == null)
            throw new NullPointerException("Null pointer");
        this.book = book;
    }

    public ArrayList<Edition> getBook() {
        return book;
    }

    public void AddBook (Edition edit) {        //добавить
        if(edit == null)
            throw new NullPointerException("Null pointer");
        this.book.add(edit);
        System.out.println("В магазин " + getName() + " было добавлено " + edit.getName() + ", " + edit.getAuthor()
                + " стоимостью " + edit.getCost());
    }

    public ArrayList<Edition> ShowBook() {
        return this.book;
    }   //вывести список книг

    public void SellBook(Edition edit) {    //продать
        if (edit == null)
            throw new NullPointerException("Null pointer");
        this.book.remove(edit);
        System.out.println("Издание " + edit.getName() + " была продана за " + edit.getCost());
    }
}
