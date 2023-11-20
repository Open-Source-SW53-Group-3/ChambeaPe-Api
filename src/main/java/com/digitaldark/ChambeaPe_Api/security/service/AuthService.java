package com.digitaldark.ChambeaPe_Api.security.service;

import com.digitaldark.ChambeaPe_Api.security.jwt.provider.JwtTokenProvider;
import com.digitaldark.ChambeaPe_Api.security.model.dto.enums.EStatus;
import com.digitaldark.ChambeaPe_Api.security.model.dto.request.LoginRequestDto;
import com.digitaldark.ChambeaPe_Api.security.model.dto.request.RegisterRequestDto;
import com.digitaldark.ChambeaPe_Api.security.model.dto.response.ApiResponse;
import com.digitaldark.ChambeaPe_Api.security.model.dto.response.RegisteredUserResponseDto;
import com.digitaldark.ChambeaPe_Api.security.model.dto.response.TokenResponseDto;
import com.digitaldark.ChambeaPe_Api.shared.exception.CustomException;
import com.digitaldark.ChambeaPe_Api.user_security.model.entity.User;
import com.digitaldark.ChambeaPe_Api.user_security.model.enums.ERole;
import com.digitaldark.ChambeaPe_Api.user_security.repository.IRoleRepository;
import com.digitaldark.ChambeaPe_Api.user_security.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

/**
 * Service for user authentication and registration
 * @author Ray Del Carmen
 */

@Service
public class AuthService implements IAuthService {
    private final AuthenticationManager authenticationManager;
    private final IUserRepository userRepository;
    private final IRoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final ModelMapper modelMapper;

    public AuthService(AuthenticationManager authenticationManager, IUserRepository userRepository, IRoleRepository roleRepository, PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider, ModelMapper modelMapper) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
        this.modelMapper = modelMapper;
    }

    @Transactional
    @Override
    public ApiResponse<RegisteredUserResponseDto> registerUser(RegisterRequestDto request) {
        //If the email is already registered
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new CustomException(HttpStatus.CONFLICT, "El email '" + request.getEmail() + "' ya está registrado");
        }

        //If the username is already registered
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new CustomException(HttpStatus.CONFLICT, "El username '" + request.getUsername() + "' ya está registrado");
        }

        //If the password and confirm password are not the same
        var user = User.builder()
                .fullName(request.getFullName())
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        System.out.println("User: " + user);
        //userRepository.save(user); //It saves the user

        //It sets the role to the user (USER) by default (if it exists) or throws an exception
        var roles = roleRepository.findByName(ERole.ROLE_USER)
                .orElseThrow(() -> new CustomException(HttpStatus.INTERNAL_SERVER_ERROR, "No se pudo registrar el usuario, no se encontró el rol USER"));
        user.setRoles(Collections.singleton(roles)); //It sets the role to the user

        System.out.println("User: " + user);

        //It saves the user
        var newUser = userRepository.save(user);

        //It maps the user to a DTO
        var responseData = modelMapper.map(newUser, RegisteredUserResponseDto.class);

        return new ApiResponse<>("Registro correcto", EStatus.SUCCESS, responseData);
    }

    @Override
    public ApiResponse<TokenResponseDto> login(LoginRequestDto request) {
        //It authenticates the user
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsernameOrEmail(),
                        request.getPassword()
                )
        );

        //It sets the authentication
        SecurityContextHolder.getContext().setAuthentication(authentication);

        //It generates the token
        String token = jwtTokenProvider.generateToken(authentication);

        var responseData = new TokenResponseDto(token);
        return new ApiResponse<>("Autenticación correcta", EStatus.SUCCESS, responseData);
    }
}
