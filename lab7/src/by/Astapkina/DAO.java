package by.Astapkina;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO implements IDAO {
        public static Connection cnn;
    @Override
    public Connection getConnection() throws SQLException {
        cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_souvenir", "root", "K!eoP@tr@9822");            //подключение к лок бд souvenir
        return cnn;
    }

    @Override
    public IGenDAO <Manufacturer, Integer> getManufDAO(Connection connection) {
        return new DAO_Manuf(connection);
    }

    @Override
    public IGenDAO<Souvenir, Integer> getSouvDAO(Connection connection) {
        return new DAO_Souv(connection);
    }

    @Override
    public void closeConnection() throws SQLException {
        cnn.close();
    }
}
