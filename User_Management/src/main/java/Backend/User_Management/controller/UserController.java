package Backend.User_Management.controller;

import Backend.User_Management.dtos.UserDto;
import Backend.User_Management.entities.RoleEnum;
import Backend.User_Management.entities.User;
import Backend.User_Management.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController {
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<UserDto> authenticatedUser(){
        UserDto userDto = userService.getLoggedInUserDetails();
        return ResponseEntity.ok(userDto);
    }

    @GetMapping("/")
    @PreAuthorize("hasAnyRole('SUPER_ADMIN')")
    public ResponseEntity<List<UserDto>> allUsers(){
        List<UserDto> users = userService.allUsers();

        return ResponseEntity.ok(users);
    }

    //find user by defined role
    @GetMapping("/role/{roleName}")
    @PreAuthorize("hasAnyRole('ADMIN','SUPER_ADMIN')")
    public List<UserDto> getUsersByRole(@PathVariable RoleEnum roleName) {
        return userService.getUsersByRole(roleName);
    }

    //Delete user
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN')")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }

    //update user
    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'SUPER_ADMIN')")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long id, @RequestBody UserDto updatedUser){
        UserDto userDto = userService.updateUser(id, updatedUser);
        return ResponseEntity.ok(userDto);
    }

    //Find by user id
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findUserById(@PathVariable("id") Long id){
        UserDto user = userService.findUserById(id);
        return ResponseEntity.ok(user);

    }

















}
