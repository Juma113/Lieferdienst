package de.lieferdienst.model.helper;

import lombok.*;

import javax.persistence.*;
@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

}
