package ru.trashkova.accounting.socks.exception;

public class IncorrectComparisonOperatorException extends RuntimeException {

    public IncorrectComparisonOperatorException() {
        super("Неподдерживаемый оператор сравнения количества хлопка в составе носков");
    }

}