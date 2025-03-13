package ru.backendextendsjava.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.backendextendsjava.model.Owner;

import java.util.Collection;
import java.util.UUID;

public interface OwnerRepository extends Repository<Owner, UUID> {
    /**
     * Retrieve {@link Owner}s from the data store by last name, returning all owners whose name <i>starts</i> with
     * the given name.
     *
     * @param lastName Value to search for
     * @return a Collection of matching {@link Owner}s (or an empty Collection if none found)
     */
    @Query("SELECT * FROM owner WHERE name LIKE concat(:lastName,'%')")
    @Transactional(readOnly = true)
    Collection<Owner> findByLastName(@Param("lastName") String lastName);

    /**
     * Retrieve an {@link Owner} from the data store by id.
     *
     * @param id the id to search for
     * @return the {@link Owner} if found
     */
    @Transactional(readOnly = true)
    Owner findById(@Param("id") UUID id);

    /**
     * Save an {@link Owner} to the data store, either inserting or updating it.
     *
     * @param owner the {@link Owner} to save
     */
    void save(Owner owner);
}
