package pl.kwec.automaticrecommendationback.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kwec.automaticrecommendationback.model.Movie;
import pl.kwec.automaticrecommendationback.repository.MovieRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MovieController {
    private final MovieRepository movieRepository;

//    @Autowired
//    public MovieController(MovieRepository movieRepository) {
//        this.movieRepository = movieRepository;
//    }

    @RequestMapping("/movies")
    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }
}
