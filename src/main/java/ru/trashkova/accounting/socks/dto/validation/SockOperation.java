package ru.trashkova.accounting.socks.dto.validation;

import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SockOperationValidator.class)
public @interface SockOperation {

    String message()  default "Неподдерживаемый оператор сравнения значения количества хлопка в составе носков";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };

}