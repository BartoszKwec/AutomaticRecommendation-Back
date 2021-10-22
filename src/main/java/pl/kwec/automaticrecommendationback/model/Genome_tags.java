package pl.kwec.automaticrecommendationback.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity (name = "GENOME_TAGS")
@Getter
@Setter
@NoArgsConstructor
public class Genome_tags {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tag_id")
    private long tagId;

    @Column(name = "tag")
    private String tag;

    public Genome_tags(String tags){
        this.tag=tag;
    }
}
