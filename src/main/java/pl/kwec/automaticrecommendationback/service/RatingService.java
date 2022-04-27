package pl.kwec.automaticrecommendationback.service;


import org.deeplearning4j.nn.modelimport.keras.exceptions.InvalidKerasConfigurationException;
import org.deeplearning4j.nn.modelimport.keras.exceptions.UnsupportedKerasConfigurationException;

import java.io.IOException;

public interface RatingService {


    void getRecommendedMovieList(Long ratingId) throws IOException, UnsupportedKerasConfigurationException, InvalidKerasConfigurationException;
}
