package lieferdienst;
import java.util.concurrent.atomic.AtomicInteger;
import java.time.LocalDate;
import java.util.List;
// Private : no access from outside possible
// public  : Provision of dedicated access methods for reading and writing
//////////////////////////////////Start Class Orders/////////////////////////
public class Orders {
    static final AtomicInteger order_Id = new AtomicInteger(1);
    private int orderId;
    private LocalDate orderDate;
    private Customer customer;
    private List<LineItem> orderList;

    ///////////////////////////Constructor//////////////////////////
    public Orders(Customer customer, List<LineItem> orderList) {
        this.orderId = order_Id.getAndIncrement();
        this.orderDate = LocalDate.now();
        this.customer = customer;
        this.orderList = orderList;
    }

    //////////////////////////////////Getter And Setter////////////////////////////
    public LocalDate getOrderDate()         // Methode getOrderDate returns the Date of order
    {
        return orderDate;
    }

    public int getOrderId()                 // Methode getOrderId returns the Id of order
    {
        return orderId;
    }

    public String getCustomer()               // Methode to show the customer's Details
    {
        return this.customer.viewUser();
    }

    /*public void getOrderList(List<LineItem> orderList) // Methode to make list of orderProducts
    {
        double Sum=0.0;
        for (LineItem item: orderList)
        {
            item.viewLineItemProduct();
            Sum = Sum + item.getQuantityPrice();
        }
        System.out.println("TotalPreis: " + Sum + " €" );
    }
     */
    public List<LineItem> getOrderList() {
        return orderList;
    }
    // Methode to change the ordered Products
    public void setOrderList(List<LineItem> orderList)
    {
        this.orderList = orderList;
    }
}
/////////////////////////////////////End of class Orders/////////////////////////////////

