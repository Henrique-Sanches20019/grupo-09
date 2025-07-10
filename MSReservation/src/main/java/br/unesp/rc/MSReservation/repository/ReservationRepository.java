package br.unesp.rc.MSReservation.repository;

import br.unesp.rc.MSReservation.entity.Reservation;
import br.unesp.rc.MSReservation.entity.ReservationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    /**
     * Finds all reservations with a specific status.
     * @param status The status to filter by (e.g., PENDING, CONFIRMED).
     * @return A list of reservations matching the status.
     */
    List<Reservation> findByStatus(ReservationStatus status);
}
