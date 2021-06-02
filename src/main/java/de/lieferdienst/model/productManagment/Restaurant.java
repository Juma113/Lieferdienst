package de.lieferdienst.model.productManagment;

import de.lieferdienst.model.helper.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity(name = "Restaurant")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//////////////////////////////////Start Class Restaurant/////////////////////////
public class Restaurant extends BaseEntity {

    private String restaurantName;

}
/////////////////////////////////////End of class Restaurant/////////////////////////////////
