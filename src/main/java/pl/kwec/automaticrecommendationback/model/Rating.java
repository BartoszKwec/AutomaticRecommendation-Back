package pl.kwec.automaticrecommendationback.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "RATINGS2")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private long ratingId;


    @Column(name = "rating")
    private double rating;

    @Column(name = "timestamp")
    private int timestamp;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private User user;

}
