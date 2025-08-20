package kaluska.michal.Witcher_Bestiary.security.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // scope set to runtime so it's visible/accessible on runtime
@Target({ElementType.FIELD, ElementType.PARAMETER}) // I want it used on field or on methods parameters
@Constraint(validatedBy = PasswordValidator.class) // which class is going to take care of validation
public @interface ValidPassword {
    String message() default "{password.invalid}"; // default message to be shown when password is invalid

    Class<?>[] groups() default {}; // could be used if I want to have different sets of validation rules - I won't use it

    Class<? extends Payload>[] payload() default {}; // some additional metadata - I won't use it
}
