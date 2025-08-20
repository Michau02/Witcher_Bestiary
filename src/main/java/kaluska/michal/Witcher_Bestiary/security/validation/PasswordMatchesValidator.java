package kaluska.michal.Witcher_Bestiary.security.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import kaluska.michal.Witcher_Bestiary.security.dto.RegistrationRequest;

import java.util.Objects;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, RegistrationRequest> {

    @Override
    public boolean isValid(RegistrationRequest request, ConstraintValidatorContext constraintValidatorContext) {
        if (Objects.isNull(request)) return false;

        if (!request.getPassword().equals(request.getConfirmPassword())) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate("{password.noMatch}").addConstraintViolation();
            return false;
        }

        return true;
    }
}
