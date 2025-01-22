package Backend.User_Management.services;

import Backend.User_Management.dtos.RegisterUserDTo;
import Backend.User_Management.dtos.UserDto;
import Backend.User_Management.entities.Role;
import Backend.User_Management.entities.RoleEnum;
import Backend.User_Management.entities.User;
import Backend.User_Management.repository.RoleRepository;
import Backend.User_Management.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;


    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public List<UserDto> allUsers(){
        List<User> users = new ArrayList<>();

        userRepository.findAll().forEach(users::add);

        return users.stream()
                .map(user -> new UserDto(user.getId(), user.getFullName(), user.getEmail(), user.getPosition()))
                .collect(Collectors.toList());
    }



    public User createAdministrator(RegisterUserDTo input){
        Optional<Role> optionalRole = roleRepository.findByName(RoleEnum.ADMIN);

        if (optionalRole.isEmpty()){
            return null;
        }

        var user = new User();
        user.setFullName(input.getFullName());
        user.setEmail(input.getEmail());
        user.setPosition(input.getPosition());
        user.setPassword(passwordEncoder.encode(input.getPassword()));
        user.setRole(optionalRole.get());

        return userRepository.save(user);
    }

    //find user by role
    public List<UserDto> getUsersByRole(RoleEnum roleName) {
        return userRepository.findByRoleName(roleName);
    }

    //update user
    public UserDto updateUser(Long id, UserDto userDto){
        User user = userRepository.findById(id)
                .orElseThrow();
        user.setEmail(userDto.getEmail());
        user.setFullName(userDto.getFullName());
        user.setPosition(userDto.getPosition());

        userRepository.save(user);
        return mapToDTO(user);

    }

    //Delete User
    public void deleteUser(Long id){
        User user = userRepository.findById(id)
                .orElseThrow();
        userRepository.delete(user);
    }

    //find user by id
    public UserDto findUserById(Long id){
        User user = userRepository.findById(id)
                .orElseThrow();
        return mapToDTO(user);
    }


    //maptodto
    public UserDto mapToDTO(User user){
        return new UserDto(
                user.getId(),
                user.getFullName(),
                user.getEmail(),
                user.getPosition()
        );
    }

    //Get current logged in user details
    public UserDto getLoggedInUserDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        User user = userRepository.findByEmail(username)
                .orElseThrow();

        return new UserDto(user.getId(), user.getFullName(), user.getEmail(), user.getPosition());
    }









}
