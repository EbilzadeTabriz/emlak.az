package TK.example.emlak.az.controller;

import TK.example.emlak.az.dto.EmlakTipiCatagoryDto;
import TK.example.emlak.az.manager.EmlakTipiCatagoryManager;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/emlakTipi")
public class EmlakTipiCatagoryController {

    private final EmlakTipiCatagoryManager emlakTipiCatagoryManager;

    @GetMapping
    public ResponseEntity<List<EmlakTipiCatagoryDto>> getAll() {
        List<EmlakTipiCatagoryDto> emlakTipiCatagoryDto = emlakTipiCatagoryManager.getAll();

        if (emlakTipiCatagoryDto.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else if (!(emlakTipiCatagoryDto.isEmpty())) {

        } else {

            String message = " Something went wrong";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(emlakTipiCatagoryDto);

        }
        return null;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCategoryId(@PathVariable("id") Long id) {
      if (id.equals(EmlakTipiCatagoryDto.class)) {
          String message = "Successful!";

          return ResponseEntity.status(HttpStatus.OK).body(message);
      }

        return null;
    }

    @PutMapping("/updateCategory/{id}")
    public ResponseEntity<List<EmlakTipiCatagoryDto>> update(@PathVariable("id") Long id, @RequestBody EmlakTipiCatagoryDto emlakTipiCatagoryDto) {
        List<EmlakTipiCatagoryDto> emlakTipiCatagoryDtos = emlakTipiCatagoryManager.update(id, emlakTipiCatagoryDto);
        return ResponseEntity.ok(emlakTipiCatagoryDtos);
    }

    @PostMapping("/saveEmlakCatgeory")
    public ResponseEntity save(EmlakTipiCatagoryDto emlakTipiCatagoryDto) {
        emlakTipiCatagoryManager.save(emlakTipiCatagoryDto);
        if (emlakTipiCatagoryDto.equals(null)) {
            String error =  "Something went wrong!";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        } else {

            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}
