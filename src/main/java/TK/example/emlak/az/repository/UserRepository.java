package TK.example.emlak.az.repository;

import TK.example.emlak.az.dto.UserDto;
import TK.example.emlak.az.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<UserDto> findByEmail(String email);
}
