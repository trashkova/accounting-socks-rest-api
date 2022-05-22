package ru.trashkova.accounting.socks.controller;

import io.swagger.annotations.Api;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ru.trashkova.accounting.socks.dto.ErrorDetailResponse;
import ru.trashkova.accounting.socks.dto.SockGetTotalQuantityOperationRequest;
import ru.trashkova.accounting.socks.dto.SockIncomeAndOutcomeRequest;
import ru.trashkova.accounting.socks.dto.SockTotalQuantityResponse;
import ru.trashkova.accounting.socks.service.SockService;
import ru.trashkova.accounting.socks.service.impl.Operation;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/socks")
@AllArgsConstructor
@Api(tags = "Учет носков на складе")
public class SockController {

    private final SockService service;

    @ApiOperation("Регистрация приема носков на склад")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Удалось добавить приход"),
            @ApiResponse(code = 400, message = "Параметры запроса отсутствуют или имеют некорректный формат", response = ErrorDetailResponse.class),
            @ApiResponse(code = 500, message = "Произошла ошибка, не зависящая от вызывающей стороны")
    })
    @PostMapping(value = "/income", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public void incomeSock(@Valid SockIncomeAndOutcomeRequest request) {
        service.incomeSocks(
                request.color,
                request.cottonPart,
                request.quantity);
    }

    @ApiOperation("Регистрация отпуска носков со склада")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Удалось добавить приход"),
            @ApiResponse(code = 400, message = "Параметры запроса отсутствуют или имеют некорректный формат", response = ErrorDetailResponse.class),
            @ApiResponse(code = 500, message = "Произошла ошибка, не зависящая от вызывающей стороны")
    })
    @PostMapping(value = "/outcome", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public void outcomeSock(@Valid SockIncomeAndOutcomeRequest request) {
        service.outcomeSocks(
                request.color,
                request.cottonPart,
                request.quantity);
    }

    @ApiOperation("Получение общего количества носков на складе, соответствующих критериям поиска")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Запрос выполнен"),
            @ApiResponse(code = 400, message = "Параметры запроса отсутствуют или имеют некорректный формат", response = ErrorDetailResponse.class),
            @ApiResponse(code = 500, message = "Произошла ошибка, не зависящая от вызывающей стороны")
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SockTotalQuantityResponse> getTotalQuantitySocks(@Valid SockGetTotalQuantityOperationRequest request) {
        int totalQuantity = service.getTotalQuantitySocks(
                request.color,
                Operation.getOperationByValue(request.operation),
                request.cottonPart);

        return ResponseEntity.ok(new SockTotalQuantityResponse(totalQuantity));
    }

}