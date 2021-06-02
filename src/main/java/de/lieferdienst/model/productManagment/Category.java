package de.lieferdienst.model.productManagment;


import de.lieferdienst.model.helper.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity(name = "Category")
@Getter
@Setter
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


}
/////////////////////////////////////End of class Restaurant/////////////////////////////////
