package by.Astapkina.bookshop.greetingCard;

import by.Astapkina.bookshop.edition.Edition;

public class GreetingCard extends Edition {
    Size sizeCard;

    public GreetingCard() {
        super();
    }

    public GreetingCard(String author, String name, int year, int num_of_pages, int cost, Size size) {
        super(author, name, year, num_of_pages, cost);
        sizeCard = size;
    }

    @Override
    public String toString() {
        return "Открытка " + getName() + " размером " + sizeCard + ", стоимостью " + getCost();
    }
}
