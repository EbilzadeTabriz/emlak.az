package TK.example.emlak.az.mapper;

import TK.example.emlak.az.dto.UserDto;
import TK.example.emlak.az.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toUserDto(User user);
    User toUser(UserDto userDto);







}
