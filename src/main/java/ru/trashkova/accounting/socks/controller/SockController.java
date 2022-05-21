package ru.trashkova.accounting.socks.controller;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ru.trashkova.accounting.socks.dto.SockGetTotalQuantityOperationRequest;
import ru.trashkova.accounting.socks.dto.SockIncomeAndOutcomeRequest;
import ru.trashkova.accounting.socks.dto.SockTotalQuantityResponse;
import ru.trashkova.accounting.socks.service.SockService;
import ru.trashkova.accounting.socks.service.impl.Operation;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/socks")
@AllArgsConstructor
public class SockController {

    private final SockService service;

    @PostMapping(value = "/income", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public void incomeSock(@Valid SockIncomeAndOutcomeRequest request) {
        service.incomeSocks(
                request.color,
                request.cottonPart,
                request.quantity);
    }

    @PostMapping(value = "/outcome", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public void outcomeSock(@Valid SockIncomeAndOutcomeRequest request) {
        service.outcomeSocks(
                request.color,
                request.cottonPart,
                request.quantity);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SockTotalQuantityResponse> getTotalQuantitySocks(@Valid SockGetTotalQuantityOperationRequest request) {
        int totalQuantity = service.getTotalQuantitySocks(
                request.color,
                Operation.getOperationByValue(request.operation),
                request.cottonPart);

        return ResponseEntity.ok(new SockTotalQuantityResponse(totalQuantity));
    }

}