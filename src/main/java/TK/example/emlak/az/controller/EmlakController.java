package TK.example.emlak.az.controller;

import TK.example.emlak.az.dto.EmlakDto;
import TK.example.emlak.az.dto.EmlakPageResponse;
import TK.example.emlak.az.manager.EmlakManager;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/emlaks")
public class EmlakController {
    private final EmlakManager emlakManager;

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<EmlakPageResponse> getAll(@RequestParam(value = "page") int page, @RequestParam(value = "count") int count) {
        EmlakPageResponse getAll = emlakManager.getAll(page,count);
        if (getAll != null) {
            return ResponseEntity.ok(getAll);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/descending")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<EmlakDto>> sortByPriceHighToLow() {
        List<EmlakDto> sortedList = emlakManager.sortByPriceHighToLow();
        return ResponseEntity.ok(sortedList);
    }

    @GetMapping("/ascending")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<EmlakDto>> sortByPriceLowToHigh() {
        List<EmlakDto> sortedList = emlakManager.sortByPriceLowToHigh();
        return ResponseEntity.ok(sortedList);
    }

    @GetMapping("/same")
    @ResponseStatus(HttpStatus.OK)
    public List<EmlakDto> getEmlaksFromSameLocation(@RequestParam("location") String location) {
        return emlakManager.getEmlaksFromSameLocation(location);
    }


    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> saveInfo(@RequestBody @Validated EmlakDto emlakDto) {
        emlakManager.saveInfo(emlakDto);
        String message = "Successfully";

        return ResponseEntity.ok(message);
    }

    @GetMapping("/selling")
    @ResponseStatus(HttpStatus.OK)
    public List<EmlakDto> getByForSelling(@RequestParam("forSelling") String forSelling) {
        return emlakManager.getByForSelling(forSelling);

    }

    @GetMapping("/rent")
    @ResponseStatus(HttpStatus.OK)
    public List<EmlakDto> getByForRent(@RequestParam("forRent") String forRent) {
        return emlakManager.getByForRent(forRent);
    }

    @GetMapping("/get/{id}")
    public List<EmlakDto> getEmlakById(@PathVariable("id") Long id) {
        return emlakManager.getEmlakById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/area")
    public ResponseEntity<List<EmlakDto>> getByAreaBetweenMinAndMax(@RequestParam Double minArea, @RequestParam Double maxArea) {
        List<EmlakDto> getByArea = emlakManager.getByAreaBetweenMinAndMax(minArea, maxArea);
        return ResponseEntity.ok(getByArea);

    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/floor/{flat}")
    public ResponseEntity<List<EmlakDto>> getByMertebe(@PathVariable("flat") Integer mertebe) {
        List<EmlakDto> emlakDtoList = emlakManager.getByMertebe(mertebe);

        return ResponseEntity.ok(emlakDtoList);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping("/delete/{id}")
    public void deleteEmlakById(@PathVariable("id") Long id) {
        emlakManager.deleteEmlakById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/deleteAll")
    public void deleteAll() {
        emlakManager.deleteAll();
    }

    @PutMapping("/update/{id}")
    public EmlakDto updateInfo(@RequestBody EmlakDto emlakDto, @PathVariable("id") Long id) {
        return emlakManager.updateInfo(emlakDto, id);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping("/available/{id}")
    public Boolean availableInSelling(@PathVariable("id") Long id) {
        return emlakManager.availableInSelling(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/price")
    public List<EmlakDto> getEmlakBetweenMinAndMax(@RequestParam("minPrice") Double minPrice, @RequestParam("maxPrice") Double maxPrice) {
        return emlakManager.getEmlakBetweenMinAndMax(minPrice, maxPrice);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping("/location")
    public List<EmlakDto> getByLocation(@RequestParam("location") String location) {
        return emlakManager.getByLocation(location);
    }

    @GetMapping("/count")
    public Long countOfEmlak(Long total) {
        return emlakManager.countOfEmlak(total);

    }

    @PostMapping("/saveAll")
    public void saveAll(@RequestBody @Validated List<EmlakDto> emlakDto) {
        emlakManager.saveAll(emlakDto);
    }

    @PutMapping("/updateAll")
    @ResponseStatus(HttpStatus.OK)
    public void updateAll(@RequestBody List<EmlakDto> emlakDto) {
        emlakManager.updateAll(emlakDto);
    }

}

