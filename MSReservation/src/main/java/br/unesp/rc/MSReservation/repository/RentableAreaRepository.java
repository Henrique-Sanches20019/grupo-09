package br.unesp.rc.MSReservation.repository;

import br.unesp.rc.MSReservation.entity.RentableArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentableAreaRepository extends JpaRepository<RentableArea, Integer> {
}
