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
//   @Path("/")
    @Produces(MediaType.APPLICATION_JSON )
    @Consumes(MediaType.APPLICATION_JSON )
    public List<Product> getAllProductById() {
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
 //   @Path("/")
    @Produces(MediaType.APPLICATION_JSON )
    @Consumes(MediaType.APPLICATION_JSON )
    public Product createProduct(Product product) {
        productDao.save(product);
        return product;
    }
}