package gr.athtech.athtecheshop.resource;

import gr.athtech.athtecheshop.dao.ProductDao;
import gr.athtech.athtecheshop.model.Product;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/product/")
public class ProductResource {

    private  ProductDao productDao = new ProductDao();

    @GET
    @Path("/ping")
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON )
    @Consumes(MediaType.APPLICATION_JSON )
    public List<Product> getAllProduct() {
        return productDao.findAllProducts();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON )
    @Consumes(MediaType.APPLICATION_JSON )
    public Product getProductById(@PathParam("id") int id) {
        return productDao.findProductById(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON )
    @Consumes(MediaType.APPLICATION_JSON )
    public Product createProduct(Product product) {
        productDao.save(product);
        return product;
    }

    @PUT
    //   @Path("/")
    @Produces(MediaType.APPLICATION_JSON )
    @Consumes(MediaType.APPLICATION_JSON )
    public boolean changeProductPrice(Product product) {
        int id = product.getId();
        int newPrice = product.getPrice();
        return  productDao.changeProductPrice(id, newPrice);
    }

    @DELETE
    @Path("/{productId}")
    @Produces(MediaType.APPLICATION_JSON )
    @Consumes(MediaType.APPLICATION_JSON )
    public boolean deleteProduct(@PathParam("productId") int productId) {
        return  productDao.removeProductById(productId);
    }
}