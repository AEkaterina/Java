package by.Astapkina.bookshop.main;
import by.Astapkina.bookshop.book.Book;
import by.Astapkina.bookshop.book.BookType;
import by.Astapkina.bookshop.comics.ComType;
import by.Astapkina.bookshop.comics.Comics;
import by.Astapkina.bookshop.edition.Edition;
import by.Astapkina.bookshop.greetingCard.GreetingCard;
import by.Astapkina.bookshop.greetingCard.Size;
import by.Astapkina.bookshop.magazine.Magazine;
import by.Astapkina.bookshop.seller.Seller;
import by.Astapkina.bookshop.shop.Shop;
import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;
import org.apache.log4j.xml.DOMConfigurator;
import by.Astapkina.bookshop.lab4.SAX;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    static {
        new DOMConfigurator().doConfigure("log/log4j.xml", LogManager.getLoggerRepository());
    }

    private static final Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            /*LOG.info("Starting program_______________________");
            Seller seller = new Seller();
            Shop shop1 = new Shop("Мысль");
            LOG.info("Book's list");
*/
            Book masterAndmargarita = new Book("Мmihail bulgakov", "Master and Margarita", 2015, 20, 504, "Poligraph", BookType.NOVEL);
            Comics attackOntitan = new Comics("Hajime Isayama", "Attack on titan", 2009, 25, 6394, ComType.MANGA);
            GreetingCard birthday = new GreetingCard("Открытка: ", "\"Happy birthday\"", 2020, 1, 2, Size.A5);
            Magazine cosmopolitan = new Magazine("Burda", "Cosmopoliten", 2019, 57, 5);

   /*         shop1.AddBook(masterAndmargarita);
            shop1.AddBook(attackOntitan);
            shop1.AddBook(birthday);
            shop1.AddBook(cosmopolitan);

            System.out.println("\nList of books in shop " + shop1.getName());
            for (Edition ed : shop1.getBook()) {
                System.out.println(ed.toString());
            }
            LOG.info("Sorting by year: ");
            System.out.println("\nSort shop: ");
            seller.sort(shop1);
            for (Edition ed : shop1.getBook()) {
                System.out.println(ed.toString());
            }

            LOG.info("New books");
            Comics spiderMan = new Comics("Stan Lee", "Spider-man", 2001, 237, 21, ComType.TRADITIONAL);
            Book portrait = new Book("Oscar Wilde", "Portrait of Dorian Gray", 2013, 320, 23, "PublishHouse", BookType.NOVEL);

            System.out.print("\n");
            shop1.AddBook(spiderMan);
            shop1.AddBook(portrait);
            System.out.println("\nNew list of books in shop " + shop1.getName());
            for (Edition ed : shop1.getBook()) {
                System.out.println(ed.toString());
            }

            LOG.info("Sell the book");
            System.out.print("\n");
            shop1.SellBook(attackOntitan);

            LOG.info("Find the book");
            System.out.print("\n");
            for (Edition ed : seller.find(shop1, "Spider-man").getBook()) {
                System.out.println(ed.toString());
            }

*/
            //parsing XML
            ArrayList<Edition> e = new ArrayList<Edition>();
            e.add(masterAndmargarita);
            e.add(attackOntitan);
            e.add(birthday);
            e.add(cosmopolitan);
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            SAX saxp = new SAX();
            parser.parse(new File("files/book.xml"), saxp);
            Book book = saxp.getResult();
            System.out.println(book.author);
            System.out.println(book.name);
            System.out.println(book.year);
            System.out.println(book.cost);
            System.out.println(book.num_of_pages);

            //сериализация XML
            System.out.println("--------------Сериализация XML------------------");
            FileOutputStream out = new FileOutputStream("files/Serialize.xml");
            XMLEncoder xmlEncoder = new XMLEncoder(out);
            xmlEncoder.writeObject(book);
            xmlEncoder.close();

            //десериализация XML
            System.out.println("--------------Десериализация XML------------------");
            FileInputStream in = new FileInputStream("files/Serialize.xml");
            XMLDecoder xmlDecoder = new XMLDecoder(in);
            Book book2 = (Book) xmlDecoder.readObject();
            xmlDecoder.close();
            System.out.println(book2.author);
            System.out.println(book2.name);
            System.out.println(book2.year);
            System.out.println(book2.cost);
            System.out.println(book2.num_of_pages);

            //сериализация JSON
            System.out.println("-----------------Сериализация JSON---------------");
            Gson gson = new GsonBuilder().create();
            String json = gson.toJson(book);
            System.out.println(json);
            FileOutputStream jsonOut = new FileOutputStream("files/Serialize.json");
            byte[] outText = json.getBytes(StandardCharsets.UTF_8);
            jsonOut.write(outText, 0, outText.length);

            //десериализация Json
            System.out.println("--------------Десериализация JSON---------------");
            Scanner scanner = new Scanner(new File("files/Serialize.json"));
            String res = "";
            while(scanner.hasNext())
                res += scanner.nextLine();
            scanner.close();
            Book b3 = gson.fromJson(res, Book.class);
            System.out.println(b3.author);
            System.out.println(b3.name);
            System.out.println(b3.year);
            System.out.println(b3.num_of_pages);
            System.out.println(b3.cost);

            //Stream API
            System.out.println("-------------------Stream API-------------");
            Stream<Edition> res_stream = e.stream().filter(w -> w.getCost() > 10);
            for(var x: res_stream.collect(Collectors.toList()))
            {
                System.out.println(x.name + " " + x.cost);
            }
            System.out.println("----------------------------------");
            Stream<Edition> res_stream2 = e.stream().limit(2);
            for(var x: res_stream2.collect(Collectors.toList()))
            {
                System.out.println(x.name + " " + x.cost);
            }

        } catch (NullPointerException e) {
          System.out.println(e.getMessage());
        }
        catch (Exception e) {
            LOG.info(e.getMessage());
        }
        finally {
            System.out.println("proc finally");
        }

    }
}
