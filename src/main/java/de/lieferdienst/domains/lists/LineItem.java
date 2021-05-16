package de.lieferdienst.domains.lists;
import de.lieferdienst.domains.BaseEntity;
import de.lieferdienst.domains.specialties.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//////////////////////////////////Start Class LineItem/////////////////////////
public class LineItem extends BaseEntity {
    @OneToOne(cascade = CascadeType.PERSIST)
    private Product product;

    private int quantity;
    private double quantityPrice;

    @OneToOne(cascade = CascadeType.PERSIST)
     LineItem nextElement;
    ///////////////////////////Constructor//////////////////////////
    public LineItem (String productName,String productDescription,double productPrice,String sortTitle,String restaurantName, int quantity)
    {
        product = new Product(productName,productDescription,productPrice,sortTitle,restaurantName);
        this.quantity =quantity ;
        this.quantityPrice = (this.quantity * productPrice );
        nextElement = null;
    }
    //////////////////////////////////Getter And Setter////////////////////////////

    /*
    public LineItem getNextElement()                    // Methode getNextElement return the Element in the shoppingCart
    {
        return nextElement;
    }
    public void setNextElement(LineItem nextElement)    // This Methode used to change the Element in the shoppingCart
    {
        this.nextElement = nextElement;
    }
    public int getQuantity()                            // Methode getQuantity return the quantity of Product
    {
        return quantity;
    }
    public void setQuantity(int quantity)               // This Methode used to change the quantity of Product
    {
        this.quantity = quantity;
    }
    public double getQuantityPrice()                    // Methode getQuantityPrice return the QuantityPrice of Product
    {
        return quantityPrice;
    }
     */
    public String getProduct()                            // Methode to show the Product's Details
    {
        return this.product.viewProduct();
    }
    public String getProductName()                      // Methode getProductName return the Name of Product
    {
        return product.getProductName();
    }
    public String viewLineItemProduct()                   // Methode to show the LineItem's Details
    {
        String result;
        result = this.getProduct()+"\n"+"Quantity: "+ this.getQuantity()+"\n"+
                "Price: "+this.getQuantityPrice()+" €";
        return result;
    }
}
/////////////////////////////////////End of class LineItem/////////////////////////////////
