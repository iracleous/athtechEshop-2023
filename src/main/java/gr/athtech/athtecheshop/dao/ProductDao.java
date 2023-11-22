package gr.athtech.athtecheshop.dao;

import gr.athtech.athtecheshop.model.Product;

import java.sql.*;

public class ProductDao {

    private    static final String DB_URL = "jdbc:sqlserver://localhost;databaseName=athtecheshop;encrypt=true;trustServerCertificate=true;";
    private  static final String USER = "sa";
    private  static final String PASS = "passw0rd";
     private static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";



    public void save(Product product) {

        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String sqlCommand = "insert into Product (  name, price) values(?,?);";

        // Open a connection
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement stmt = conn.prepareStatement(sqlCommand,
                    Statement.RETURN_GENERATED_KEYS );
        ) {

            stmt.setString(1,product.getName());
            stmt.setInt(2,product.getPrice());
            stmt.execute();
            ResultSet results = stmt.getGeneratedKeys();
            results.next(); // Assume just one auto-generated key; otherwise, use a while loop here
            int index = results.getInt(1);
            product.setId(index);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
