package TK.example.emlak.az.dto;

import TK.example.emlak.az.entity.Emlak;

import java.util.List;

public record GeneralCategoryDto(
        String name,
        List<EmlakDto> emlak
) {
}
