package TK.example.emlak.az.service;

import TK.example.emlak.az.dto.EmlakDto;

import java.util.List;

public interface EmlakService {
    List<EmlakDto> getAll();

    List<EmlakDto> sortByPriceHighToLow();

    List<EmlakDto> sortByPriceLowToHigh();

    List<EmlakDto> getEmlaksFromSameLocation(String location);
    List<EmlakDto> getByForSelling(String forSelling);
    List<EmlakDto> getByForRent(String forRent);

    List<EmlakDto> getEmlakById(Long id);

    List<EmlakDto> getByAreaBetweenMinAndMax(Double minArea,Double maxArea);

    List<EmlakDto> getByMertebe(Integer mertebe);

    void deleteEmlakById(Long id);

    void deleteAll();

    EmlakDto updateInfo(EmlakDto emlakDto, Long id);

    void saveInfo(EmlakDto emlakDto);


    Boolean availableInSelling(Long id);

    List<EmlakDto> getEmlakBetweenMinAndMax(Double minPrice, Double maxPrice);

    List<EmlakDto> getByLocation(String location);






}
