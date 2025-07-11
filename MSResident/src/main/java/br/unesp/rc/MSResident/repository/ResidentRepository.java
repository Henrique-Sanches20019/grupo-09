package br.unesp.rc.MSResident.repository;

import br.unesp.rc.MSResident.entity.Resident;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResidentRepository extends JpaRepository<Resident, Long> {

}
