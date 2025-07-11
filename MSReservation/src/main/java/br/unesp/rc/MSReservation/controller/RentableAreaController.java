package br.unesp.rc.MSReservation.controller;

import br.unesp.rc.MSReservation.entity.RentableArea;
import br.unesp.rc.MSReservation.service.RentableAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rentable-areas")
public class RentableAreaController {

    private final RentableAreaService rentableAreaService;

    @Autowired
    public RentableAreaController(RentableAreaService rentableAreaService) {
        this.rentableAreaService = rentableAreaService;
    }

    /**
     * Endpoint to create a new rentable area.
     * This operation should be restricted to authorized personnel (e.g., ADMIN).
     * @param rentableArea A JSON object representing the rentable area.
     * @return The created area with an HTTP 201 status.
     */
    @PostMapping
    public ResponseEntity<RentableArea> createRentableArea(@RequestBody RentableArea rentableArea) {
        RentableArea newArea = rentableAreaService.create(rentableArea);
        return new ResponseEntity<>(newArea, HttpStatus.CREATED);
    }
}
