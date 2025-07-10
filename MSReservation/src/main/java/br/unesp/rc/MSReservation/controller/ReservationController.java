package br.unesp.rc.MSReservation.controller;

import br.unesp.rc.MSReservation.entity.Reservation;
import br.unesp.rc.MSReservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    /**
     * Endpoint for a resident to create a new reservation request.
     * @param reservation The reservation data.
     * @return The created reservation with status 201 (Created).
     */
    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        Reservation createdReservation = reservationService.createReservation(reservation);
        return new ResponseEntity<>(createdReservation, HttpStatus.CREATED);
    }

    /**
     * Endpoint for an employee to view all pending reservation requests.
     * @return A list of reservations awaiting approval.
     */
    @GetMapping("/pending")
    public ResponseEntity<List<Reservation>> getPendingReservations() {
        List<Reservation> pendingReservations = reservationService.findPendingReservations();
        return ResponseEntity.ok(pendingReservations);
    }

    /**
     * Endpoint for an employee to approve a reservation.
     * @param id The ID of the reservation to approve.
     * @return The updated reservation with status CONFIRMED.
     */
    @PatchMapping("/{id}/approve")
    public ResponseEntity<Reservation> approveReservation(@PathVariable Integer id) {
        Reservation approvedReservation = reservationService.approveReservation(id);
        return ResponseEntity.ok(approvedReservation);
    }
}
