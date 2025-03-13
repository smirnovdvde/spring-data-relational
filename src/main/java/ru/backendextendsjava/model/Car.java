package ru.backendextendsjava.model;

import lombok.Builder;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Set;
import java.util.UUID;

@Builder
@Setter
@Table("car")
public class Car {
    @Id
    private UUID id;
    //model is not part of our aggregate
    //model will be retrieved in separate request if required
    @Column("model_id")
    private UUID model;
    //see comment to model
    @Column("mark_id")
    private UUID mark;
    @Column("plate_number")
    private String plateNumber;
    //in spring jdbc there is no
    //many-to-one annotations
    @Column("owner_id")
    private UUID owner;

    //in jpa one-to-many
    //in spring data jdbc mapped-collection
    @MappedCollection(idColumn = "car_id")
    private Set<Repairing> repairingSet;
}
