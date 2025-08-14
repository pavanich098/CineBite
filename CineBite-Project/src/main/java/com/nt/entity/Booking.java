package com.nt.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "booking")
@Data
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")  // foreign key to User
    private User user;

    @ManyToOne
    @JoinColumn(name = "food_item_id")  // foreign key to FoodItem
    private FoodItem foodItem;

    @Column(name = "booking_time")
    private LocalDateTime bookingTime;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "total_price")
    private double totalPrice;
}
