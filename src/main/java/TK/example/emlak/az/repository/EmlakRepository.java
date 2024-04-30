package TK.example.emlak.az.repository;

import TK.example.emlak.az.dto.EmlakDto;
import TK.example.emlak.az.entity.Emlak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmlakRepository extends JpaRepository<Emlak, Long> {

    @Query("SELECT e FROM Emlak e WHERE e.mertebe = :mertebe")
    List<Emlak> findByMertebe(Integer mertebe);

    @Query("SELECT e FROM Emlak e WHERE e.price >= :minPrice AND e.price <= :maxPrice")
    List<Emlak> findByPriceBetween(@Param("minPrice") Double minPrice, @Param("maxPrice") Double maxPrice);

    @Query("SELECT e FROM Emlak e WHERE e.location = :location")
    List<Emlak> findByLocation(String location);

    @Query("SELECT e FROM Emlak e WHERE lower(e.forSelling)= lower(:forSelling)")
    List<Emlak> findAllByForSelling(String forSelling);

    @Query("SELECT e FROM Emlak e WHERE lower(forRent) = lower(:forRent)")
    List<Emlak> findAllByForRent(String forRent);

    @Query("SELECT e FROM Emlak e WHERE e.area BETWEEN :minArea AND :maxArea")
    List<Emlak> findByAreaBetween(Double minArea,Double maxArea);

    @Query("SELECT  count(e)  FROM Emlak e ")
    Long countOfEmlak(Long total);


}
