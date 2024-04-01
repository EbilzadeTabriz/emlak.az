package TK.example.emlak.az.controller;

import TK.example.emlak.az.dto.EmlakDto;
import TK.example.emlak.az.manager.EmlakManager;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/emlak")
@RestController
public class EmlakController {
    private final EmlakManager emlakManager;

    @GetMapping("/forSelling/{forSelling}")
    public ResponseEntity<List<EmlakDto>> getByForSelling(@PathVariable("forSelling") String forSelling) {
      List<EmlakDto> emlakDtoList = emlakManager.getByForSelling(forSelling);
      return ResponseEntity.status(HttpStatus.OK).body(emlakDtoList);
    }
    @GetMapping("/forRent/{forRent}")
    public ResponseEntity<List<EmlakDto>> getByForRent(@PathVariable("forRent") String forRent) {
        List<EmlakDto> emlakDtoList =  emlakManager.getByForRent(forRent);
        return ResponseEntity.status(HttpStatus.OK).body(emlakDtoList);

    }



        @GetMapping
    public ResponseEntity<List<EmlakDto>> getAll() {
        List<EmlakDto> emlakDtoList = emlakManager.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(emlakDtoList);
    }

    @GetMapping("descending")
    public ResponseEntity<List<EmlakDto>> sortByPriceHighToLow( Double descending) {
        List<EmlakDto> emlakDtoList = emlakManager.sortByPriceHighToLow(descending);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(emlakDtoList);
    }

    @GetMapping("ascending")
    public ResponseEntity<List<EmlakDto>> sortByPriceLowToHigh( Double ascending) {
        List<EmlakDto> emlakDtoList = emlakManager.sortByPriceLowToHigh(ascending);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(emlakDtoList);
    }

    @GetMapping("/locations/location")
    public ResponseEntity<List<EmlakDto>> getAllEmlakFromSameLocation(@RequestParam List<String> location) {
        List<EmlakDto> emlakDtoList = emlakManager.getAllEmlakFromSameLocation(location);
        return ResponseEntity.status(HttpStatus.OK).body(emlakDtoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmlakDto> getEmlakById(@PathVariable("id") Long id) {
        EmlakDto emlakDtoList = emlakManager.getEmlakById(id);
        return ResponseEntity.status(HttpStatus.OK).body(emlakDtoList);
    }
    @GetMapping("/area/{area}")
    public ResponseEntity<EmlakDto > getByArea(@PathVariable("area") Double area) {
        EmlakDto emlakDto = emlakManager.getByArea(area);
        return ResponseEntity.status(HttpStatus.OK).body(emlakDto);
    }
    @GetMapping("/mertebe/{mertebe}")
    public ResponseEntity<EmlakDto> getByMertebe(@PathVariable("mertebe") Integer mertebe) {
        EmlakDto emlakDto = emlakManager.getByMertebe(mertebe);
        return ResponseEntity.status(HttpStatus.OK).body(emlakDto);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteEmlakById(@PathVariable("id") Long id) {
        String message = "Emlak was deleted successfully!";
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }
    @DeleteMapping
    public ResponseEntity<String> deleteAll() {
        emlakManager.deleteAll();
        String message = " All emlak were deleted successfully!";
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }
    @PutMapping("updateInfo/{id}")
    public ResponseEntity<EmlakDto> updateInfo(@RequestBody EmlakDto emlakDto, @PathVariable("id") Long id) {
        EmlakDto emlakDto1 = emlakManager.updateInfo(emlakDto,id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(emlakDto1);
    }

    @PostMapping("/saved")
    public ResponseEntity<String> saveInfo(@RequestBody EmlakDto emlakDto) {
        emlakManager.saveInfo(emlakDto);
        try {
            // Your logic to save EmlakDto
            return ResponseEntity.ok("Emlak saved successfully");
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Internal Server Error");
        }
    }
    @PatchMapping("/available/{id}")
    public ResponseEntity<Boolean> availableInSelling(@PathVariable("id") Long id) {
        Boolean  emlak = emlakManager.availableInSelling(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(emlak);

    }
    @GetMapping("/price-range/{minPrice}/{maxPrice}")
    public ResponseEntity<List<EmlakDto>> getEmlakByPriceRange(
            @PathVariable("minPrice") Double minPrice,
            @PathVariable("maxPrice") Double maxPrice) {
      List<EmlakDto>  emlakDtoList = emlakManager.getEmlakBetweenMinAndMax(minPrice,maxPrice);
        if (!(emlakDtoList.isEmpty())){
            return ResponseEntity.status(HttpStatus.OK).body(emlakDtoList);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        }

    }
    //Problem
    @GetMapping("/location")
    public ResponseEntity<EmlakDto> getByLocation(@RequestParam String location) {
       EmlakDto emlakDto = emlakManager.getByLocation(location);
       return ResponseEntity.status(HttpStatus.OK).body(emlakDto);
    }










    }
