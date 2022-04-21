package pl.kwec.automaticrecommendationback.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
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

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/movies2")
    public Page<Movie> getMoviesPageable(Pageable pageable) {
        return movieRepository.findAll(pageable);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/movies")
    @Cacheable("test")
    public List<Movie> getMovies() {


        return movieRepository.findAll();
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/movies3")
    public List<Movie> getMovies2() {
        return movieRepository.findAll();
    }
}
