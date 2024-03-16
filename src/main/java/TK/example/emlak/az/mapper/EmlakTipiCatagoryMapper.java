package TK.example.emlak.az.mapper;

import TK.example.emlak.az.dto.EmlakTipiCatagoryDto;
import TK.example.emlak.az.entity.EmlakTipiCatagory;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
@Mapper(componentModel = "spring")
public interface EmlakTipiCatagoryMapper {
    void toEmlakTipiCatagory(EmlakTipiCatagoryDto emlakTipiCatagoryDto,@MappingTarget EmlakTipiCatagory emlakTipiCatagory);
    EmlakTipiCatagoryDto toEmlakTipiCatagoryDto(EmlakTipiCatagory emlakTipiCatagory);
    EmlakTipiCatagory toEmlakTipiCatagory(EmlakTipiCatagoryDto emlakTipiCatagoryDto);
}
