package br.unesp.rc.MSResident.service;

import br.unesp.rc.MSResident.repository.ResidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResidentService {

    private final ResidentRepository residentRepository;

    @Autowired
    public ResidentService(ResidentRepository residentRepository) {
        this.residentRepository = residentRepository;
    }

    /**
     * Authenticates a resident based on username and password.
     * @param username The resident's username.
     * @param password The resident's password.
     * @return true if credentials are valid, false otherwise.
     */
    public boolean authenticate(String username, String password) {
        return residentRepository.findByUser(username)
                .map(access -> access.getPassword().equals(password))
                .orElse(false);
    }
}
