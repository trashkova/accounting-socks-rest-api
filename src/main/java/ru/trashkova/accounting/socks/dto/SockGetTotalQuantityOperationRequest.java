package ru.trashkova.accounting.socks.dto;

import lombok.AllArgsConstructor;

import ru.trashkova.accounting.socks.dto.validation.SockOperation;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
public class SockGetTotalQuantityOperationRequest {

    @NotBlank(message = "Цвет носков должен быть заполнен")
    @NotNull(message = "Цвет носков должен быть заполнен")
    public String color;


    @NotBlank(message = "Оператор сравнения значения количества хлопка в составе носков должен быть заполнен")
    @NotNull(message = "Оператор сравнения значения количества хлопка в составе носков должен быть заполнен")
    @SockOperation
    public String operation;

    @Min(value = 0, message = "Процентное содержание хлопка в составе носков должно быть целое число от 0 до 100")
    @Max(value = 100, message = "Процентное содержание хлопка в составе носков должно быть целое число от 0 до 100")
    public int cottonPart;

}