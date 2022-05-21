package ru.trashkova.accounting.socks.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.trashkova.accounting.socks.entity.Sock;
import ru.trashkova.accounting.socks.exception.IncorrectComparisonOperatorException;
import ru.trashkova.accounting.socks.exception.IncorrectSockDataException;
import ru.trashkova.accounting.socks.repository.SockRepository;
import ru.trashkova.accounting.socks.service.SockService;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class SockServiceImpl implements SockService {

    private final SockRepository repository;

    @Override
    @Transactional
    public void incomeSocks(String color, int cottonPart, int quantity) {
        repository.findByColorAndCottonPart(color, cottonPart).ifPresentOrElse(
                sock -> {
                    sock.setQuantity(sock.getQuantity() + quantity);
                    repository.save(sock);
                }
                ,
                () -> repository.save(new Sock(color, cottonPart, quantity)));
    }

    @Override
    @Transactional
    public void outcomeSocks(String color, int cottonPart, int quantity) {
        Sock sockInRepository = repository
                .findByColorAndCottonPart(color, cottonPart)
                .orElseThrow(IncorrectSockDataException::new);

        int newQuantity = sockInRepository.getQuantity() - quantity;
        if (newQuantity < 0) {
            throw new IncorrectSockDataException(sockInRepository.getQuantity());
        } else if (newQuantity == 0) {
            repository.delete(sockInRepository);
        } else {
            sockInRepository.setQuantity(newQuantity);
            repository.save(sockInRepository);
        }
    }

    @Override
    public int getTotalQuantitySocks(String color, Operation operation, int cottonPart) {
        int totalQuantity;
        switch (operation) {
            case MORE_THAN:
                totalQuantity = repository.findTotalQuantityByColorAndCottonPartMoreThan(color, cottonPart);
                break;
            case LESS_THAN:
                totalQuantity = repository.findTotalQuantityByColorAndCottonPartLessThan(color, cottonPart);
                break;
            case EQUALS:
                totalQuantity = repository.findTotalQuantityByColorAndCottonPartEquals(color, cottonPart);
                break;
            default:
                throw new IncorrectComparisonOperatorException();
        }
        return totalQuantity;
    }

}