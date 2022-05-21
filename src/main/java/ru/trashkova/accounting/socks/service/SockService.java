package ru.trashkova.accounting.socks.service;

import ru.trashkova.accounting.socks.service.impl.Operation;

public interface SockService {

    /**
     * Регистрирует приход носков на склад
     */
    void incomeSocks(String color, int cottonPart, int quantity);

    /**
     * Регистрирует отпуск носков со склада
     */
    void outcomeSocks(String color, int cottonPart, int quantity);

    /**
     * Возвращает общее количество носков на складе, соответствующих переданным в параметрах критериям запроса
     */
    int getTotalQuantitySocks(String color, Operation operation, int countPart);

}