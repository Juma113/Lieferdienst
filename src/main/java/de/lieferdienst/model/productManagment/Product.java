package de.lieferdienst.model.productManagment;

import de.lieferdienst.model.helper.BaseEntity;
import lombok.NoArgsConstructor;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;
import java.util.logging.Logger;

@Entity(name = "Product")
@NoArgsConstructor
//////////////////////////////////Start Class Product/////////////////////////
public class Product  extends BaseEntity {

    private final transient Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @Column(
            nullable = false
    )
    private String productName;

    @Column(
            columnDefinition = "TEXT",
            nullable = false
    )
    @Size(max = 1000, message = "Description must be shorter than 1000 characters.")
    private String Description;

    @Column(
            nullable = false
    )
    private double price;

    @Column(
            nullable = false
    )
    private String imagPath;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Category category;
    ///////////////////////////Constructor//////////////////////////

    public Product(String productName, String description, double price,String imagPath, Category category) {
        this.productName = productName;
        Description = description;
        this.price = price;
        this.imagPath = imagPath;
        this.category = category;
    }

    public double returnPriceWithFee() {
        if (this.price < 20.00) {
            return this.price + this.price * 0.1;
        } else {
            return this.price + 2.00;
        }
    }

    public double returnPriceWithoutFee() {
        return this.price;
    }



    //////////////////////////////////Getter And Setter////////////////////////////


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            logger.warning("price should not be lower/equal 0");
        }
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getImagPath() {
        return imagPath;
    }

    public void setImagPath(String imagPath) {
        this.imagPath = imagPath;
    }
}
/////////////////////////////////////End of class Product/////////////////////////////////
