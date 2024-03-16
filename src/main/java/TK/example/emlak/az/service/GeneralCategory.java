package TK.example.emlak.az.service;

import TK.example.emlak.az.dto.GeneralCategoryDto;

import java.util.List;

public interface GeneralCategory {

   List<GeneralCategoryDto> getAllCategories();
   GeneralCategoryDto getCategoryById(Long id);

  TK.example.emlak.az.entity.GeneralCategory createCategory(GeneralCategoryDto createCategoryDto);
   void updateCategory(Long id , GeneralCategoryDto updateCategory);
   void deleteCategory(Long id);

}
