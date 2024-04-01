package TK.example.emlak.az.service;

import TK.example.emlak.az.dto.EmlakDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmlakService {
    List<EmlakDto> getAll();

    List<EmlakDto> sortByPriceHighToLow(Double descending);

    List<EmlakDto> sortByPriceLowToHigh(Double ascending);

    List<EmlakDto> getAllEmlakFromSameLocation(List<String> location);
    List<EmlakDto> getByForSelling(String forSelling);
    List<EmlakDto> getByForRent(String forRent);

    EmlakDto getEmlakById(Long id);

    EmlakDto getByArea(Double area);

    EmlakDto getByMertebe(Integer mertebe);

    void deleteEmlakById(Long id);

    void deleteAll();

    EmlakDto updateInfo(EmlakDto emlakDto, Long id);

    void saveInfo(EmlakDto emlakDto);

    @Transactional
    Boolean availableInSelling(Long id);

    List<EmlakDto> getEmlakBetweenMinAndMax(Double minPrice, Double maxPrice);

    EmlakDto getByLocation(String location);






}
