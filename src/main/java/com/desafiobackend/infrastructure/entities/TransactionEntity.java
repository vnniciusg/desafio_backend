package com.desafiobackend.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name= "tb_transactions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "amount")
    private BigDecimal amount;
    @ManyToOne
    @JoinColumn(name="payer_id")
    private UserEntity payer;
    @ManyToOne
    @JoinColumn(name="payee_id")
    private UserEntity payee;
    @Column(name = "local_date_time")
    private LocalDateTime localDateTime;
}
