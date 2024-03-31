package TK.example.emlak.az.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "Rooms")

//silinecek bunlar
public class OtaqSayiCatagory {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;
    @Column(nullable = true)
    Long birOtaqli;
    @Column(nullable = true)

    Long ikiOtaqli;
    @Column(nullable = true)

    Long ucOtaqli;
    @Column(nullable = true)

    Long dordOtaqli;
    @Column(nullable = true)

    Long besVeDahaCox;
    @ManyToOne(cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
    @JoinColumn(name = "emlak_id")
    private Emlak emlak;
}
