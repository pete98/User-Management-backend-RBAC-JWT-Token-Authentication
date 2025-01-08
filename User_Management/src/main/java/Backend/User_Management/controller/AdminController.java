package Backend.User_Management.controller;

import Backend.User_Management.dtos.RegisterUserDTo;
import Backend.User_Management.entities.User;
import Backend.User_Management.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/admins")
@RestController
public class AdminController {
    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public ResponseEntity<User> createAdministrator(@RequestBody RegisterUserDTo registerUserDTo){
        User createdAdmin = userService.createAdministrator(registerUserDTo);

        return ResponseEntity.ok(createdAdmin);
    }
}
