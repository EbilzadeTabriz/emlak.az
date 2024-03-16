package TK.example.emlak.az.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "User")
public class User {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id

    Long id;
    @Column(nullable = true)
    String fullName;
    @Column(nullable = true,unique = true)
    String number;
    @Column(nullable = false,unique = true)
    String email;
    @Column(nullable = true,unique = true)
    String password;

    @ElementCollection(targetClass = Role.class,fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_role",joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role",nullable = false)
    private Set<Role> roles = new HashSet<>();


}
