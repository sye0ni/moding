package com.ssafy.payment.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PaymentsFailure {
    private String code;
    private String message;
}
