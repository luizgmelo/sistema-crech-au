package com.api.crechau.controllers;


import com.api.crechau.dtos.AuthenticationRecordDto;
import com.api.crechau.dtos.LoginResponseDto;
import com.api.crechau.dtos.RegisterRecordDto;
import com.api.crechau.models.UserModel;
import com.api.crechau.services.AuthorizationService;
import com.api.crechau.services.TokenService;
import com.api.crechau.utils.ApiGlobalResponseDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private AuthorizationService authorizationService;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationRecordDto data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((UserModel) auth.getPrincipal());

        return ResponseEntity.status(HttpStatus.OK).body(new LoginResponseDto(token));
    }

    @PostMapping("/register")
    public  ResponseEntity<ApiGlobalResponseDto> register(@RequestBody @Valid RegisterRecordDto data){
        UserDetails userDetails = authorizationService.findByLogin(data.login());
        if (userDetails != null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        UserModel newUser = new UserModel(data.name(), data.login(), encryptedPassword, data.role());

        this.authorizationService.save(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

}
