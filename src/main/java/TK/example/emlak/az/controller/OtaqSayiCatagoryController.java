package TK.example.emlak.az.controller;

import TK.example.emlak.az.dto.OtaqSayiCatagoryDto;
import TK.example.emlak.az.entity.OtaqSayiCatagory;
import TK.example.emlak.az.manager.OtaqSayiCatagoryManager;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("OtaqSayi")
@AllArgsConstructor
@RestController
public class OtaqSayiCatagoryController {

    private final OtaqSayiCatagoryManager otaqSayiCatagoryManager;

    @GetMapping("getAll")
    public ResponseEntity<List<OtaqSayiCatagoryDto>> getAllCategories() {
        List<OtaqSayiCatagoryDto> otaqSayiCatagories = otaqSayiCatagoryManager.getAllCategories();
        return ResponseEntity.status(HttpStatus.OK).body(otaqSayiCatagories);

    }
    @GetMapping("/getCategory/{id}")
    public ResponseEntity<OtaqSayiCatagoryDto> getCategoryById(@PathVariable("id") Long id) {
        OtaqSayiCatagoryDto otaqSayiCatagoryDto =  otaqSayiCatagoryManager.getCategoryById(id);
        return ResponseEntity.status(HttpStatus.OK).body(otaqSayiCatagoryDto);
    }
    @PostMapping("/create")
    public ResponseEntity < TK.example.emlak.az.entity.OtaqSayiCatagory> createCategory(@RequestBody OtaqSayiCatagoryDto createCategoryDto) {
        OtaqSayiCatagory otaqSayiCatagory =  otaqSayiCatagoryManager.createCategory(createCategoryDto);
        return ResponseEntity.status(HttpStatus.OK).body(otaqSayiCatagory);
    }
    @PutMapping("updateCategory/{id}")
    public void updateCategory(@PathVariable("id") Long id, @RequestBody OtaqSayiCatagoryDto updateCategoryDto) {
        otaqSayiCatagoryManager.updateCategory(id,updateCategoryDto);
    }
    @DeleteMapping("deleteCategory/{id}")
    public void deleteCategory(@PathVariable("id") Long id) {
        otaqSayiCatagoryManager.deleteCategory(id);
    }


    }