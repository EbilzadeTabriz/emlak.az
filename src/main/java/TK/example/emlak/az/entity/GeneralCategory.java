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
@Table(name = "General_Category")
//silinecek bunlar
public class GeneralCategory {


        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id
        Long id;
        @Column(nullable = false)
        String name;
        @OneToMany(mappedBy = "generalCategory",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
        private List<Emlak> emlak = new ArrayList<>();


    }
