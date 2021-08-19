package de.lieferdienst.model.orderManagment;

import de.lieferdienst.model.helper.BaseEntity;
import de.lieferdienst.model.productManagment.Product;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


//////////////////////////////////Start Class ShoppingCart/////////////////////////
/**
 * Class which represents a Shoppingcart
 * @author Lieferdienst Team
 */
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

    /**
     * Calculates the sum of prices in items and sets it as total.
     * Default = 0.0
     * @author Lieferdienst Team
     */
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
    /**
     * Adds given product to ShoppingCart-List items.
     * @param product Product which shall be added to this Shoppingcart
     * @return True if successful, false if watch not found or invalid.
     * @author Lieferdienst Team
     */
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
    /**
     * Removes given product from ShoppingCart-List items.
     * @param product Product which shall be removed
     * @return true if successful, false if watch not found.
     * @author Lieferdienst Team
     */
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
    /**
     * Removes all Watches from Shoppingcart-List and sets total as 0.0
     * @author Lieferdienst Team
     */
    public void clear()
    {
        items.clear();
        this.totalPrice = 0.0;
        logger.info("Cleared Shoppingcart.");
    }
}
/////////////////////////////////////End of class ShoppingCart/////////////////////////////////

