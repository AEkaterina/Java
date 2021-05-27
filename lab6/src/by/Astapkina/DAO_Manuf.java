package by.Astapkina;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO_Manuf implements IGenDAO<Manufacturer, Integer> {
    private final Connection connection;

    public DAO_Manuf(Connection connection) {
        this.connection = connection;
    }

    public void ResultSetListManuf (ResultSet rs, List<Manufacturer> list) throws SQLException {
        while (rs.next()) {
            Manufacturer manufacturer = new Manufacturer();
            manufacturer.name = rs.getString("name");
            manufacturer.requisites = rs.getInt("requisites");
            manufacturer.country = rs.getString("country");
            list.add(manufacturer);
        }
    }

    @Override
    public List<Manufacturer> getAll() throws SQLException {
        String sql = "select * from manufacturer;";
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        List<Manufacturer> list = new ArrayList<Manufacturer>();
        ResultSetListManuf(rs, list);
        return list;
    }

    public List<Manufacturer> infoAbSmallPriceOfSouv() throws SQLException {
        String sql = "select manufacturer.name, manufacturer.requisites, manufacturer.country, souvenir.name, souvenir.price \n" +
                "from manufacturer inner join souvenir\n" +
                "on manufacturer.requisites = souvenir.requisites\n" +
                "where souvenir.price < 35;";
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        List<Manufacturer> list = new ArrayList<Manufacturer>();
        ResultSetListManuf(rs, list);
        return list;
    }

    public List<Manufacturer> infoAbSoufAndYear() throws SQLException {
        String sql = "select manufacturer.name, manufacturer.requisites, manufacturer.country\n" +
                "from manufacturer inner join souvenir\n" +
                "on manufacturer.requisites = souvenir.requisites\n" +
                "where souvenir.date = 2020 and souvenir.name = 'pen';";
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        List<Manufacturer> list = new ArrayList<Manufacturer>();
        ResultSetListManuf(rs, list);
        return list;
    }
}
