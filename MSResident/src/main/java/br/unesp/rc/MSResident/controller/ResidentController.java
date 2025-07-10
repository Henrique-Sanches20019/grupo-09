package br.unesp.rc.MSResident.controller;

import br.unesp.rc.MSResident.dto.LoginRequest;
import br.unesp.rc.MSResident.entity.Resident;
import br.unesp.rc.MSResident.service.ResidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resident")
public class ResidentController {

    private final ResidentService residentService;

    @Autowired
    public ResidentController(ResidentService residentService) {
        this.residentService = residentService;
    }
    
    /**
     * Endpoint to create a new resident.
     * This operation should be restricted to authorized personnel (e.g., ADMIN).
     * @param resident A JSON object representing the resident.
     * @return The created resident with an HTTP 201 status.
     */
    @PostMapping
    public ResponseEntity<Resident> createResident(@RequestBody Resident resident) {
        Resident newResident = residentService.create(resident);
        return new ResponseEntity<>(newResident, HttpStatus.CREATED);
    }

    /**
     * Endpoint to authenticate a resident.
     * @param loginRequest DTO containing user and password.
     * @return ResponseEntity indicating success or failure.
     */
    @PostMapping("/auth")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        boolean isAuthenticated = residentService.authenticate(loginRequest.getUser(), loginRequest.getPassword());
        if (isAuthenticated) {
            return ResponseEntity.ok("Resident authenticated successfully.");
        } else {
            return ResponseEntity.status(401).body("Invalid credentials.");
        }
    }
}
