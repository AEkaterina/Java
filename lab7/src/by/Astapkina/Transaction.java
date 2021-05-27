package by.Astapkina;

import java.sql.*;

public class Transaction {

    //static final String JDBC_DRIVER = "net.sourceforge.jtds.jdbc.Driver()";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Connection connection = null;
        Statement statement = null;

        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_souvenir", "root", "K!eoP@tr@9822");
        connection.setAutoCommit(false);

        statement = connection.createStatement();

        String SQL;
        SQL = "select * from manufacturer";

        ResultSet resultSet = statement.executeQuery(SQL);

        while (resultSet.next()) {
            String manufacturer = resultSet.getString("name");
            String country = resultSet.getString("country");
            Integer requisites = resultSet.getInt("requisites");
            System.out.println("---------------------\n");
            System.out.println("Manufacturer: " + manufacturer);
            System.out.println("Country: " + country);
            System.out.println("Requisites: " + requisites);
        }

        System.out.println("\n---------------------\n");
        System.out.println("Creating savepoint...");
        Savepoint savepoint = connection.setSavepoint("savepoint");

        try {
            SQL = "insert into manufactorer values ('Chibico', 'Belarus', '51')";
            statement.executeUpdate(SQL);

            connection.commit();
        } catch (SQLException e) {
            System.out.println("SQLException. Executing rollback to savepoint...");
            connection.rollback(savepoint);
        }
        String SQL2;
        SQL2 = "select * from manufacturer";

        ResultSet resultSet2 = statement.executeQuery(SQL2);
        while (resultSet2.next()) {
            String manufacturer = resultSet2.getString("name");
            String country = resultSet2.getString("country");
            Integer requisites = resultSet2.getInt("requisites");
            System.out.println("----------------\n");
            System.out.println("manufacturer: " + manufacturer);
            System.out.println("country: " + country);
            System.out.println("requisites: " + requisites);
        }

    }
}
