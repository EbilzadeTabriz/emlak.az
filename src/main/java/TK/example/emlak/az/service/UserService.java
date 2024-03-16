package TK.example.emlak.az.service;

import TK.example.emlak.az.dto.UserDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {

    List<UserDto> getAll();
    UserDto getById(Long id);
//    void saveAll(List<UserDto> userDto);
//    List<UserDto> getByRole(Role role);
    void saveInfo(UserDto userDto);
    void update(UserDto userDto);
    void  updateAll(List<UserDto> userDto,Long id);
    @Transactional
    void updateAndSave(UserDto userDto,Long id);
    void deleteById(Long id);
    void deleteAll();
    Boolean existsByEmail(String email);
    Boolean existsById(Long id);
    Long count();
    List<UserDto> getAllSortedByName();


}
