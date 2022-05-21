package ru.trashkova.accounting.socks.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ru.trashkova.accounting.socks.entity.Sock;
import ru.trashkova.accounting.socks.entity.SockKey;

import java.util.Optional;

@Repository
public interface SockRepository extends CrudRepository<Sock, SockKey> {

    /**
     * Возвращает найденную пару носков по цвету и составу хлопка
     */
    Optional<Sock> findByColorAndCottonPart(String color, int cottonPart);

    /**
     * Возвращает общее количество пар носков по цвету, у которых процент хлопка более чем в запросе
     */
    @Query("select coalesce(sum(quantity), 0) from Sock where color = :color and cottonPart > :cottonPart")
    int findTotalQuantityByColorAndCottonPartMoreThan(String color, int cottonPart);

    /**
     * Возвращает общее количество пар носков по цвету, у которых процент хлопка менее чем в запросе
     */
    @Query("select coalesce(sum(quantity), 0) from Sock where color = :color and cottonPart < :cottonPart")
    int findTotalQuantityByColorAndCottonPartLessThan(String color, int cottonPart);

    /**
     * Возвращает общее количество пар носков по цвету, у которых процент хлопка совпадает с кол-ом в запросе
     */
    @Query("select coalesce(sum(quantity), 0) from Sock where color = :color and cottonPart = :cottonPart")
    int findTotalQuantityByColorAndCottonPartEquals(String color, int cottonPart);

}