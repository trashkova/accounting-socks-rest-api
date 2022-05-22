package ru.trashkova.accounting.socks.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;

import ru.trashkova.accounting.socks.dto.validation.SockOperation;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@ApiModel("Запрос на получение общего количества пар носков в соответствии критериям поиска")
public class SockGetTotalQuantityOperationRequest {

    @NotBlank(message = "Цвет носков должен быть заполнен")
    @NotNull(message = "Цвет носков должен быть заполнен")
    @ApiModelProperty("Цвет носков")
    public String color;


    @NotBlank(message = "Оператор сравнения значения количества хлопка в составе носков должен быть заполнен")
    @NotNull(message = "Оператор сравнения значения количества хлопка в составе носков должен быть заполнен")
    @SockOperation
    @ApiModelProperty("Оператор сравнения значения количества хлопка в составе носков")
    public String operation;

    @Min(value = 0, message = "Процентное содержание хлопка в составе носков должно быть целое число от 0 до 100")
    @Max(value = 100, message = "Процентное содержание хлопка в составе носков должно быть целое число от 0 до 100")
    @ApiModelProperty("Процентное содержание хлопка в составе носков")
    public int cottonPart;

}