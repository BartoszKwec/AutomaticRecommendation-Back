package pl.kwec.automaticrecommendationback.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kwec.automaticrecommendationback.model.Rating;
import pl.kwec.automaticrecommendationback.repository.MovieRepository;
import pl.kwec.automaticrecommendationback.repository.RatingsRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RatingController {
    private final RatingsRepository ratingsRepository;

    @GetMapping("/ratings")
    public List<Rating> test() {
        return ratingsRepository.findAll();
    }
}
