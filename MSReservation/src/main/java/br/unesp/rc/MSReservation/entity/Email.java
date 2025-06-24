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
 * Email notification entity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "email")
public class Email implements Notification {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String providerName;
    
    @Override
    public void sendMessage() {
        // Implementation of email sending logic
        System.out.println("Sending email notification via " + providerName);
    }
}
