package lieferdienst;


import java.util.concurrent.atomic.AtomicInteger;
// Private : no access from outside possible
// public  : Provision of dedicated access methods for reading and writing
//////////////////////////////////Start Class Restaurant/////////////////////////
public class Restaurant {
    static final AtomicInteger restaurant_Id = new AtomicInteger(1);
    private int restaurantId;
    private String restaurantName;
    ///////////////////////////Constructor//////////////////////////
    public Restaurant(String restaurantName)
    {
        this.restaurantName = restaurantName;
        this.restaurantId = restaurant_Id.getAndIncrement();
    }
    //////////////////////////////////Getter And Setter////////////////////////////
    public int getRestaurantID()                          // Methode getRestaurantId return the RestaurantId
    {
        return restaurantId;
    }
    public String getRestaurantName()                     // Methode getRestaurantName return the Name of Restaurant
    {
        return restaurantName;
    }
    public void setRestaurantName(String restaurantName)  // This Methode used to change the restaurantName
    {
        this.restaurantName = restaurantName;
    }
}
/////////////////////////////////////End of class Restaurant/////////////////////////////////
