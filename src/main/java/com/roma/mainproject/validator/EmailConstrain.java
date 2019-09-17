package com.roma.mainproject.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EmailValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailConstrain {
    String message() default "Invalid Email, your must have <@> or <.>";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
