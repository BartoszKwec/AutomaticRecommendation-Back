package pl.kwec.automaticrecommendationback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kwec.automaticrecommendationback.model.Movie;
import pl.kwec.automaticrecommendationback.model.Rating;

import java.util.List;

@Repository
public interface RatingsRepository extends JpaRepository<Rating, Long> {

    public List<Rating> findAllByMovie(Movie movie);
}
