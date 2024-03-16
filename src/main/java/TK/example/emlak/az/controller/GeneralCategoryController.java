package TK.example.emlak.az.controller;

import TK.example.emlak.az.dto.GeneralCategoryDto;
import TK.example.emlak.az.entity.GeneralCategory;
import TK.example.emlak.az.manager.GeneralCategoryManager;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("generalCategory")
public class GeneralCategoryController {
    private final GeneralCategoryManager generalCategoryManager;

    @GetMapping("getAll")
    public ResponseEntity<List<GeneralCategoryDto>> getAllCategories() {
        List<GeneralCategoryDto> generalCategoryDtos = generalCategoryManager.getAllCategories();
        return ResponseEntity.status(HttpStatus.OK).body(generalCategoryDtos);

    }

    @GetMapping("getCategory/{id}")
    public ResponseEntity<GeneralCategoryDto> getCategoryById(@PathVariable("id") Long id) {
        GeneralCategoryDto generalCategoryDto = generalCategoryManager.getCategoryById(id);
        return ResponseEntity.status(HttpStatus.OK).body(generalCategoryDto);
    }
    @PostMapping("/create")
    public ResponseEntity<GeneralCategory> createCategory(@RequestBody GeneralCategoryDto createCategoryDto) {

    GeneralCategory generalCategory = generalCategoryManager.createCategory(createCategoryDto);
        return ResponseEntity.status(HttpStatus.OK).body(generalCategory);

    }
    @PutMapping("/updated/{id}")
    public ResponseEntity<String> updateCategory(@PathVariable("id") Long id,@RequestBody GeneralCategoryDto updateCategory) {
        generalCategoryManager.updateCategory(id,updateCategory);
        String message = "Everything is going well";
        return ResponseEntity.status(HttpStatus.OK).body(message);

    }
    @DeleteMapping("/deleted/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") Long id) {
        generalCategoryManager.deleteCategory(id);
        String message = "Everything is going well";
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }




    }
