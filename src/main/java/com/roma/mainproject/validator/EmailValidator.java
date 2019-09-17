package com.roma.mainproject.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<EmailConstrain,String> {
    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return email.length()>3&&email.contains("@")&&email.contains(".");
    }

    @Override
    public void initialize(EmailConstrain constraintAnnotation) {

    }
}
