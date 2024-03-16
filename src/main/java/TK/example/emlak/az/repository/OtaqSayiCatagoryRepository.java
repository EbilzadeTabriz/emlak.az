package TK.example.emlak.az.repository;

import TK.example.emlak.az.dto.OtaqSayiCatagoryDto;
import TK.example.emlak.az.entity.OtaqSayiCatagory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OtaqSayiCatagoryRepository extends JpaRepository<OtaqSayiCatagory,Long> {
}
