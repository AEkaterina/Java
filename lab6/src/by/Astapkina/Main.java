package by.Astapkina;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.sql.Connection;             //подключение к бд
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Main {

    static {
        new DOMConfigurator().doConfigure("log/log4j.xml",
                LogManager.getLoggerRepository());
    }
    private static final Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args) throws SQLException {

        DAO dao = new DAO();
        List<Manufacturer> manufacturerList;
        List<Souvenir> souvenirList;

        Connection cnn = dao.getConnection();
        System.out.println("All Manufacturers: ");
        LOG.info("All Manufacturers: " + "\n");
        IGenDAO<Manufacturer, Integer> mDAO = dao.getManufDAO(cnn);
        manufacturerList = mDAO.getAll();
        System.out.println(manufacturerList);
        LOG.info(manufacturerList + "\n");

        LOG.info("Производителях, чьи цены на сувениры меньше 35$");
        System.out.println("Производителях, чьи цены на сувениры меньше 35$");
        manufacturerList = ((DAO_Manuf) (mDAO)).infoAbSmallPriceOfSouv();
        System.out.println(manufacturerList);
        LOG.info(manufacturerList);

        LOG.info("Производители сувенира pen, произведенного в 2020 году.");
        System.out.println("Производители сувенира pen, произведенного в 2020 году.");
        manufacturerList = ((DAO_Manuf)(mDAO)).infoAbSoufAndYear();
        System.out.println(manufacturerList);
        LOG.info(manufacturerList);

        System.out.println("All souvenirs: ");
        LOG.info("All souvenirs" + "\n");
        IGenDAO<Souvenir, Integer> sDAO = dao.getSouvDAO(cnn);
        souvenirList = sDAO.getAll();
        System.out.println(souvenirList);
        LOG.info(souvenirList);

        LOG.info("Информация о сувенирах производителя FruitOfTheLoom");
        System.out.println("Информация о сувенирах производителя FruitOfTheLoom");
        souvenirList = ((DAO_Souv)(sDAO)).SouvOfAManuf();
        System.out.println(souvenirList);
        LOG.info(souvenirList);

        LOG.info("Информация о сувенирах, произведенных во Франции");
        System.out.println("Информация о сувенирах, произведенных во Франции");
        souvenirList = ((DAO_Souv)(sDAO)).SouvOfACountry();
        System.out.println(souvenirList);
        LOG.info(souvenirList);

        dao.closeConnection();
    }
}
