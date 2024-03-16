package TK.example.emlak.az.mapper;

import TK.example.emlak.az.dto.EmlakDto;
import TK.example.emlak.az.entity.Emlak;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmlakMapper {
    EmlakDto toEmlakDto(Emlak emlak);
    Emlak toEmlak(EmlakDto emlakDto);
}
