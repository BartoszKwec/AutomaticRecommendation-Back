package pl.kwec.automaticrecommendationback.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "RATING")
@Getter
@Setter
@NoArgsConstructor
public class Rating {


    @Id
    @Column(name = "user_id")
    private long userId;


    @Id
    @Column(name = "movie_id")
    private long movieId;


    @Column(name = "rating")
    private double rating;


    @Column(name = "timestamp")
    private String timestamp; //przemyśleć

    public Rating (double rating, String timestamp){
        this.rating=rating;
        this.timestamp=timestamp;
    }
}
