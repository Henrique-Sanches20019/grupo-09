package br.unesp.rc.MSReservation.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * RentableArea entity class representing areas that can be reserved
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rentable_area")
public class RentableArea {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private Integer size;
    
    @Column(nullable = false)
    private Integer capacity;
}
