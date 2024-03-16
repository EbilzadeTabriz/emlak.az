package TK.example.emlak.az.manager;

import TK.example.emlak.az.dto.UserDto;
import TK.example.emlak.az.entity.User;
import TK.example.emlak.az.exception.YourCustomException;
import TK.example.emlak.az.mapper.UserMapper;
import TK.example.emlak.az.repository.UserRepository;
import TK.example.emlak.az.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserManager implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserDto> getAll() {
        List<User> user = userRepository.findAll();
        return user.stream().map(userMapper::toUserDto).collect(Collectors.toList());
    }

    @Override
    public UserDto getById(Long id) {
        Optional<User> userOption = userRepository.findById(id);

        return userOption.map(userMapper::toUserDto)
                .orElse(null); // or handle the case when the user is not present

    }

//    @Override
//    public void saveAll(List<UserDto> userDto) {
//
//        List<User> userList = userDto.stream().map(userMapper::toUser)
//                .collect(Collectors.toList());
//        userRepository.saveAll(userList);
//
//    }

    @Override
    public void saveInfo(UserDto userDto) {
        try {
            User user = userMapper.toUser(userDto);
              userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            throw new YourCustomException("User with the provided data already exists.");
        }
    }

    @Override
    public void update(UserDto userDto) {
        userRepository.save(userMapper.toUser(userDto));
    }

    @Override
    public void updateAll(List<UserDto> userDtoList, Long id) {
        for (UserDto userDto : userDtoList) {
            Optional<User> optionalUser = userRepository.findById((id));
            if (optionalUser.isPresent()) {
                User existingUser = optionalUser.get();
                existingUser.setFullName(userDto.getFullName());
                existingUser.setPassword(userDto.getPassword());
                existingUser.setNumber(userDto.getNumber());
                existingUser.setEmail(userDto.getEmail());
                userRepository.save(existingUser);
            } else {
                optionalUser.orElse(null);
            }
        }

    }

    @Override
    public void updateAndSave(UserDto userDto, Long id) {

        Optional<User> userOptional = userRepository.findById((id));
        if (userOptional.isPresent()) {
            System.out.println("Exist");
        } else {
            User newUser = userMapper.toUser(userDto);
            userRepository.save(newUser);
            System.out.println("User saved successfully");
        }

    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);

    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();

    }

    @Override
    public Boolean existsByEmail(String email) {
        Optional<UserDto> userOptional = userRepository.findByEmail(email);
        return userOptional.isPresent();
    }

    @Override
    public Boolean existsById(Long id) {
        return userRepository.existsById(id);
    }


    @Override
    public Long count() {

        return userRepository.count();
    }

    @Override
    public List<UserDto> getAllSortedByName() {
        List<User> userList = userRepository.findAll(Sort.by(Sort.Direction.ASC, "fullName"));
        return userList.stream().map(userMapper::toUserDto)
                .collect(Collectors.toList());
    }
}
