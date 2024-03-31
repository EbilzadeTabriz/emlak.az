package TK.example.emlak.az.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "emlak")
public class Emlak {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long emlakId;
    @Column(nullable = true)

    Double price;

    @Column(nullable = true)
    Boolean available;
    @Column(nullable = true)
    String tipi;
    @Column(nullable = true)

    String info;
    @Column(nullable = true)

    String location;
    @Column(nullable = true)

    Boolean cixaris;
    @Column(nullable = true)
    Boolean muqavile;
    @Column(nullable = true)
    Double area;
    @Column(nullable = true)

    Integer mertebe;
    @Column(nullable = true)

    Integer otaqSayi;
    @Column(nullable = true)
    String forRent;
    @Column(nullable = true)
    String forSelling;

    @OneToMany(mappedBy = "emlak", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OtaqSayiCatagory> otaqSayiCatagory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emlak_tipi_id")
    private EmlakTipiCatagory emlakTipiCatagory;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "generalCategory_id")
    private GeneralCategory generalCategory;

}