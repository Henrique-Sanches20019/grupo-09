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
 * SMS notification entity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sms")
public class SMS implements Notification {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String operatorName;
    
    @Override
    public void sendMessage() {
        // Implementation of SMS sending logic
        System.out.println("Sending SMS notification via " + operatorName);
    }
}
