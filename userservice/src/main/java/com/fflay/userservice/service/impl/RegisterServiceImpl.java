package com.fflay.userservice.service.impl;

import com.fflay.userservice.exception.UserAlreadyExistException;
import com.fflay.userservice.model.user.User;
import com.fflay.userservice.model.user.dto.request.RegisterRequest;
import com.fflay.userservice.model.user.entity.UserEntity;
import com.fflay.userservice.model.user.enums.UserType;
import com.fflay.userservice.model.user.mapper.RegisterRequestToUserEntityMapper;
import com.fflay.userservice.model.user.mapper.UserEntityToUserMapper;
import com.fflay.userservice.repository.UserRepository;
import com.fflay.userservice.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Implementation of {@link RegisterService} for handling user registration.
 */
@Service
@RequiredArgsConstructor
public class RegisterServiceImpl implements RegisterService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RegisterRequestToUserEntityMapper registerRequestToUserEntityMapper = RegisterRequestToUserEntityMapper.initialize();
    private final UserEntityToUserMapper userEntityToUserMapper = UserEntityToUserMapper.initialize();

    /**
     * Registers a new user based on the provided {@link RegisterRequest}.
     *
     * <p>This method checks if the email already exists in the database, maps the registration request to a user entity,
     * encodes the user's password, saves the user entity to the database, and returns the registered user.</p>
     *
     * @param registerRequest the request containing user registration details.
     * @return the registered {@link User}.
     * @throws UserAlreadyExistException if the email is already used for another user.
     */
    @Override
    public User registerUser(RegisterRequest registerRequest) {
        if(userRepository.existsUserEntityByEmail(registerRequest.getEmail())){
            throw new UserAlreadyExistException("The email is already used for another admin: " + registerRequest.getEmail());
        }
        final UserEntity userEntityToBeSave = registerRequestToUserEntityMapper.mapForSaving(registerRequest);
        userEntityToBeSave.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        var savedUserEntity = userRepository.save(userEntityToBeSave);
        return userEntityToUserMapper.map(savedUserEntity);
    }
}
