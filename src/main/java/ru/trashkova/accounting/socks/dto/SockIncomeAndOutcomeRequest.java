package ru.trashkova.accounting.socks.dto;

import lombok.AllArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
public class SockIncomeAndOutcomeRequest {

    @NotBlank(message = "Цвет носков должен быть заполнен")
    @NotNull(message = "Цвет носков должен быть заполнен")
    public String color;

    @Min(value = 0, message = "Процентное содержание хлопка в составе носков должно быть целое число от 0 до 100")
    @Max(value = 100, message = "Процентное содержание хлопка в составе носков должно быть целое число от 0 до 100")
    public int cottonPart;

    @Min(value = 1, message = "Количество пар носков должно быть целое число больше 0")
    public int quantity;

}