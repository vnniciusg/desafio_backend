package com.desafiobackend.domain.entities;

import com.desafiobackend.domain.entities.user.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {

    private Long id;
    private BigDecimal value;
    private User payer;
    private User payee;
    private LocalDateTime localDateTime;

    public Transaction() {
    }
    public Transaction(Long id, BigDecimal value, User payer, User payee, LocalDateTime localDateTime) {
        this.id = id;
        this.value = value;
        this.payer = payer;
        this.payee = payee;
        this.localDateTime = localDateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public User getPayer() {
        return payer;
    }

    public void setPayer(User payer) {
        this.payer = payer;
    }

    public User getPayee() {
        return payee;
    }

    public void setPayee(User payee) {
        this.payee = payee;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
