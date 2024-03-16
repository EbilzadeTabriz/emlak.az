package TK.example.emlak.az.mapper;

import TK.example.emlak.az.dto.OtaqSayiCatagoryDto;
import TK.example.emlak.az.entity.OtaqSayiCatagory;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface OtaqSayiCatagoryMapper {
    void toOtaqSayiCatagory(OtaqSayiCatagoryDto generalCategoryDto, @MappingTarget OtaqSayiCatagory otaqSayiCatagory);
    TK.example.emlak.az.entity.OtaqSayiCatagory toOtaqSayiCatagory(OtaqSayiCatagoryDto otaqSayiCatagoryDto);
    OtaqSayiCatagoryDto toOtaqSayiCatagoryDto(TK.example.emlak.az.entity.OtaqSayiCatagory otaqSayiCatagory);


}
