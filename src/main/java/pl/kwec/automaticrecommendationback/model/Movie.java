package pl.kwec.automaticrecommendationback.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name="MOVIES2")
@Getter
@Setter
@NoArgsConstructor
public class Movie {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private long id;

    @Column(name="TITLE")
    private String title;


    @Column(name="TAG")
    private String tag;


    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    @JsonIgnore
    Set<Rating> ratings;
}
