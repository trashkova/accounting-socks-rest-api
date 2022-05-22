package ru.trashkova.accounting.socks.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@ApiModel("Детали ошибки ответа")
public class ErrorDetailResponse {

    @ApiModelProperty("Информация об ошибке")
    public String message;

}