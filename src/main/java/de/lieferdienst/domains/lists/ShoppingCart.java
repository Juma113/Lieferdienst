package de.lieferdienst.domains.lists;

import de.lieferdienst.domains.BaseEntity;
import de.lieferdienst.domains.users.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
//////////////////////////////////Start Class ShoppingCart/////////////////////////
public class ShoppingCart extends BaseEntity {

    @OneToOne(cascade = CascadeType.PERSIST)
    private Customer customer;
    private double totalPrice;
    ///////////////////////////Constructor//////////////////////////
    public ShoppingCart()
    {
    }
    // Start default Product in the List
    @OneToOne(cascade = CascadeType.PERSIST)
    LineItem startProduct = new LineItem("","",0,"","",0);
    // Methode addNewProduct add Product in the List
    public void addNewProduct(String productName,String productDescription,double productPrice,String sortTitle,String restaurantName, int quantity)
    {
        LineItem newProduct = new LineItem(productName,productDescription,productPrice,sortTitle,restaurantName,quantity);
        LineItem lastProduct = getLastProduct();
        lastProduct.setNextElement(newProduct);
    }
    private LineItem getLastProduct()        //  get last Product in the List
    {
        LineItem lastElement = startProduct;
        while (lastElement.getNextElement() != null)
        {
            lastElement = lastElement.getNextElement();
        }
        return lastElement;
    }
    public void writeShoppingCart()         // This Methode show all Products, which are added as List
    {
        LineItem lastElement = startProduct.getNextElement();
        double Sum=0.0;
        while (lastElement != null )
        {
            System.out.println("------------------------------------------");
            System.out.println( lastElement.viewLineItemProduct());
            System.out.println("------------------------------------------");
            Sum = Sum + lastElement.getQuantityPrice();
            lastElement = lastElement.getNextElement();
        }
        this.totalPrice = Sum;
        System.out.println("TotalPreis: " + getTotalPrice() + " €" );
    }
    public void findProduct(String productName)          // With this Methode has the User the ability to search Product, which he wants
    {
        LineItem lastElement = startProduct.getNextElement();
        while (lastElement != null){                // check if the inputted ProductName is available
            if (lastElement.getProductName().equalsIgnoreCase(productName) || lastElement.getProductName().contains(productName))
            {
                System.out.println("Product is found: " );
                System.out.println(lastElement.viewLineItemProduct());
                break;
            }else{
                lastElement = lastElement.nextElement;
                System.out.println("Product: " + productName + " is not Found");
            }
        }

    }
    public void deleteProduct(String productName)      //// With this Methode has the User the ability to delete Product, which he wants
    {
        LineItem lastElement = startProduct;
        while (lastElement.getNextElement() != null && !lastElement.getProductName().equals(productName))
        {
            if (lastElement.getNextElement().getProductName().equals(productName))
            {
                if (lastElement.getNextElement().getNextElement() != null)
                {
                    lastElement.setNextElement(lastElement.getNextElement().getNextElement());
                }else
                {
                    lastElement.setNextElement(null);
                    break;
                }
            }
            lastElement = lastElement.getNextElement();
        }
    }
    private double getTotalPrice()               // Methode getTotalPrice return the TotalPrice of all Products
    {
        return totalPrice;
    }
}
/////////////////////////////////////End of class ShoppingCart/////////////////////////////////

