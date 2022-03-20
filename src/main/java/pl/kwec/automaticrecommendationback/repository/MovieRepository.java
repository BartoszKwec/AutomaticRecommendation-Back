package pl.kwec.automaticrecommendationback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kwec.automaticrecommendationback.model.Movie;


@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

}
