package ru.trashkova.accounting.socks.service.impl;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Оператор сравнения значения количества хлопка в составе носков
 */
public enum Operation {

    MORE_THAN("moreThan"),
    LESS_THAN("lessThan"),
    EQUALS("equals");


    private final String value;

    Operation(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Operation getOperationByValue(String val) {
        return Optional.ofNullable(VALUES.get(val)).orElseThrow();
    }

    public static boolean isValid(String val) {
        return Arrays
                .stream(Operation.values())
                .anyMatch((operation -> operation.getValue().equals(val)));
    }

    public static final Map<String, Operation> VALUES = Arrays.stream(Operation.values())
            .collect(Collectors.toMap(Operation::getValue, v -> v));

}