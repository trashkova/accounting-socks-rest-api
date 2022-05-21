package ru.trashkova.accounting.socks.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "socks")
@IdClass(SockKey.class)
public class Sock {

    @Id
    @Column(name = "color", nullable = false)
    private String color;

    @Id
    @Column(name = "cotton_part", nullable = false)
    private int cottonPart;

    @Column(name = "quantity", nullable = false)
    private int quantity;

}