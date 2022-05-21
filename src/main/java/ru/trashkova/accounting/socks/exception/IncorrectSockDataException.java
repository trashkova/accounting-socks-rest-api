package ru.trashkova.accounting.socks.exception;

public class IncorrectSockDataException extends RuntimeException {

    public IncorrectSockDataException() {
        super("Носки не найдены");
    }

    public IncorrectSockDataException(int quantity) {
        super(String.format("Недостаточное количество носков для списания. Допустимое количество - %d", quantity));
    }

}