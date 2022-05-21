package ru.trashkova.accounting.socks.dto.validation;

import ru.trashkova.accounting.socks.service.impl.Operation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SockOperationValidator implements ConstraintValidator<SockOperation, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return Operation.isValid(s);
    }

}
