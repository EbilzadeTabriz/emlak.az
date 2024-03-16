package TK.example.emlak.az.repository;

import TK.example.emlak.az.entity.GeneralCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface GeneralCategoryRepository extends JpaRepository<GeneralCategory,Long> {
   GeneralCategory findCategoryById(Long id);


}