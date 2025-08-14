package com.nt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "food_item")
@Data
public class FoodItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "type", length = 20)
    private String type;

    @Column(name = "price")
    private double price;

    @Column(name = "description", length = 200)
    private String description;

    @Column(name = "available")
    private boolean available;

    @Column(name = "image_url", length = 100)
    private String imageUrl;
}
