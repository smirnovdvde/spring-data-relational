package ru.backendextendsjava;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.support.TransactionTemplate;
import ru.backendextendsjava.model.Car;
import ru.backendextendsjava.model.Owner;
import ru.backendextendsjava.model.Repairing;
import ru.backendextendsjava.repository.OwnerRepository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringDataRelationalApplication.class)
@ContextConfiguration(initializers = {ShowCaseCommon.Initializer.class})
@DirtiesContext
public class OwnerRepositoryTest extends ShowCaseCommon {

    private static final String JOHN_SMITH_OWNER_ID = "0df29411-adef-4dca-9297-2d83c5c73321";

    @Autowired
    private OwnerRepository ownerRepository;
    @Autowired
    private TransactionTemplate transactionTemplate;

    @Test
    public void retrieveExistedOwnerById() {
        Owner owner = ownerRepository.findById(UUID.fromString(JOHN_SMITH_OWNER_ID));
        Assert.assertNotNull(owner);
    }

    @Test
    public void saveAndRetrieveOwnerByName() {
        Set<Repairing> repairingSet = Set.of(buildRepairing());
        Set<Car> cars = Set.of(buildCar(repairingSet));
        Owner owner = buildOwner(cars);
        transactionTemplate.execute(status -> {
            ownerRepository.save(owner);
            return true;
        });
        transactionTemplate.execute(status -> {
            Collection<Owner> retrievedOwners = ownerRepository.findByLastName("Ivan");
            Assert.assertEquals(1, retrievedOwners.size());
            return true;
        });
    }

    private Repairing buildRepairing() {
        return Repairing.builder()
                .carServiceName("New Car Service in the neighbourhood")
                .carServiceAddress("Berlin Stalina str 7")
                .visitDateTime(LocalDateTime.now())
                .build();
    }

    private Car buildCar(Set<Repairing> repairingSet) {
        return Car.builder()
                .mark(UUID.randomUUID())
                .model(UUID.randomUUID())
                .plateNumber("PLATE")
                .repairingSet(repairingSet)
                .build();
    }

    private Owner buildOwner(Set<Car> cars) {
        return Owner.builder()
                .name("Ivan Ivanov")
                .city("Belgrad")
                .address("Belgrad Novaya str 5")
                .telephone("12345678")
                .cars(cars)
                .build();
    }
}
