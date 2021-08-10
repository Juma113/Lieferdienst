package de.lieferdienst.model.orderManagment;

import de.lieferdienst.model.helper.BaseEntity;
import de.lieferdienst.model.productManagment.Product;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


//////////////////////////////////Start Class ShoppingCart/////////////////////////
@Entity
public class ShoppingCart extends BaseEntity {

    private final transient Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private double totalPrice;

    @ManyToMany
    private List<Product> items = new ArrayList<>();

    /*
         Creates an empty Shoppingcart object with total = 0.0
    */
    public ShoppingCart()
    {
        calcTotalPrice();
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public List<Product> getItems() {
        return items;
    }

    public void setItems(List<Product> items) {
        this.items = items;
    }

    public void calcTotalPrice()
    {
        double result = 0.0;
        if (!this.items.isEmpty())
        {
            for (Product temp : this.items)
            {
                result += temp.returnPriceWithoutFee();
            }
        }
        this.totalPrice = result;
    }

    public boolean addProduct(Product product)
    {
        boolean result = false;
        if (product != null )
        {
            items.add(product);
            this.totalPrice+=product.returnPriceWithoutFee();
            result = true;
            logger.info("Added Product to Shoppingcart.");
        }
        else
        {
            logger.warning("Product not found or invalid.");
        }
        return result;
    }

    public boolean deleteProduct(Product product)
    {
        boolean result = false;
        if (product != null)
        {
            items.remove(product);
            this.totalPrice -= product.returnPriceWithoutFee();
            result = true;
            logger.info("deleted Product from Shoppingcart.");
        }
        else
        {
            logger.warning("Product not found.");
        }
        return result;
    }

    public int removeAllOccurrencesOfProduct(Product product)
    {
        int result = 0;
        if (product != null)
        {
            while(items.contains(product))
            {
                items.remove(product);
                this.totalPrice -= product.returnPriceWithoutFee();
                result +=1;
            }
            logger.info(result + " Occurance(s) of Product was/were removed from Shoppingcart.");
        }
        else
        {
            logger.warning("Product not found.");
        }
        return result;
    }

    public void clear()
    {
        items.clear();
        this.totalPrice = 0.0;
        logger.info("Cleared Shoppingcart.");
    }
}
/////////////////////////////////////End of class ShoppingCart/////////////////////////////////

