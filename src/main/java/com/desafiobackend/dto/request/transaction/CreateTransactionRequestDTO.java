package com.desafiobackend.dto.request.transaction;

import java.math.BigDecimal;

public record CreateTransactionRequestDTO(BigDecimal value, Long payer , Long payee) {
}
