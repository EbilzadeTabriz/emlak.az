package TK.example.emlak.az.service;

import TK.example.emlak.az.dto.OtaqSayiCatagoryDto;
import TK.example.emlak.az.entity.OtaqSayiCatagory;

import java.util.List;

public interface OtaqSayiCatagoryService {
    List<OtaqSayiCatagoryDto> getAllCategories();
    OtaqSayiCatagoryDto getCategoryById(Long id);

    OtaqSayiCatagory createCategory(OtaqSayiCatagoryDto createCategoryDto);

    void updateCategory(Long id , OtaqSayiCatagoryDto updateCategory);
    void deleteCategory(Long id);
}
