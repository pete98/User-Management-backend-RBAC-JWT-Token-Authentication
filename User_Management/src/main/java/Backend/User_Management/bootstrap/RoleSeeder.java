package Backend.User_Management.bootstrap;

import Backend.User_Management.entities.Role;
import Backend.User_Management.entities.RoleEnum;
import Backend.User_Management.repository.RoleRepository;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;

@Component
public class RoleSeeder implements ApplicationListener {
    private final RoleRepository roleRepository;

    public RoleSeeder(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        this.loadRoles();

    }

    private void loadRoles(){
        RoleEnum [] roleNames = new RoleEnum[] {RoleEnum.USER, RoleEnum.ADMIN, RoleEnum.SUPER_ADMIN};
        Map<RoleEnum, String> roleDescriptionMap = Map.of(
                RoleEnum.USER, "Default user role",
                RoleEnum.ADMIN, "Administrator role",
                RoleEnum.SUPER_ADMIN, "Super Administrator role"
        );

        Arrays.stream(roleNames).forEach((roleName) -> {
            Role roleToCreate = new Role();

            roleToCreate.setName(roleName);
            roleToCreate.setDescription(roleDescriptionMap.get(roleName));
            roleRepository.save(roleToCreate);
        });
    }
}
