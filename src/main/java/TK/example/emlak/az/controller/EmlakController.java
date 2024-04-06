package TK.example.emlak.az.controller;

import TK.example.emlak.az.dto.EmlakDto;
import TK.example.emlak.az.entity.Emlak;
import TK.example.emlak.az.manager.EmlakManager;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/emlaks")
public class EmlakController {
    private final EmlakManager emlakManager;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<EmlakDto>> getAll() {
        List<EmlakDto> getAll = emlakManager.getAll();
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
    public ResponseEntity<String> saveInfo(@RequestBody EmlakDto emlakDto) {
        emlakManager.saveInfo(emlakDto);
        String message = "Successfully";

        return ResponseEntity.ok(message);
    }

    @GetMapping("/selling")
    @ResponseStatus(HttpStatus.OK)
    public List<EmlakDto> getByForSelling(@RequestParam String forSelling) {
        return emlakManager.getByForSelling(forSelling);

    }

    @GetMapping("/rent")
    @ResponseStatus(HttpStatus.OK)
    public List<EmlakDto> getByForRent(String forRent) {
        return emlakManager.getByForRent(forRent);
    }

    @GetMapping("/get/{id}")
    public List<EmlakDto> getEmlakById(@PathVariable("id") Long id) {
        return emlakManager.getEmlakById(id);
    }

    @GetMapping("/area")
    public ResponseEntity<List<EmlakDto>> getByAreaBetweenMinAndMax(@RequestParam Double minArea, @RequestParam Double maxArea) {
        List<EmlakDto> getByArea = emlakManager.getByAreaBetweenMinAndMax(minArea,maxArea);
        return ResponseEntity.ok(getByArea);

    }


}
