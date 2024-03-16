package TK.example.emlak.az.manager;

import TK.example.emlak.az.dto.OtaqSayiCatagoryDto;
import TK.example.emlak.az.entity.OtaqSayiCatagory;
import TK.example.emlak.az.mapper.OtaqSayiCatagoryMapper;
import TK.example.emlak.az.repository.OtaqSayiCatagoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class OtaqSayiCatagoryManager implements TK.example.emlak.az.service.OtaqSayiCatagoryService {
    private final OtaqSayiCatagoryRepository otaqSayiCatagoryRepository;
    private final OtaqSayiCatagoryMapper otaqSayiCatagoryMapper;

    @Override
    public List<OtaqSayiCatagoryDto> getAllCategories() {
        List<TK.example.emlak.az.entity.OtaqSayiCatagory> otaqSayiCatagories = otaqSayiCatagoryRepository.findAll();
        return otaqSayiCatagories.stream().map(otaqSayiCatagoryMapper::toOtaqSayiCatagoryDto).collect(Collectors.toList());
    }

    @Override
    public OtaqSayiCatagoryDto getCategoryById(Long id) {
        OtaqSayiCatagory  otaqSayiCatagories =  otaqSayiCatagoryRepository.findById(id).get();
        return otaqSayiCatagoryMapper.toOtaqSayiCatagoryDto(otaqSayiCatagories);
    }

    @Override
    @Transactional
    public TK.example.emlak.az.entity.OtaqSayiCatagory createCategory(OtaqSayiCatagoryDto createCategoryDto) {
        TK.example.emlak.az.entity.OtaqSayiCatagory otaqSayiCatagory = otaqSayiCatagoryMapper.toOtaqSayiCatagory(createCategoryDto);
        return otaqSayiCatagoryRepository.save(otaqSayiCatagory);
    }

    @Override
    @Transactional
    public void updateCategory(Long id, OtaqSayiCatagoryDto updateCategoryDto) {
        Optional<OtaqSayiCatagory> optionalGeneralCategory = otaqSayiCatagoryRepository.findById(id);

        if (optionalGeneralCategory.isPresent()) {
            OtaqSayiCatagory existing = optionalGeneralCategory.get();

            otaqSayiCatagoryMapper.toOtaqSayiCatagory(updateCategoryDto, existing);
        }
    }


    @Override
    public void deleteCategory(Long id) {
        otaqSayiCatagoryRepository.deleteById(id);

    }
}
