package TK.example.emlak.az.repository;

import TK.example.emlak.az.entity.Emlak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmlakRepository extends JpaRepository<Emlak, Long> {

    Optional<Emlak> findByMertebe(Integer mertebe);

    Optional<Emlak> findByPriceBetween(Double minPrice, Double maxPrice);

    @Query("SELECT e FROM Emlak e WHERE e.location = :location")
    List<Emlak> findByLocation(String location);

    @Query("SELECT e FROM Emlak e WHERE lower(e.forSelling)= lower(:forSelling)")
    List<Emlak> findAllByForSelling(String forSelling);

    @Query("SELECT e FROM Emlak e WHERE lower(forRent) = lower(:forRent)")
    List<Emlak> findAllByForRent(String forRent);

    @Query("SELECT e FROM Emlak e WHERE e.area BETWEEN :minArea AND :maxArea")
    List<Emlak> findByAreaBetween(Double minArea,Double maxArea);
}
