package ru.trashkova.accounting.socks.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@ApiModel("Запрос на приход и отпуск носков на складе")
public class SockIncomeAndOutcomeRequest {

    @NotBlank(message = "Цвет носков должен быть заполнен")
    @NotNull(message = "Цвет носков должен быть заполнен")
    @ApiModelProperty("Цвет носков")
    public String color;

    @Min(value = 0, message = "Процентное содержание хлопка в составе носков должно быть целое число от 0 до 100")
    @Max(value = 100, message = "Процентное содержание хлопка в составе носков должно быть целое число от 0 до 100")
    @ApiModelProperty("Процентное содержание хлопка в составе носков")
    public int cottonPart;

    @Min(value = 1, message = "Количество пар носков должно быть целое число больше 0")
    @ApiModelProperty("Процентное содержание хлопка в составе носков")
    public int quantity;

}