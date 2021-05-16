package de.lieferdienst.domains.specialties;

import de.lieferdienst.domains.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//////////////////////////////////Start Class Restaurant/////////////////////////
public class Restaurant extends BaseEntity {

    private String restaurantName;

}
/////////////////////////////////////End of class Restaurant/////////////////////////////////
