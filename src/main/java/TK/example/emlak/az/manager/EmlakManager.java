package TK.example.emlak.az.manager;

import TK.example.emlak.az.dto.EmlakDto;
import TK.example.emlak.az.entity.Emlak;
import TK.example.emlak.az.mapper.EmlakMapper;
import TK.example.emlak.az.repository.EmlakRepository;
import TK.example.emlak.az.service.EmlakService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class EmlakManager implements EmlakService {
    private final EmlakRepository emlakRepository;
    private final EmlakMapper emlakMapper;

    @Override
    @GetMapping
    public List<EmlakDto> getAll() {
        List<Emlak> emlakDtoList = emlakRepository.findAll();
        return emlakDtoList.stream().map(emlakMapper::toEmlakDto).collect(Collectors.toList());
    }

    @Override
    public List<EmlakDto> sortByPriceHighToLow(Double descending) {
        List<Emlak> emlakList = emlakRepository.findAll();
        Comparator<EmlakDto> priceComparator = Comparator.comparingDouble(EmlakDto::price).reversed();
        List<EmlakDto> sortedList = emlakList.stream().map(emlakMapper::toEmlakDto)
                .sorted(priceComparator)
                .collect(Collectors.toList());
        return sortedList;
    }

    @Override
    public List<EmlakDto> sortByPriceLowToHigh(Double ascending) {
        List<Emlak> emlakList = emlakRepository.findAll();
        Comparator<EmlakDto> priceComparator = Comparator.comparingDouble(EmlakDto::price);

        if (ascending != null && ascending > 0) {
            priceComparator = priceComparator.reversed();
        }
        List<EmlakDto> sortedList = emlakList.stream().map(emlakMapper::toEmlakDto)
                .sorted(priceComparator)
                .collect(Collectors.toList());
        return sortedList;
    }

    @Override
    public List<EmlakDto> getAllEmlakFromSameLocation(List<String> location) {
        List<Emlak> emlakList = emlakRepository.findAll();

        return emlakList.stream().filter(emlak -> location.contains(emlak.getLocation()))
                .map(emlakMapper::toEmlakDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmlakDto> getByForSelling(String forSelling) {
        Optional<Emlak> emlakOptional = emlakRepository.findByForSelling(forSelling);
        return emlakOptional.stream().map(emlakMapper::toEmlakDto).collect(Collectors.toList());
    }

    @Override
    public List<EmlakDto> getByForRent(String forRent) {
        Optional<Emlak> emlakOptional = emlakRepository.findByForRent(forRent);
        return emlakOptional.stream().map(emlakMapper::toEmlakDto).collect(Collectors.toList());
    }

    @Override
    public EmlakDto getEmlakById(Long id) {
        Optional<Emlak> emlakOptional = emlakRepository.findById(id);

        return emlakOptional.map(emlakMapper::toEmlakDto).orElse(null);

    }

    @Override
    public EmlakDto getByArea(Double area) {
        Optional<Emlak> emlakOptional = emlakRepository.findByAreaGreaterThanEqualOrderByAreaAsc(area);
        if (emlakOptional.isPresent()) {
            Emlak emlak = emlakOptional.get();
            return emlakMapper.toEmlakDto(emlak);
        } else {
            return null;
        }
    }

    @Override
    public EmlakDto getByMertebe(Integer mertebe) {
        Optional<Emlak> emlakOptional = emlakRepository.findByMertebe(mertebe);

        return emlakOptional.map(emlakMapper::toEmlakDto).orElse(null);
    }

    @Override
    public void deleteEmlakById(Long id) {
        emlakRepository.deleteById(id);

    }

    @Override
    public void deleteAll() {
        emlakRepository.deleteAll();

    }

    @Override
    public EmlakDto updateInfo(EmlakDto emlakDto, Long id) {
        Optional<Emlak> emlakOptional = emlakRepository.findById(id);
        if (emlakOptional.isPresent()) {
            Emlak existing = emlakOptional.get();
            existing.setInfo(emlakDto.info());
            existing.setCixaris(emlakDto.cixaris());
            existing.setMuqavile(emlakDto.muqavile());
            existing.setLocation(emlakDto.location());
            existing.setMertebe(emlakDto.mertebe());
            existing.setArea(emlakDto.area());
            existing.setPrice(emlakDto.price());
            existing.setTipi(emlakDto.tipi());
            existing.setOtaqSayi(emlakDto.otaqSayi());
            existing.setForSelling(emlakDto.forSelling());
            existing.setForRent(emlakDto.forRent());
            emlakRepository.save(existing);
            return emlakMapper.toEmlakDto(existing);

        } else {
            return null;
        }
    }

    @Override
    public void saveInfo(EmlakDto emlakDto) {
        Emlak emlak = emlakMapper.toEmlak(emlakDto);
        emlakRepository.save(emlak);
    }

    // do it again
    @Override
    public Boolean availableInSelling(Long id) {

        Optional<Emlak> emlakOptional = emlakRepository.findById(id);
        if (emlakOptional.isPresent()) {
            System.out.println("Emlak with ID " + id + "  available.");
            return true;
        } else {
            System.out.println("Emlak with ID " + id + " not available.");
            return false;
        }
    }

    @Override
    public List<EmlakDto> getEmlakByPriceRange(Double minPrice, Double maxPrice) {
        List<Emlak> emlakList = emlakRepository.findByPriceBetween(minPrice, maxPrice);
        return emlakList.stream().map(emlakMapper::toEmlakDto).collect(Collectors.toList());
    }

    @Override
    public EmlakDto getByLocation(String location) {
        Optional<Emlak> emlakOptional = emlakRepository.findByLocation(location);
        return emlakOptional.map(emlakMapper::toEmlakDto).orElse(null);

}
    @Override
    public Boolean existsCixaris(Boolean cixaris) {
        Optional<EmlakDto> optional = emlakRepository.findByCixaris(cixaris);
        if (optional.equals(cixaris)) {
            System.out.println("There is a cixaris");
            return true;

        } else {
            System.out.println("Here is empty");
            return false;
        }
    }

    @Override
    public Boolean existInMuqavile(Boolean muqavile) {
        Optional<EmlakDto> optional = emlakRepository.findByMuqavile(muqavile);
        if (optional.equals(muqavile)) {
            System.out.println("There is a muqavile!");
            return true;
        } else {
            System.out.println("There is no muqavile");
            return false;
        }
    }


}

