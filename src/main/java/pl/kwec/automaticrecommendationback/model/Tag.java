package pl.kwec.automaticrecommendationback.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity(name = "TAG")
@Getter
@Setter
@NoArgsConstructor
public class Tag {


    @Id
    @Column(name = "user_id")
    private long userId;


    @Id
    @Column(name = "movie_id")
    private long movieId;

    @Column(name = "tag")
    private double tag;

    @Column(name = "timestamp")
    private String timestamp; //Przemyślec

}
