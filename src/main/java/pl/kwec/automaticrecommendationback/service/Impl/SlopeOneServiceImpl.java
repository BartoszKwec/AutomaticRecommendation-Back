package pl.kwec.automaticrecommendationback.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kwec.automaticrecommendationback.model.Rating;
import pl.kwec.automaticrecommendationback.repository.RatingsRepository;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))

public class SlopeOneServiceImpl {

    private final RatingsRepository ratingsRepository;

//    @Override
//    public void getRecommendedMovieList(Long ratingId) throws IOException, UnsupportedKerasConfigurationException, InvalidKerasConfigurationException {
//        List<Rating> RatingsList = ratingsRepository.getRatingList();
//    }
    private static Map<String, Map<String, Double>> diff = new HashMap<>();
    private static Map<String, Map<String, Integer>> freq = new HashMap<>();
    private static Map<Long, Map<String, Double>> inputData;
    private static Map<Long, Map<String, Double>> outputData = new HashMap<>();
    private static List<String> uniqMovies;
//    private final SlopeOne slopeOne;

        public void start() {
        inputData = prepareData();
        System.out.println("Slope One - Before the Prediction\n");
        buildDifferencesMatrix(inputData);
        System.out.println("\nSlope One - With Predictions\n");
        predict(inputData);
    }


    //    @Cacheable("prepareData")
    public Map<Long, Map<String, Double>> prepareData() {

        Map<Long, Map<String, List<Rating>>> ratingList = ratingsRepository.findAll().
                stream().collect(
                        Collectors.groupingBy(o -> o.getUserId(), Collectors.groupingBy(o -> o.getMovie().getTag())));


        uniqMovies = ratingsRepository.findAll().stream().distinct().map(rating -> rating.getMovie().getTag()).collect(Collectors.toList());

        Map<Long, Map<String, Double>> result = new HashMap<>();
        for (Map<String, List<Rating>> rating : ratingList.values()) {
            Map<String, Double> test = new HashMap<>();
            for (List<Rating> rating1 : rating.values()) {
                rating1.get(0).getRating();
                test.put(rating1.get(0).getMovie().getTag(), rating1.get(0).getRating());
                result.put(rating1.get(0).getUserId(), test);

            }

//            Map<Long, List<Rating>> test = ratingsRepository.findAll().stream().collect(Collectors.groupingBy(Rating::getUserId));
        }



        return result;
    }




    /**
     * Based on the available data, calculate the relationships between the
     * items and number of occurences
     *
     * @param data existing user data and their items' ratings
     */
    private static void buildDifferencesMatrix(Map<Long, Map<String, Double>> data) {
        for (Map<String, Double> user : data.values()) {
            for (Map.Entry<String, Double> e : user.entrySet()) {
                if (!diff.containsKey(e.getKey())) {
                    diff.put(e.getKey(), new HashMap<String, Double>());
                    freq.put(e.getKey(), new HashMap<String, Integer>());
                }
                for (Map.Entry<String, Double> e2 : user.entrySet()) {
                    int oldCount = 0;
                    if (freq.get(e.getKey()).containsKey(e2.getKey())) {
                        oldCount = freq.get(e.getKey()).get(e2.getKey()).intValue();
                    }
                    double oldDiff = 0.0;
                    if (diff.get(e.getKey()).containsKey(e2.getKey())) {
                        oldDiff = diff.get(e.getKey()).get(e2.getKey()).doubleValue();
                    }
                    double observedDiff = e.getValue() - e2.getValue();
                    freq.get(e.getKey()).put(e2.getKey(), oldCount + 1);
                    diff.get(e.getKey()).put(e2.getKey(), oldDiff + observedDiff);
                }
            }
        }
        for (String j : diff.keySet()) {
            for (String i : diff.get(j).keySet()) {
                double oldValue = diff.get(j).get(i).doubleValue();
                int count = freq.get(j).get(i).intValue();
                diff.get(j).put(i, oldValue / count);
            }
        }
        printData(data);
    }

    /**
     * Based on existing data predict all missing ratings. If prediction is not
     * possible, the value will be equal to -1
     *
     * @param data existing user data and their items' ratings
     */
    private static void predict(Map<Long, Map<String, Double>> data) {
        HashMap<String, Double> uPred = new HashMap<String, Double>();
        HashMap<String, Integer> uFreq = new HashMap<String, Integer>();
        for (String j : diff.keySet()) {
            uFreq.put(j, 0);
            uPred.put(j, 0.0);
        }
        for (Map.Entry<Long, Map<String, Double>> e : data.entrySet()) {
            for (String j : e.getValue().keySet()) {
                for (String k : diff.keySet()) {
                    try {
                        double predictedValue = diff.get(k).get(j).doubleValue() + e.getValue().get(j).doubleValue();
                        double finalValue = predictedValue * freq.get(k).get(j).intValue();
                        uPred.put(k, uPred.get(k) + finalValue);
                        uFreq.put(k, uFreq.get(k) + freq.get(k).get(j).intValue());
                    } catch (NullPointerException e1) {
                    }
                }
            }
            HashMap<String, Double> clean = new HashMap<String, Double>();
            for (String j : uPred.keySet()) {
                if (uFreq.get(j) > 0) {
                    clean.put(j, uPred.get(j).doubleValue() / uFreq.get(j).intValue());
                }
            }
            for (String j : uniqMovies) {
                if (e.getValue().containsKey(j)) {
                    clean.put(j, e.getValue().get(j));
                } else if (!clean.containsKey(j)) {
                    clean.put(j, -1.0);
                }
            }
            outputData.put(e.getKey(), clean);
            System.out.println(outputData);
        }
        printData(outputData);
    }

    private static void printData(Map<Long, Map<String, Double>> data) {
        for (Long user : data.keySet()) {
            System.out.println(user.intValue() + ":");
            print(data.get(user));
        }
    }

    private static void print(Map<String, Double> hashMap) {
        NumberFormat formatter = new DecimalFormat("#0.000");
        for (String j : hashMap.keySet()) {
            System.out.println(" " + j + " --> " + formatter.format(hashMap.get(j).doubleValue()));
        }
    }


}

