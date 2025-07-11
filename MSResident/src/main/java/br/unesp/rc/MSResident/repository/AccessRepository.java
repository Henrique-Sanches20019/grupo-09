package br.unesp.rc.MSResident.repository;

import br.unesp.rc.MSResident.entity.Access;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AccessRepository extends JpaRepository<Access, Long> {
    // This is the correct location for this method
    Optional<Access> findByUser(String user);
}
