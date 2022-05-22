package ru.trashkova.accounting.socks.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@ApiModel("Ответ о получении общего количества пар носков в соответствии критериям поиска")
public class SockTotalQuantityResponse {

    @ApiModelProperty("Общее количество пар носков")
    public int quantity;

}