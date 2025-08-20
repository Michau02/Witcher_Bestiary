package kaluska.michal.Witcher_Bestiary.security.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Objects;
import java.util.regex.Pattern;

public class PasswordValidator implements ConstraintValidator<ValidPassword, String> {
    private static final Pattern UPPERCASE_PATTERN = Pattern.compile("[A-Z]");
    private static final Pattern DIGIT_PATTERN = Pattern.compile("[0-9]");
    private static final Pattern SPECIAL_PATTERN = Pattern.compile("[!@#$%^&*()_+=\\-/?>.<,}{\\[|]");

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        if (Objects.isNull(password)) return false;
        boolean valid = true;
        context.disableDefaultConstraintViolation();

        if (password.length() < 8) {
            context.buildConstraintViolationWithTemplate("{password.tooShort}").addConstraintViolation();
            valid = false;
        }
        if (!UPPERCASE_PATTERN.matcher(password).find()) {
            context.buildConstraintViolationWithTemplate("{password.noUppercase}").addConstraintViolation();
            valid = false;
        }
        if (!DIGIT_PATTERN.matcher(password).find()) {
            context.buildConstraintViolationWithTemplate("{password.noDigit}").addConstraintViolation();
            valid = false;
        }
        if (!SPECIAL_PATTERN.matcher(password).find()) {
            context.buildConstraintViolationWithTemplate("{password.noSpecial}").addConstraintViolation();
            valid = false;
        }

        return valid;
    }
}
