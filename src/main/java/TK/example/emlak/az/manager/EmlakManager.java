package TK.example.emlak.az.manager;

import TK.example.emlak.az.dto.EmlakDto;
import TK.example.emlak.az.entity.Emlak;
import TK.example.emlak.az.mapper.EmlakMapper;
import TK.example.emlak.az.repository.EmlakRepository;
import TK.example.emlak.az.service.EmlakService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.Collections;
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
    @Transactional
    public List<EmlakDto> getAll() {
        List<Emlak> emlakDtoList = emlakRepository.findAll();
        return emlakDtoList.stream().map(emlakMapper::toEmlakDto).collect(Collectors.toList());

    }

    @Override
    @Transactional
    public List<EmlakDto> sortByPriceHighToLow() {
        List<Emlak> emlakList = emlakRepository.findAll();
        Comparator<EmlakDto> priceComparator = Comparator.comparingDouble(EmlakDto::price).reversed();
        List<EmlakDto> sortedList = emlakList.stream().map(emlakMapper::toEmlakDto).sorted(priceComparator)
                .toList();
        return sortedList;
    }

    @Override
    @Transactional
    public List<EmlakDto> sortByPriceLowToHigh() {
        List<Emlak> emlakList = emlakRepository.findAll();
        Comparator<EmlakDto> priceComparator = Comparator.comparingDouble(EmlakDto::price);

        List<EmlakDto> sortedList = emlakList.stream().map(emlakMapper::toEmlakDto).sorted(priceComparator).toList();

        return sortedList;
    }

    @Override
    @Transactional
    public List<EmlakDto> getEmlaksFromSameLocation(String location) {
        List<Emlak> emlakOptional = emlakRepository.findByLocation(location);
        return emlakOptional.stream().map(emlakMapper::toEmlakDto).collect(Collectors.toList());
    }


    @Override
    @Transactional
    public List<EmlakDto> getByForSelling(String forSelling) {
        List<Emlak> findForSelling = emlakRepository.findAllByForSelling(forSelling);
        return findForSelling.stream().map(emlakMapper::toEmlakDto).collect(Collectors.toList());

    }

    @Override
    @Transactional
    public List<EmlakDto> getByForRent(String forRent) {
        List<Emlak> findForRent = emlakRepository.findAllByForRent(forRent);
        return findForRent.stream().map(emlakMapper::toEmlakDto).collect(Collectors.toList());

    }

    @Override
    @Transactional
    public List<EmlakDto> getEmlakById(Long id) {
        Optional<Emlak> findEmlak = emlakRepository.findById(id);
        if (findEmlak.isPresent()) {
            return findEmlak.stream().map(emlakMapper::toEmlakDto).collect(Collectors.toList());
        } else {
            throw new RuntimeException("Problem is inside  public List<EmlakDto> getEmlakById(Long id)  ");
        }
    }

    @Override
    @Transactional
    public List<EmlakDto> getByAreaBetweenMinAndMax(Double minArea,Double maxArea) {
        List<Emlak> findByArea = emlakRepository.findByAreaBetween(minArea,maxArea);
        return findByArea.stream().map(emlakMapper::toEmlakDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<EmlakDto> getByMertebe(Integer mertebe) {
        Optional<Emlak> findByFlat = emlakRepository.findByMertebe(mertebe);
        return findByFlat.stream().map(emlakMapper::toEmlakDto).collect(Collectors.toList());

    }

    @Override
    @Transactional
    public void deleteEmlakById(Long id) {
        emlakRepository.deleteById(id);

    }

    @Override
    @Transactional
    public void deleteAll() {
        emlakRepository.deleteAll();
    }

    @Override
    @Transactional
    public EmlakDto updateInfo(EmlakDto emlakDto, Long id) {
        Optional<Emlak> updates = emlakRepository.findById(id);
        if (updates.isPresent()) {
            Emlak existing = updates.get();
            existing.setInfo(emlakDto.info());
            existing.setLocation(emlakDto.location());
            existing.setMertebe(emlakDto.mertebe());
            existing.setArea(emlakDto.area());
            existing.setPrice(emlakDto.price());
            existing.setOtaqSayi(emlakDto.otaqSayi());
            existing.setForSelling(emlakDto.forSelling());
            existing.setForRent(emlakDto.forRent());
            emlakRepository.save(existing);
        }
        return emlakDto;
    }

    @Override
    @Transactional
    public void saveInfo(EmlakDto emlakDto) {
        emlakRepository.save(emlakMapper.toEmlak(emlakDto));


    }

    @Override
    @Transactional
    public Boolean availableInSelling(Long id) {
        Optional<Emlak> available = emlakRepository.findById(id);
        return available.isPresent();
    }

    @Override
    @Transactional
    public List<EmlakDto> getEmlakBetweenMinAndMax(Double minPrice, Double maxPrice) {

        Optional<Emlak> findBetweenMinAndMax = emlakRepository.findByPriceBetween(minPrice, maxPrice);
        if ((minPrice != null && minPrice != 0) && (maxPrice != null && maxPrice != 0)) {
            return findBetweenMinAndMax.stream().map(emlakMapper::toEmlakDto).collect(Collectors.toList());
        } else
            findBetweenMinAndMax.isEmpty();
        return null;
    }

    @Override
    @Transactional
    public List<EmlakDto> getByLocation(String location) {

        return null;
    }
}
