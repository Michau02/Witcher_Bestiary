package kaluska.michal.Witcher_Bestiary.security.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import kaluska.michal.Witcher_Bestiary.security.validation.PasswordMatches;
import kaluska.michal.Witcher_Bestiary.security.validation.ValidPassword;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@PasswordMatches
public class RegistrationRequest {
    @NotBlank
    @Size(min = 4, max = 20)
    private String username;

    @ValidPassword
    private String password;

    @NotBlank
    private String confirmPassword;

    @Email
    @NotBlank
    private String email;

    @Override
    public String toString() {
        return username + " " + password + " " + confirmPassword + " " + email;
    }
}
