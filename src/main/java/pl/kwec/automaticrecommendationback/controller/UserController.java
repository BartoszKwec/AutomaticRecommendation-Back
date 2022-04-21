package pl.kwec.automaticrecommendationback.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kwec.automaticrecommendationback.model.Movie;
import pl.kwec.automaticrecommendationback.model.User;
import pl.kwec.automaticrecommendationback.repository.RatingsRepository;
import pl.kwec.automaticrecommendationback.repository.UserRepository;

import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {
    private final UserRepository userRepository;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
