package de.lieferdienst.domains.lists;
import de.lieferdienst.domains.BaseEntity;
import de.lieferdienst.domains.users.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Orders extends BaseEntity {

    private LocalDate orderDate;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Customer customer;


    ///////////////////////////Constructor//////////////////////////
    public Orders(Customer customer) {
        this.orderDate = LocalDate.now();
        this.customer = customer;
    }

    //////////////////////////////////Getter And Setter////////////////////////////
    public LocalDate getOrderDate()         // Methode getOrderDate returns the Date of order
    {
        return orderDate;
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

    // Methode to change the ordered Products

}
/////////////////////////////////////End of class Orders/////////////////////////////////

