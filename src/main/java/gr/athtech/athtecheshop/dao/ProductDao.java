package gr.athtech.athtecheshop.dao;

import gr.athtech.athtecheshop.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements ProductDaoInterface{

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
        try( Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
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

    @Override
    public Product findProductById(int productId) {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String sqlCommand = "select * from Product where id = ?;";
        // Open a connection
        try( Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement(sqlCommand );
        ) {
            stmt.setInt(1, productId);
            ResultSet results = stmt.executeQuery();
            results.next();
            Product product = new Product();
            product.setId(results.getInt("id"));
            product.setName(results.getString("name"));
            product.setPrice(results.getInt("price"));
            return product;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> findAllProducts() {
        List<Product> products = new ArrayList<>();
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String sqlCommand = "select * from Product ;";
        // Open a connection
        try( Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement(sqlCommand );
        ) {
            ResultSet results = stmt.executeQuery();
           while( results.next()) {
               Product product = new Product();
               product.setId(results.getInt("id"));
               product.setName(results.getString("name"));
               product.setPrice(results.getInt("price"));
               products.add(product);
           }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return products;
    }

    @Override
    public boolean changeProductPrice(int productId, int newPrice) {
        Product product = findProductById(productId);
        if (product==null) return false;

        return false;
    }

    @Override
    public boolean removeProductById(int productId) {
        return false;
    }


}
