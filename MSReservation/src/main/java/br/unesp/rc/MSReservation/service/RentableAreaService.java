package br.unesp.rc.MSReservation.service;

import br.unesp.rc.MSReservation.entity.RentableArea;
import br.unesp.rc.MSReservation.repository.RentableAreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentableAreaService {

    private final RentableAreaRepository rentableAreaRepository;

    @Autowired
    public RentableAreaService(RentableAreaRepository rentableAreaRepository) {
        this.rentableAreaRepository = rentableAreaRepository;
    }

    /**
     * Saves a new rentable area to the database.
     * @param rentableArea The area object to be created.
     * @return The saved RentableArea entity, including its generated ID.
     */
    public RentableArea create(RentableArea rentableArea) {
        // You could add validation here, e.g., check if an area with the same name already exists.
        return rentableAreaRepository.save(rentableArea);
    }
}
