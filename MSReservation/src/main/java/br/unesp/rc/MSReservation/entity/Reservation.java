package br.unesp.rc.MSReservation.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * Reservation entity class
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reservation")
public class Reservation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable = false)
    private Integer idArea;
    
    @Column(nullable = false)
    private Integer idResident;
    
    @Column(nullable = false)
    private boolean active;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date startDate;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date endDate;
    
    @Column
    private String description;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReservationStatus status;
    
    @ManyToOne
    @JoinColumn(name = "rentable_area_id", insertable = false, updatable = false)
    private RentableArea rentableArea;
    
    @ManyToOne
    @JoinColumn(name = "resident_id", insertable = false, updatable = false)
    private Resident resident;
    
    @OneToMany
    private List<Email> emailNotifications;
    
    @OneToMany
    private List<SMS> smsNotifications;
    
    @Transient
    private Notification notification;
}
