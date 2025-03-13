package ru.backendextendsjava.model;

import lombok.Builder;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Setter
@Table("repairing")
public class Repairing {
    @Id
    private UUID id;
    @Column("car_service_name")
    private String carServiceName;
    @Column("car_service_address")
    private String carServiceAddress;
    @DateTimeFormat(pattern = "yyyy-MM-dd hh-mm")
    private LocalDateTime visitDateTime;
}
