package TK.example.emlak.az.manager;

import TK.example.emlak.az.dto.EmlakTipiCatagoryDto;
import TK.example.emlak.az.entity.EmlakTipiCatagory;
import TK.example.emlak.az.mapper.EmlakTipiCatagoryMapper;
import TK.example.emlak.az.repository.EmlakTipicatagoryRepository;
import TK.example.emlak.az.service.EmlakTipiCatagoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class EmlakTipiCatagoryManager implements EmlakTipiCatagoryService {
    private final EmlakTipicatagoryRepository emlakTipicatagoryRepository;
    private final EmlakTipiCatagoryMapper emlakTipiCatagoryMapper;

    @Override
    public List<EmlakTipiCatagoryDto> getAll() {
        List<EmlakTipiCatagory> emlakTipiCatagories = emlakTipicatagoryRepository.findAll();
        return emlakTipiCatagories.stream().map(emlakTipiCatagoryMapper::toEmlakTipiCatagoryDto).collect(Collectors.toList());
    }

    @Override
    public void deleteCategoryId(Long id) {
        emlakTipicatagoryRepository.deleteById(id);
    }

    @Override
    public List<EmlakTipiCatagoryDto> update(Long id, EmlakTipiCatagoryDto emlakTipiCatagoryDto) {
        Optional<EmlakTipiCatagory> emlakTipiCatagories = emlakTipicatagoryRepository.findById(id);
        if (!(emlakTipiCatagories.isEmpty())) {
            EmlakTipiCatagory emlakTipiCatagory = emlakTipiCatagories.get();
            return Collections.singletonList(emlakTipiCatagoryMapper.toEmlakTipiCatagoryDto(emlakTipiCatagory));

        } else {
            return null;
        }
    }

    @Override
    public EmlakTipiCatagory save(EmlakTipiCatagoryDto emlakTipiCatagoryDto) {
        EmlakTipiCatagory emlakTipiCatagoryDto1 = emlakTipiCatagoryMapper.toEmlakTipiCatagory(emlakTipiCatagoryDto);
        return  emlakTipicatagoryRepository.save(emlakTipiCatagoryDto1);


    }
}
