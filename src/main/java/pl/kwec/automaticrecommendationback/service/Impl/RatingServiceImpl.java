package pl.kwec.automaticrecommendationback.service.Impl;

import lombok.RequiredArgsConstructor;
import org.deeplearning4j.nn.modelimport.keras.exceptions.InvalidKerasConfigurationException;
import org.deeplearning4j.nn.modelimport.keras.exceptions.UnsupportedKerasConfigurationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kwec.automaticrecommendationback.model.Movie;
import pl.kwec.automaticrecommendationback.model.Rating;
import pl.kwec.automaticrecommendationback.recommender.SoftMax;
import pl.kwec.automaticrecommendationback.repository.RatingsRepository;
import pl.kwec.automaticrecommendationback.service.RatingService;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class RatingServiceImpl implements RatingService {


    private final RatingsRepository ratingsRepository;


    @Override
    public void getRecommendedMovieList(Long ratingId) throws IOException, UnsupportedKerasConfigurationException, InvalidKerasConfigurationException {
        List<Movie> userRatingFilmList = ratingsRepository.getMovieList(ratingId);
        List<Rating> userRatingsList = ratingsRepository.getRatingListById(ratingId);
        SoftMax softMax = new SoftMax();

        List<String> recommendedFilmList = softMax.twoList(userRatingFilmList, userRatingsList, ratingId);





    }


}
