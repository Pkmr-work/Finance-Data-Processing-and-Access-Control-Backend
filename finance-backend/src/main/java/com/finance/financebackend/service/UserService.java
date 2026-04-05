package com.finance.financebackend.service;
import com.finance.financebackend.entity.User;
import com.finance.financebackend.dto.UserDto;
import com.finance.financebackend.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public User createUser(UserDto dto) {


        if (repo.findByUsername(dto.getUsername()).isPresent()) {
            throw new RuntimeException("Username already exists");
        }

        User user = new User();

        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setRole(dto.getRole());
        user.setActive(true);

        return repo.save(user);
    }

    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public User toggleStatus(Long id) {
        User user = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setActive(!user.isActive());
        return repo.save(user);
    }
}