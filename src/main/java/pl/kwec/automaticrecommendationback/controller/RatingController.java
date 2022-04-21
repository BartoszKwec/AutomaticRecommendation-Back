package pl.kwec.automaticrecommendationback.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.kwec.automaticrecommendationback.model.Movie;
import pl.kwec.automaticrecommendationback.model.Rating;
import pl.kwec.automaticrecommendationback.model.User;
import pl.kwec.automaticrecommendationback.repository.MovieRepository;
import pl.kwec.automaticrecommendationback.repository.RatingsRepository;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RatingController {
    private final RatingsRepository ratingsRepository;


    @GetMapping("/ratings")
    public Map<Long, List<Rating>> test() {
        List<Rating> ratingList = ratingsRepository.findAll();

        Map<Long, List<Rating>> raUserListMap = ratingList.stream().collect(Collectors.groupingBy(Rating::getUserId));

        return raUserListMap;
    }

    @GetMapping("/movies/ratings")
    public List<Rating> getRatingsByMovie(@RequestBody Movie movie) {
        return ratingsRepository.findAllByMovie(movie);
    }
}
