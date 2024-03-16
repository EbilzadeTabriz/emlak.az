package TK.example.emlak.az.dto;

import TK.example.emlak.az.entity.Emlak;

import java.util.List;

public record EmlakTipiCatagoryDto(
        String menzil,
        String yeniTikili,
        String kohneTikili,
        String ofis,
        List<Emlak> emlaks
) {
}
