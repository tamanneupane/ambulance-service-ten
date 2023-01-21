package com.aggregrator.ambulanceservice.validations;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collection;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotEmptyFieldsValidator.class)
public @interface NotEmptyCollection {

    String message() default "List cannot contain empty fields";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}


class NotEmptyFieldsValidator implements ConstraintValidator<NotEmptyCollection, Collection<Object>> {

    @Override
    public void initialize(NotEmptyCollection notEmptyFields) {}

    @Override
    public boolean isValid(Collection<Object> objects, ConstraintValidatorContext context) {
        return !objects.isEmpty();
    }

}