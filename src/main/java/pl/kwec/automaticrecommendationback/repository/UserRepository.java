package pl.kwec.automaticrecommendationback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kwec.automaticrecommendationback.model.User;

@Repository

public interface UserRepository extends JpaRepository<User, Long> {
}
