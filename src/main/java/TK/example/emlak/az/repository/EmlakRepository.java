package TK.example.emlak.az.repository;

import TK.example.emlak.az.dto.EmlakDto;
import TK.example.emlak.az.entity.Emlak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmlakRepository extends JpaRepository<Emlak, Long> {

    Optional<Emlak> findByMertebe(Integer mertebe);

    List<Emlak> findByPriceBetween(Double minPrice, Double maxPrice);

    Optional<Emlak> findByLocation(String location);
//    Optional<Emlak> findAllByLocationInOrderByLocation(List<String> location);

    Optional<EmlakDto> findByCixaris(Boolean cixaris);

    Optional<EmlakDto> findByMuqavile(Boolean muqavile);
    Optional<Emlak> findByAreaGreaterThanEqualOrderByAreaAsc(Double area);
    Optional<Emlak> findByForSelling(String forSelling);
    Optional<Emlak> findByForRent(String forRent);

}
