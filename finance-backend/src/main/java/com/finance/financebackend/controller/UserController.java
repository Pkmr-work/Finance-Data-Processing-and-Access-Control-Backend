package com.finance.financebackend.controller;
import com.finance.financebackend.service.UserService;
import com.finance.financebackend.dto.UserDto;
import com.finance.financebackend.entity.User;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public User create(@Valid @RequestBody UserDto dto) {
        return service.createUser(dto);
    }

    @GetMapping
    public List<User> getAll() {
        return service.getAllUsers();
    }

    @PutMapping("/{id}/toggle")
    public User toggle(@PathVariable Long id) {
        return service.toggleStatus(id);
    }

}