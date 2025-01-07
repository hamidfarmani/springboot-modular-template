package {{cookiecutter.package_name}}.authservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }


  @GetMapping("/me")
  public ResponseEntity<UserResponse> getCurrentUser() {
    UserResponse response = userService.getCurrentUser();
    return ResponseEntity.ok(response);

  }

  @GetMapping
  public ResponseEntity<UserResponse> getUserByEmail(@RequestParam(value = "email") String email) {
    UserResponse response = userService.getUserByEmail(email);
    return ResponseEntity.ok(response);
  }


}
