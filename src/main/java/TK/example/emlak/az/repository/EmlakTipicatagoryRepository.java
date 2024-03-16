package TK.example.emlak.az.repository;

import TK.example.emlak.az.entity.EmlakTipiCatagory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmlakTipicatagoryRepository extends JpaRepository<EmlakTipiCatagory,Long> {

}
