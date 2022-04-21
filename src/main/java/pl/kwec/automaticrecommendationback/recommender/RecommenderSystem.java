package pl.kwec.automaticrecommendationback.recommender;
import java.io.File;
import java.util.List;

import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.impl.similarity.CityBlockSimilarity;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;

public class RecommenderSystem {
//     try {
//
//        CityBlockSimilarity similarity = new CityBlockSimilarity(res);
//        UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1,similarity, res);
//        UserBasedRecommender recommender = new GenericUserBasedRecommender(res, neighborhood, similarity);
//
//        // UserID and number of items to be recommended
//        List<recommendeditem> recommended_items = recommender.recommend(2, 2);
//
//        for (RecommendedItem r : recommended_items) {
//            System.out.println(r);
//        }
//    } catch (Exception ex) {
//        System.out.println("An exception occured!");
//    }</recommendeditem>
}
