package de.lieferdienst.model.productManagment;


import de.lieferdienst.model.helper.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity(name = "Category")
@NoArgsConstructor
@AllArgsConstructor
//////////////////////////////////Start Class Category/////////////////////////
public class Category extends BaseEntity {

    private String sortTitle;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Restaurant restaurant;
    ///////////////////////////Constructor//////////////////////////
    public Category(String sortTitle,String restaurantName)
    {
        this.sortTitle = sortTitle;
        restaurant = new Restaurant(restaurantName);
    }

    public String getSortTitle() {
        return sortTitle;
    }

    public void setSortTitle(String sortTitle) {
        this.sortTitle = sortTitle;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
/////////////////////////////////////End of class Category/////////////////////////////////
