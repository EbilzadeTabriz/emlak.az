package TK.example.emlak.az.mapper;

import TK.example.emlak.az.dto.GeneralCategoryDto;
import TK.example.emlak.az.entity.GeneralCategory;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface GeneralCategoryMapper {
    void toGeneralCategory(GeneralCategoryDto generalCategoryDto, @MappingTarget GeneralCategory generalCategory);

    GeneralCategory toGeneralCategory(GeneralCategoryDto generalCategoryDto);
    GeneralCategoryDto toGeneralCategoryDto(GeneralCategory generalCategory);


}
