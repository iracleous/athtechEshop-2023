package gr.athtech.athtecheshop.resource;

import gr.athtech.athtecheshop.dao.ProductDao;
import gr.athtech.athtecheshop.model.Product;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/product")
public class HelloResource {
    @GET
    @Path("/hello")
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }


    @GET
    @Path("/hello2")
    @Produces("text/plain")
    public String hello2() {
        return "Hello, World! Aggain";
    }



    @GET
    @Path("/product/{id}")
    @Produces(MediaType.APPLICATION_JSON )
    @Consumes(MediaType.APPLICATION_JSON )
    public Product getProductById(@PathParam("id") int id) {
        Product product = new Product();
        product.setName("Chips");
        product.setId(id);
        return product;
    }

    @POST
    @Path("/product")
    @Produces(MediaType.APPLICATION_JSON )
    @Consumes(MediaType.APPLICATION_JSON )
    public Product createProduct(Product product) {

        ProductDao productDao = new ProductDao();
        productDao.save(product);
        return product;
    }


}