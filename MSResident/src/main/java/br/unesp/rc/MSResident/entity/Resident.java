package br.unesp.rc.MSResident.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Resident entity class - extends Person
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "resident")
public class Resident extends Person {
    
    @Enumerated(EnumType.STRING)
    private ResidentType residentType;
    
    @ManyToOne
    @JoinColumn(name = "unit_id")
    private Unit unit;
}
