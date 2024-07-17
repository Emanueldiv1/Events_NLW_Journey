package com.rocketseat.planer.activity;

import com.rocketseat.planer.trip.Trip;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Entity
@Table(name = "activities")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "occurs_at", nullable = false)
    private LocalDateTime occurs_At;

    @ManyToOne
    @JoinColumn(name = "trip_id", nullable = false)
    private Trip trip;

    public Activity(String title, String occurredAt, Trip trip) {
        this.title = title;
        this.occurs_At = LocalDateTime.parse(occurredAt, DateTimeFormatter.ISO_DATE_TIME);
        this.trip = trip;
    }


}
