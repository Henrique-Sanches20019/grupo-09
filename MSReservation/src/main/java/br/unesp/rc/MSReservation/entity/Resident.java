package br.unesp.rc.MSReservation.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * Resident entity class
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "resident")
public class Resident {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idResident;
    
    @Column(nullable = false)
    private String name;
    
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date birthDate;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ResidentType type;
    
    @OneToMany(mappedBy = "resident")
    private List<Reservation> reservations;
}
