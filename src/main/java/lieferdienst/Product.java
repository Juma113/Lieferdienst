package lieferdienst;
import java.util.concurrent.atomic.AtomicInteger;
// Private : no access from outside possible
// public  : Provision of dedicated access methods for reading and writing
//////////////////////////////////Start Class Product/////////////////////////
public class Product {
    static final AtomicInteger product_Id = new AtomicInteger(1);
    private int productId;
    private String productName;
    private String ProductDescription;
    private double ProductPrice;
    private Category category;
    ///////////////////////////Constructor//////////////////////////
    public Product(String productName,String productDescription,double productPrice,String sortTitle,String restaurantName)
    {
        this.productId = product_Id.getAndIncrement();
        this.productName = productName;
        this.ProductDescription = productDescription;
        this.ProductPrice = productPrice;
        category = new Category(sortTitle,restaurantName);
    }
    //////////////////////////////////Getter And Setter////////////////////////////
    public int getProductId()                         // Methode getProductId return the productId
    {
        return productId;
    }
    public String getProductName()                    // Methode getProductName return the Name of Product
    {
        return productName;
    }
    public void setProductName(String productName)   // This Methode used to change the Name of Product
    {
        this.productName = productName;
    }
    public String getProductDescription()            // Methode getProductDescription return the Description of Product
    {
        return ProductDescription;
    }
    public void setProductDescription(String productDescription) // This Methode used to change the Description of Product
    {
        ProductDescription = productDescription;
    }
    public double getProductPrice()                 // Methode getProductPrice return the Price of Product
    {
        return ProductPrice;
    }
    public void setProductPrice(double productPrice) // This Methode used to change the Price of Product
    {
        ProductPrice = productPrice;
    }
    public String viewProduct()                       // Methode to show the Product's Details
    {
        String result;
        result = "ProductName: "+getProductName()+"\n"+"productDescription: "+getProductDescription()
               +"\n"+"ProductPrice: "+getProductPrice()+"\n"+"categoryTitle: "+category.getSortTitle()
               +"\n"+"RestaurantName: "+category.getRestaurant();
         return result;
    }
}
/////////////////////////////////////End of class Product/////////////////////////////////
