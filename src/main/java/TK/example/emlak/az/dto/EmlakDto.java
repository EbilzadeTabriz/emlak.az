package TK.example.emlak.az.dto;

public record EmlakDto(
        Double price,

        Boolean available,
        String emlakTipi,
        String info,

        String location,
        String approvedDocument,
        Double area,

        Integer mertebe,

        Integer otaqSayi,
        String forRent,
        String forSelling,


        String emlakDurumu

        ) {
}
