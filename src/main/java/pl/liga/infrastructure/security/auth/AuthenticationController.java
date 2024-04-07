package pl.liga.infrastructure.security.auth;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(AuthenticationController.AUTHORIZATION)
@RequiredArgsConstructor
public class AuthenticationController {

    public static final String AUTHORIZATION = "/authorization";
    public static final String AUTHORIZATION_REGISTER = "/register";
    public static final String AUTHORIZATION_AUTHENTICATE = "/authenticate";
    public static final String AUTHORIZATION_REFRESH = "/refresh";

    private final AuthenticationService authService;

    @PostMapping(AUTHORIZATION_REGISTER)
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ){
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping(AUTHORIZATION_AUTHENTICATE)
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ){
        return ResponseEntity.ok(authService.authenticate(request));
    }

    @PostMapping(AUTHORIZATION_REFRESH)
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException{
        authService.refreshToken(request, response);
    }
}
