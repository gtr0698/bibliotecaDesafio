package com.teste.novo.bibliotecaDesafio.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidadorEmailDuplicadoAutor.class)
public @interface VerificaEmailDuplicadoAutor {

    String message() default "Já existe um autor com esse email cadastrado";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
