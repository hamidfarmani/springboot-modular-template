package {{cookiecutter.package_name}}.authservice;

import {{cookiecutter.package_name}}.authservice.config.security.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {


  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;

  public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder,
      JwtService jwtService, AuthenticationManager authenticationManager) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
    this.jwtService = jwtService;
    this.authenticationManager = authenticationManager;
  }


  public AuthenticationResponse register(RegisterRequest registerRequest) {

    boolean existsByEmail = userRepository.existsByEmail(registerRequest.getEmail());

    if(existsByEmail) {
      throw new RuntimeException("Email already exists");
    }

    User user = User.builder()
        .firstName(registerRequest.getFirstName())
        .lastName(registerRequest.getLastName())
        .email(registerRequest.getEmail())
        .password(passwordEncoder.encode(registerRequest.getPassword()))
        .role(Role.USER)
        .build();



    userRepository.save(user);

    String jwt = jwtService.generateToken(user);
    return AuthenticationResponse.builder()
        .token(jwt)
        .build();
  }

  public AuthenticationResponse login(LoginRequest loginRequest) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
            loginRequest.getPassword()));

    User user = userRepository.findByEmail(loginRequest.getEmail())
        .orElseThrow(() -> new UsernameNotFoundException("User not found"));

    String jwt = jwtService.generateToken(user);
    return AuthenticationResponse.builder()
        .token(jwt)
        .build();
  }

  public UserResponse getCurrentUser(){
    User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    return UserResponse.builder()
        .id(currentUser.getId())
        .firstName(currentUser.getFirstName())
        .lastName(currentUser.getLastName())
        .email(currentUser.getEmail())
        .role(currentUser.getRole().name())
        .build();
  }

  public UserResponse getUserByEmail(String email){
    User user = userRepository.findByEmail(email)
        .orElseThrow(() -> new UsernameNotFoundException("User not found"));

    return UserResponse.builder()
        .id(user.getId())
        .firstName(user.getFirstName())
        .lastName(user.getLastName())
        .email(user.getEmail())
        .role(user.getRole().name())
        .build();
  }


}
