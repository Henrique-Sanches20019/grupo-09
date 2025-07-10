package br.unesp.rc.MSReservation.service;

import br.unesp.rc.MSReservation.entity.Reservation;
import br.unesp.rc.MSReservation.entity.ReservationStatus;
import br.unesp.rc.MSReservation.exception.ResourceNotFoundException;
import br.unesp.rc.MSReservation.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    /**
     * Creates a new reservation request.
     * The status is automatically set to PENDING.
     * @param reservation The reservation object from the request.
     * @return The saved reservation with its generated ID and status.
     */
    public Reservation createReservation(Reservation reservation) {
        // "aguardando aprovação" -> PENDING
        reservation.setStatus(ReservationStatus.PENDING);
        reservation.setActive(true);
        return reservationRepository.save(reservation);
    }

    /**
     * Finds all reservations that are awaiting approval.
     * @return A list of reservations with PENDING status.
     */
    public List<Reservation> findPendingReservations() {
        // "aguardando aprovação" -> PENDING
        return reservationRepository.findByStatus(ReservationStatus.PENDING);
    }

    /**
     * Approves a reservation by changing its status.
     * @param reservationId The ID of the reservation to approve.
     * @return The updated reservation.
     * @throws ResourceNotFoundException if no reservation is found for the given ID.
     */
    public Reservation approveReservation(Integer reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation not found with id: " + reservationId));

        // "aprovado" -> CONFIRMED
        reservation.setStatus(ReservationStatus.CONFIRMED);
        return reservationRepository.save(reservation);
    }
}
