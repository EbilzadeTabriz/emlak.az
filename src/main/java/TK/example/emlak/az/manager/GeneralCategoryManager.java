package TK.example.emlak.az.manager;

import TK.example.emlak.az.dto.GeneralCategoryDto;
import TK.example.emlak.az.mapper.EmlakMapper;
import TK.example.emlak.az.mapper.GeneralCategoryMapper;
import TK.example.emlak.az.repository.GeneralCategoryRepository;
import TK.example.emlak.az.service.GeneralCategory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class GeneralCategoryManager implements GeneralCategory {
    private final GeneralCategoryRepository generalCategoryRepository;
    private final GeneralCategoryMapper generalCategoryMapper;
    private final EmlakMapper emlakMapper;

    @Override
    public List<GeneralCategoryDto> getAllCategories() {
        List<TK.example.emlak.az.entity.GeneralCategory> generalCategoryDtos = generalCategoryRepository.findAll();
        return generalCategoryDtos.stream().map(generalCategoryMapper::toGeneralCategoryDto).collect(Collectors.toList());
    }

    @Override
    public GeneralCategoryDto getCategoryById(Long id) {
        TK.example.emlak.az.entity.GeneralCategory generalCategory = generalCategoryRepository.findCategoryById(id);
        return generalCategoryMapper.toGeneralCategoryDto(generalCategory);
    }


//    @Override
//    public void updateCategory(Long id, GeneralCategoryDto updateCategory) {
//
//    }


    @Transactional
    public TK.example.emlak.az.entity.GeneralCategory createCategory(GeneralCategoryDto createCategoryDto) {
        TK.example.emlak.az.entity.GeneralCategory generalCategory = generalCategoryMapper.toGeneralCategory(createCategoryDto);
       return generalCategoryRepository.save(generalCategory);
    }


    @Override
    @Transactional
    public void updateCategory(Long id, GeneralCategoryDto updateCategory) {
        Optional<TK.example.emlak.az.entity.GeneralCategory> optionalGeneralCategory = generalCategoryRepository.findById(id);

        if (optionalGeneralCategory.isPresent()) {
            TK.example.emlak.az.entity.GeneralCategory existing = optionalGeneralCategory.get();

            generalCategoryMapper.toGeneralCategory(updateCategory, existing);
        }
    }


    @Override
    public void deleteCategory(Long id) {
        generalCategoryRepository.deleteById(id);

    }
}
