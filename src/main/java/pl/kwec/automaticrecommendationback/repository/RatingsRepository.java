package pl.kwec.automaticrecommendationback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.kwec.automaticrecommendationback.model.Movie;
import pl.kwec.automaticrecommendationback.model.MovieRating;
import pl.kwec.automaticrecommendationback.model.Rating;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface RatingsRepository extends JpaRepository<Rating, Long> {

    public List<Rating> findAllByMovie(Movie movie);

    @Query("FROM Rating WHERE userId=:id")
    public List<Rating> getRatingListById(Long id);

    @Query("FROM Movie as m JOIN Rating as r ON m.id=r.movie.id WHERE r.userId=:id")
    public List<Movie> getMovieList(Long id);

    @Query("SELECT userId From Rating ")
    public List<Long> getUsersId(Long id);

    @Query("FROM Rating")
    public List<Rating> getRatingList();

    @Query("SELECT r.userId, m.title, r.rating FROM Rating as r JOIN Movie as m ON r.movie.id=m.id")
    public Map<Long, HashMap<String, Double>> getAllList();


    @Query("SELECT r.userId, m.title, r.rating FROM Rating as r JOIN Movie as m ON r.movie.id=m.id")
    public List<MovieRating> getAll();

}
