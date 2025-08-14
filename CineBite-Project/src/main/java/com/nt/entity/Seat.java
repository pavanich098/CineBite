package com.nt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "seat")
@Data
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "seat_number")
    private int seatNumber;

    @Column(name = "row_number")
    private int row;

    @Column(name = "type", length = 20)
    private String type;

    @Column(name = "booked_status", length = 20)
    private String bookedStatus;
}
