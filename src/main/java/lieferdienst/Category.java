package lieferdienst;


import java.util.concurrent.atomic.AtomicInteger;
//private : no access from outside possible
// public  : Provision of dedicated access methods for reading and writing
//////////////////////////////////Start Class Category/////////////////////////
public class Category {
    static final AtomicInteger sort_Id = new AtomicInteger(1);
    private int sortId;
    private String sortTitle;
    private Restaurant restaurant;
    ///////////////////////////Constructor//////////////////////////
    public Category(String sortTitle,String restaurantName)
    {
        this.sortTitle = sortTitle;
        restaurant = new Restaurant(restaurantName);
        this.sortId = sort_Id.getAndIncrement();
    }
    //////////////////////////////////Getter And Setter////////////////////////////
    public int getSortId()                          // Methode getSortTitle return the CategoryId
    {
        return sortId;
    }
    public String getSortTitle()                    // Methode getSortTitle return the Title of Category
    {
        return sortTitle;
    }
    public void setSortTitle(String sortTitle)      // This Methode used to change the Title of Category
    {
        this.sortTitle = sortTitle;
    }
    public String getRestaurant()                   // Methode getRestaurant return the Name of Restaurant
    {
        return restaurant.getRestaurantName();
    }
}
/////////////////////////////////////End of class Restaurant/////////////////////////////////
