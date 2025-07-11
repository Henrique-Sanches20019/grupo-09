package br.unesp.rc.MSResident.service;

import br.unesp.rc.MSResident.entity.Resident;
import br.unesp.rc.MSResident.repository.AccessRepository;
import br.unesp.rc.MSResident.repository.ResidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResidentService {

    private final ResidentRepository residentRepository;
    private final AccessRepository accessRepository;

    @Autowired
    public ResidentService(ResidentRepository residentRepository, AccessRepository accessRepository) {
        this.residentRepository = residentRepository;
        this.accessRepository = accessRepository;
    }

    /**
     * Saves a new resident to the database.
     * The CascadeType.ALL on the Person entity ensures that associated
     * Access, Contact, and Address entities are also saved.
     * @param resident The resident object to be created.
     * @return The saved resident entity, including its generated ID.
     */
    public Resident create(Resident resident) {
        // Here you could add validation logic, e.g., check if CPF or username already exist.
        return residentRepository.save(resident);
    }

    /**
     * Authenticates a resident based on username and password.
     * @param username The resident's username.
     * @param password The resident's password.
     * @return true if credentials are valid, false otherwise.
     */
    public boolean authenticate(String username, String password) {
        return accessRepository.findByUser(username)
                .map(access -> access.getPassword().equals(password))
                .orElse(false);
    }
}
