package TK.example.emlak.az.dto;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class UserDto {
        Long id;
        @NotEmpty(message = "Tam adi boş buraxa bilmərsiniz!")
        String fullName;
        @NotEmpty(message = "Nömrə əlavə edin!")
        String number;
        @NotEmpty(message = "Email əlavə edin!")
        @NotBlank(message = "Email də boşluq olmamalidir!")
        @Size(max = 20, min = 18)
        @Email(message = " Email @gmail.com ilə bitməlidir!")
        String email;
        @NotEmpty(message = "Password əlavə edin!")
        @NotBlank(message = "Boşluq olmamalidir!")
        @Size(min = 8, max = 12)
        String password;
}

