package TK.example.emlak.az.dto;


public record EmlakDto(
        Double price,
        String tipi,
        String info,
        String forRent,
        String forSelling,
        Boolean cixaris,
        Boolean muqavile,
        String location,
        Double area,
        Integer mertebe,
        Integer otaqSayi
) {
}
