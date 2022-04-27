package pl.kwec.automaticrecommendationback.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.kwec.automaticrecommendationback.model.Movie;
import pl.kwec.automaticrecommendationback.model.Rating;
import pl.kwec.automaticrecommendationback.recommender.SlopeOne.SlopeOne5;
import pl.kwec.automaticrecommendationback.repository.RatingsRepository;
import pl.kwec.automaticrecommendationback.service.Impl.SlopeOneServiceImpl;
import pl.kwec.automaticrecommendationback.service.RatingService;
import pl.kwec.automaticrecommendationback.utils.SlopeOne;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/ratings")
public class RatingController {
    private final RatingsRepository ratingsRepository;
    private final RatingService ratingService;
    private final SlopeOneServiceImpl slopeOneService;


    @GetMapping()
    public Map<Long, List<Rating>> test() {
        List<Rating> ratingList = ratingsRepository.findAll();

        Map<Long, List<Rating>> raUserListMap = ratingList.stream().collect(Collectors.groupingBy(Rating::getUserId));

        return raUserListMap;
    }

    @GetMapping("/movies/ratings")
    public List<Rating> getRatingsByMovie(@RequestBody Movie movie) {
        return ratingsRepository.findAllByMovie(movie);
    }

    //    @GetMapping("/{ratingId}")
//    public List<Rating> getRatingsByMovie(
//            @PathVariable(name = "ratingId") Long ratingId
//            ) {
//        System.out.println(ratingId);
//        return ratingsRepository.getRatingListById(ratingId);
//    }
    @GetMapping("/{ratingId}")
    public List<Movie> getRatingsByMovie(
            @PathVariable(name = "ratingId") Long ratingId) {
        //System.out.println(ratingsRepository.getMovieList(ratingId));
        //twoLsit(ratingsRepository.getMovieList(ratingId),ratingsRepository.getMovieList(ratingId));
        //        return ratingsRepository.getMovieList(ratingId);


        slopeOneService.start();
        //slopeOneService.prepareData(ratingsRepository.getAll());
       // slopeOneService.start(ratingId);
        return null;
    }

//    @GetMapping("/{ratingId}")
//    public List<Rating> getRatingsById(
//            @PathVariable(name = "ratingId") Long ratingId
//    ) {
//        System.out.println(ratingId);
//
//        return ratingsRepository.getRatingListById(ratingId);
//    }
}
