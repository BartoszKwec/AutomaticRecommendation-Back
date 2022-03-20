package pl.kwec.automaticrecommendationback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kwec.automaticrecommendationback.model.Rating;

@Repository
public interface RatingsRepository extends JpaRepository<Rating, Long> {
}
