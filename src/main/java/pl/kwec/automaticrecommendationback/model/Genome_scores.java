package pl.kwec.automaticrecommendationback.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GENOME_SCORES")
@Getter
@Setter
@NoArgsConstructor
public class Genome_scores {

    @Id
    @Column(name = "movie_id")
    private long movieId;

    @Id
    @Column(name = "tag_id")
    private long tagId;

    @Column(name = "relevance")
    private double relevance;

    public Genome_scores(double relevance){
        this.relevance=relevance;
    }

}
