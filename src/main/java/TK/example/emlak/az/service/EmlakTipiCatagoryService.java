package TK.example.emlak.az.service;

import TK.example.emlak.az.dto.EmlakTipiCatagoryDto;
import TK.example.emlak.az.entity.EmlakTipiCatagory;

import java.util.List;

public interface EmlakTipiCatagoryService {

    List<EmlakTipiCatagoryDto>  getAll();

    void deleteCategoryId(Long id);
    List<EmlakTipiCatagoryDto> update(Long id,EmlakTipiCatagoryDto emlakTipiCatagoryDto);
    EmlakTipiCatagory save(EmlakTipiCatagoryDto emlakTipiCatagoryDto);
}
