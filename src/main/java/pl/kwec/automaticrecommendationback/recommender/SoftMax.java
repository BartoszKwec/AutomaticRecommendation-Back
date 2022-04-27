package pl.kwec.automaticrecommendationback.recommender;

import org.deeplearning4j.nn.modelimport.keras.KerasModelImport;
import org.deeplearning4j.nn.modelimport.keras.exceptions.InvalidKerasConfigurationException;
import org.deeplearning4j.nn.modelimport.keras.exceptions.UnsupportedKerasConfigurationException;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.io.ClassPathResource;
import pl.kwec.automaticrecommendationback.model.Movie;
import pl.kwec.automaticrecommendationback.model.Rating;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SoftMax {
    String simpleMlp = new ClassPathResource("model.h5").getFile().getPath();
    MultiLayerNetwork model = KerasModelImport.importKerasSequentialModelAndWeights(simpleMlp);

    public SoftMax() throws IOException, UnsupportedKerasConfigurationException, InvalidKerasConfigurationException {
    }

    public List<String> twoList(List<Movie> movies, List<Rating> ratings, Long userId) throws IOException, UnsupportedKerasConfigurationException, InvalidKerasConfigurationException{

        List<String> aa = null;

        List<String> stringMoviesList = movies.stream().map(movie -> movie.getTitle()).collect(Collectors.toList());
        List<String> stringRatingList = ratings.stream().map(rating -> String.valueOf(rating.getRating())).collect(Collectors.toList());

        List<String> differences = stringRatingList.stream()
                .filter(element -> !stringMoviesList.contains(element))
                .collect(Collectors.toList());


        int lenDif = differences.size();
        ArrayList<Long> usersId = new ArrayList<Long>();
        for (int i = 0; i < lenDif; i++) {
            usersId.add(userId);
        }
        //INDArray inputs = Nd4j.create(usersId, new int[]{lenDif, 2});
        INDArray features = Nd4j.zeros(2);
        for (int i = 0; i < usersId.size(); i++)
            features.putScalar(usersId.get(i), Double.parseDouble(differences.get(i))); //wejście do anszej sieci/model neuronowej Podac userId i filmy



//        ArrayList<String> prediction = model.output(features).get(0);
//        System.out.println(prediction);
//        return prediction;
        return aa;
    }

//    public ArrayList getInputFormModel(List<String> differences, Long userId) {
//        int lengDif = differences.size();
//        ArrayList<Long> usersId = new ArrayList<Long>();
//        for (int i = 0; i < lengDif; i++) {
//            usersId.add(userId);
//        }
//        INDArray inputs = Nd4j.create(usersId, new int[]{lengDif, 2});
//        INDArray features = Nd4j.zeros(2);
//        for (int i = 0; i < usersId.size(); i++)
//            features.putScalar(usersId.get(i), differences.get(i)); //wejście do anszej sieci/model neuronowej Podac userId i filmy
//
//        return null;
//    }
//
//    public ArrayList<String> rec(INDArray features) throws IOException, UnsupportedKerasConfigurationException, InvalidKerasConfigurationException {
//
//
//        ArrayList<String> prediction = model.output(features).get(0);
//        System.out.println(prediction);
//        return prediction;
//    }

//    public void JettyDL4J() throws Exception {
//        String p = new ClassPathResource("model.h5").getFile().getPath();
//        model = KerasModelImport.importKerasSequentialModelAndWeights(p);
//    }
}
