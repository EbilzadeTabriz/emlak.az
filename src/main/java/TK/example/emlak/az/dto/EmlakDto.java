package TK.example.emlak.az.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record EmlakDto(
        @NotNull(message = "Should not be null")
        Double price,

        Boolean available,
        @NotEmpty(message = "should be entered")
        String emlakTipi,
        @NotEmpty(message = "should be entered")
        String info,
        @NotEmpty(message = "should be entered")
        String location,
        @NotEmpty(message = "should be entered")
        String approvedDocument,
        @NotNull(message = "should not be null")
        Double area,
        @NotNull(message = "should not be null")
        Integer mertebe,
        @NotNull(message = "should not be null")
        Integer otaqSayi,
        @NotEmpty(message = "should be entered")
        String forRent,
        @NotEmpty(message = "should be entered")
        String forSelling,
        @NotEmpty(message = "should be entered")
        String emlakDurumu

) {
}
