package com.finance.financebackend.dto;
import jakarta.validation.constraints.NotBlank;
import com.finance.financebackend.entity.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    @NotBlank(message = "Username is required")
    private String username;

    @NotBlank(message = "Password is required")
    private String password;

    private Role role;

    
}

