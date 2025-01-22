package Backend.User_Management.repository;

import Backend.User_Management.dtos.UserDto;
import Backend.User_Management.entities.RoleEnum;
import Backend.User_Management.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    List<UserDto> findByRoleName(RoleEnum roleName);








}
