package pl.kwec.automaticrecommendationback.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
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


    @Column(name = "user_id")
    private long userId;

    @Column(name = "rating")
    private double rating;

    @Column(name = "timestamp")
    private int timestamp;



//    @Column(name="movie_id")
//    private long movieId;

    @ManyToOne
    private Movie movie;


    public long getRatingId() {
        return ratingId;
    }

    public void setRatingId(long ratingId) {
        this.ratingId = ratingId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
//@ManyToOne
   // private User user;

}
