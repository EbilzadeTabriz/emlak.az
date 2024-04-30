package TK.example.emlak.az.dto;

import java.util.List;

public record EmlakPageResponse(
        List<EmlakDto> emlaks,
        Long totalElements,
        Integer totalPage,
        boolean hasNextPage
) {
}
