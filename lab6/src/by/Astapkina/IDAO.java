package by.Astapkina;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDAO {
    public Connection getConnection() throws SQLException;
    public void closeConnection() throws SQLException;
    public IGenDAO<Manufacturer, Integer> getManufDAO(Connection connection);
    public IGenDAO<Souvenir, Integer> getSouvDAO(Connection connection);
}
