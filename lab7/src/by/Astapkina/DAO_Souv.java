package by.Astapkina;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO_Souv implements IGenDAO<Souvenir, Integer> {
    public final Connection connection;

    public DAO_Souv(Connection connection) {
        this.connection = connection;
    }

    public void ResultListSouv (ResultSet rs, List<Souvenir> list) throws SQLException {
        while (rs.next()) {
            Souvenir souvenir = new Souvenir();
            souvenir.id = rs.getInt("id");
            souvenir.name = rs.getString("name");
            souvenir.requisites = rs.getInt("requisites");
            souvenir.date = rs.getInt("date");
            souvenir.price = rs.getInt("price");
            list.add(souvenir);
        }
    }

    @Override
    public List<Souvenir> getAll() throws SQLException {
        String sql = "select * from souvenir";
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        List<Souvenir> list = new ArrayList<Souvenir>();
        ResultListSouv(rs, list);
        return list;
    }

    public List<Souvenir> SouvOfAManuf() throws SQLException {
        String sql = "select souvenir.id, souvenir.name, souvenir.price, souvenir.requisites, souvenir.date, manufacturer.country\n" +
                "from manufacturer inner join souvenir\n" +
                "on manufacturer.requisites = souvenir.requisites\n" +
                "where manufacturer.name = 'FruitOfTheLoom';";
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        List<Souvenir> list = new ArrayList<Souvenir>();
        ResultListSouv(rs, list);
        return list;
    }

    public List<Souvenir> SouvOfACountry() throws SQLException {
        String sql = "select souvenir.id, souvenir.name, souvenir.price, souvenir.requisites, souvenir.date, manufacturer.name\n" +
                "from manufacturer inner join souvenir\n" +
                "on manufacturer.requisites = souvenir.requisites\n" +
                "where manufacturer.country = 'France';";
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        List<Souvenir> list = new ArrayList<Souvenir>();
        ResultListSouv(rs, list);
        return list;
    }
}
