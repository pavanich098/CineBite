package com.nt.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "movie")
@Data
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "title", length = 20)
    private String title;

    @Column(name = "language", length = 20)
    private String language;

    @Column(name = "genre", length = 20)
    private String genre;

    @Column(name = "show_time", length = 20)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private String showTime;

    @Column(name = "duration")
    private double duration;
}
