package pl.kwec.automaticrecommendationback.model;




import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="MOVIE")
@Getter
@Setter
@NoArgsConstructor
public class Movie {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="movie_id")
    private long movieId;

    @Column(name="title")
    private String title;

    @Column(name="genres")
    private String genres;


    public Movie(String title, String genres){
        this.genres=genres;
        this.title=title;
    }
}
