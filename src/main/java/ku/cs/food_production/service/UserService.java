package ku.cs.food_production.service;

import ku.cs.food_production.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepo repo;

    @Autowired
    public UserService(UserRepo repo) {
        this.repo = repo;
    }
}
