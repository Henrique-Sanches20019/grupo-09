package br.unesp.rc.MSEmployee.entity;

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
 * Access entity class
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "access")
public class Access {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String user;
    
    @Column(nullable = false)
    private String password;
}
