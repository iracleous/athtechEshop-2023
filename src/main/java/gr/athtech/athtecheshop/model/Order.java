package gr.athtech.athtecheshop.model;


import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Setter@Getter
public class Order {

    private int orderId;
    private int customerId;
    private int productId;
    private int quantity;
    private Date date;
}
