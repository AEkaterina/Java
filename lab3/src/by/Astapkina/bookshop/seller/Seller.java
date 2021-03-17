package by.Astapkina.bookshop.seller;

import by.Astapkina.bookshop.edition.Edition;
import java.util.*;
import by.Astapkina.bookshop.shop.Shop;

public class Seller implements ISeller{
    public Seller() {
    }

    @Override
    public void sort(Shop ed) {
        ArrayList<Edition> e = ed.ShowBook();
        e.sort(new Comparator<Edition>() {
            @Override
            public int compare(Edition o1, Edition o2) {
                return o1.getYear() > o2.getYear() ? -1 : (o1.getYear() > o2.getYear()) ? 1 : 0;
            }
        });
    }

    @Override
    public Shop find(Shop ed, String name) {
        if (name != null) {
            Shop sh = new Shop();
            System.out.println("Find the book");
            for (Edition e : ed.ShowBook()) {
                if (e.getName().equals(name)) {
                    System.out.println("В магаине " + ed.getName() + " есть издание " + e.getName());
                }
            }
            return sh;
        }
        else {
            throw new NullPointerException("Null pointer");
        }
    }

}