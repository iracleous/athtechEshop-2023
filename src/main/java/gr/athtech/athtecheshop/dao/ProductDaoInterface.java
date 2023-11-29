package gr.athtech.athtecheshop.dao;

import gr.athtech.athtecheshop.model.Product;

import java.util.List;

public interface ProductDaoInterface {

     void save(Product product);
     Product findProductById(int productId);
     List<Product> findAllProducts();
     boolean changeProductPrice(int productId, int newPrice);
     boolean removeProductById(int productId);


}
