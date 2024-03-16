package TK.example.emlak.az.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "EmlakKatagoriyasi")
public class EmlakTipiCatagory {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    Long emlakTipiID;

    @Column(nullable = true)
    String menzil;
    @Column(nullable = true)

    String yeniTikili;
    @Column(nullable = true)

    String kohneTikili;
    @Column(nullable = true)

    String ofis;

    @OneToMany(mappedBy = "emlakTipiCatagory",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Emlak> emlaks = new ArrayList<>();

}
