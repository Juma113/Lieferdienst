package de.lieferdienst.domains.specialties;


import de.lieferdienst.domains.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
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
