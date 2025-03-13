package ru.backendextendsjava.model;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Set;
import java.util.UUID;

@Setter
@Builder
@Table("owner")
public class Owner {
    @Id
    private UUID id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String address;
    @NotEmpty
    private String city;
    @NotEmpty
    @Digits(fraction = 0, integer = 10)
    private String telephone;
    @MappedCollection(idColumn = "owner_id")
    private Set<Car> cars;
}
