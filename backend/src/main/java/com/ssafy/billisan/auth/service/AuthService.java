package com.ssafy.billisan.auth.service;

import com.ssafy.billisan.auth.dto.LoginRequest;
import com.ssafy.billisan.auth.dto.LoginResponse;
import com.ssafy.billisan.global.exception.InvalidCredentialsException;
import com.ssafy.billisan.global.security.JwtProvider;
import com.ssafy.billisan.user.domain.UserAccount;
import com.ssafy.billisan.user.repository.UserAccountRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class AuthService {

    private final UserAccountRepository userAccountRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    public AuthService(
            UserAccountRepository userAccountRepository,
            PasswordEncoder passwordEncoder,
            JwtProvider jwtProvider) {
        this.userAccountRepository = userAccountRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtProvider = jwtProvider;
    }

    public LoginResponse login(LoginRequest request) {
        UserAccount user = userAccountRepository.findByLoginId(request.identifier())
                .orElseThrow(() -> new InvalidCredentialsException("아이디 또는 비밀번호가 올바르지 않습니다."));

        if (!passwordEncoder.matches(request.password(), user.getPasswordHash())) {
            throw new InvalidCredentialsException("아이디 또는 비밀번호가 올바르지 않습니다.");
        }

        String token = jwtProvider.generateToken(user.getUserRef().toString());
        Instant expiresAt = jwtProvider.getExpiration(token);

        return LoginResponse.of(token, expiresAt, user.getUserId(), user.isFaceRegistered());
    }
}