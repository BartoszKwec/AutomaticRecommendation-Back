package pl.kwec.automaticrecommendationback.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "LINK")
@Getter
@Setter
@NoArgsConstructor
public class Link {


    @Id
    @Column(name = "movie_id")
    private long movieId;


    @Column(name = "imbd_id")
    private long imbdId;


    @Column(name = "tmbd_id")
    private long tmdbId;
}
