package ru.backendextendsjava.configuration;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.relational.core.mapping.event.BeforeConvertEvent;
import ru.backendextendsjava.model.Car;
import ru.backendextendsjava.model.Owner;
import ru.backendextendsjava.model.Repairing;

import java.util.UUID;

@Configuration
public class SettingIDConfiguration {
    @Bean
    public ApplicationListener<?> idSetting() {
        return (ApplicationListener<BeforeConvertEvent>) event -> {
            //setting id for owner
            if (event.getEntity() instanceof Owner owner) {
                owner.setId(UUID.randomUUID());
            }
            //setting id for car
            if (event.getEntity() instanceof Car car) {
                car.setId(UUID.randomUUID());
            }
            //setting id for repairing
            if (event.getEntity() instanceof Repairing repairing) {
                repairing.setId(UUID.randomUUID());
            }
        };
    }
}
