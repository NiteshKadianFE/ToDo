package com.fareyetodo.todo.validation;

import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target( {ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
//@Constraint(validatedBy = DupVal.class)
public @interface Duplicates {
    public String message() default "Same Title already exists";
    //represents group of constraints
    public Class<?>[] groups() default {};
    //represents additional information about annotation
    public Class<? extends Payload>[] payload() default {};
}