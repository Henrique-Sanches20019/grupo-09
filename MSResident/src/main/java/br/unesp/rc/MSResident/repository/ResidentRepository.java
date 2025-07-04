package br.unesp.rc.MSResident.repository;

import br.unesp.rc.MSResident.entity.Access;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResidentRepository extends JpaRepository<Access, Long> {
    /**
     * Finds an Access entity by its user field.
     * @param user The username.
     * @return An Optional containing the Access entity if found.
     */
    Optional<Access> findByUser(String user);
}
