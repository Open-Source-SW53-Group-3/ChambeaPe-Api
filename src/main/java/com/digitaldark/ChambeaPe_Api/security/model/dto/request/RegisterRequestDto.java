package com.digitaldark.ChambeaPe_Api.security.model.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class that represents the API request body when a user is registered
 * @author Ray Del Carmen
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestDto {
    @NotEmpty(message = "El nombre y apellido es requerido")
    private String fullName;

    @NotEmpty(message = "El nombre de usuario es requerido")
    @Size(min = 2, message = "El nombre de usuario debe tener por lo menos 2 caracteres")
    private String username;

    @NotEmpty(message = "El email es requerido")
    @Email(message = "El formato del email no es válido")
    private String email;

    @NotEmpty(message = "La contraseña es requerida")
    @Size(min = 3, message = "La contraseña debe tener por lo menos 3 caracteres")
    private String password;
}