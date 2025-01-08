package Backend.User_Management.bootstrap;

import Backend.User_Management.dtos.RegisterUserDTo;
import Backend.User_Management.entities.Role;
import Backend.User_Management.entities.RoleEnum;
import Backend.User_Management.entities.User;
import Backend.User_Management.repository.RoleRepository;
import Backend.User_Management.repository.UserRepository;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

public class AdminSeeder implements ApplicationListener {
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AdminSeeder(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        this.createSuperAdministrator();
    }

    private void createSuperAdministrator(){
        RegisterUserDTo userDTo = new RegisterUserDTo();
        userDTo.setFullName("Super Admin");
        userDTo.setEmail("super.admin@email.com");
        userDTo.setPassword("123456");

        Optional<Role> optionalRole = roleRepository.findByName(RoleEnum.SUPER_ADMIN);
        Optional<User> optionalUser = userRepository.findByEmail(userDTo.getEmail());

        if (optionalRole.isEmpty() || optionalUser.isPresent()){
            return;
        }

        var user = new User();
        user.setFullName(user.getFullName());
        user.setPassword(passwordEncoder.encode(userDTo.getPassword()));
        user.setRole(optionalRole.get());

        userRepository.save(user);
    }
}
