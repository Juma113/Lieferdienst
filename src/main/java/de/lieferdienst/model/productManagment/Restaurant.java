package de.lieferdienst.model.productManagment;

import de.lieferdienst.model.helper.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity(name = "Restaurant")
@NoArgsConstructor
@AllArgsConstructor
//////////////////////////////////Start Class Restaurant/////////////////////////
public class Restaurant extends BaseEntity {

    private String restaurantName;

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }
}
/////////////////////////////////////End of class Restaurant/////////////////////////////////
