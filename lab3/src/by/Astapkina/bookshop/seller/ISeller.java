package by.Astapkina.bookshop.seller;

import by.Astapkina.bookshop.shop.Shop;

public interface ISeller {
    void sort (Shop ed);
    Shop find (Shop ed, String name);
}
