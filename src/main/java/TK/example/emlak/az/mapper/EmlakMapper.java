package TK.example.emlak.az.mapper;

import TK.example.emlak.az.dto.EmlakDto;
import TK.example.emlak.az.entity.Emlak;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EmlakMapper {
    EmlakDto toEmlakDto(Emlak emlak);

    Emlak toEmlak(EmlakDto emlakDto);

    EmlakMapper Instance = Mappers.getMapper(EmlakMapper.class);

    @Mapping(target = "emlakId", ignore = true)
    void updateEmlakFromDto(EmlakDto emlakDto, @MappingTarget Emlak emlak);
}
