package com.ssafy.payment.controller;

import com.ssafy.payment.dto.request.ConfirmPaymentsRequest;
import com.ssafy.payment.dto.request.RefundOrderRequest;
import com.ssafy.payment.service.MockService;
import com.ssafy.payment.service.PaymentService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;
    private final MockService mockservice;

    //    @PostMapping
    //    @Operation(summary = "백엔드 내부에서 토스페이먼츠 결제 승인 API 호출")
    //    public ResponseEntity<?> callConfirmAPI(
    //            @RequestBody ConfirmPaymentsRequest confirmPaymentsRequest) {
    //        //paymentsConfirmClient.execute(confirmPaymentsRequest);
    //        testService.call(confirmPaymentsRequest);
    //        return ResponseEntity.ok().build();
    //    }

    @PostMapping("/confirm")
    @Operation(summary = "백엔드 내부에서 토스페이먼츠 결제 승인 API 호출")
    public ResponseEntity<?> callConfirmAPI(
            @RequestBody ConfirmPaymentsRequest confirmPaymentsRequest) {
        paymentService.callTossPayConfirm(confirmPaymentsRequest);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/test/confirm")
    @Operation(summary = "[성능 테스트용] 백엔드 내부에서 Mock 토스페이먼츠 결제 승인 API 호출")
    public ResponseEntity<?> callTestConfirmAPI(
            @RequestBody ConfirmPaymentsRequest confirmPaymentsRequest) {
        mockservice.confirmPayment(confirmPaymentsRequest);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/refund")
    public ResponseEntity<?> callRefundAPI(@RequestBody RefundOrderRequest refundOrderRequest) {
        paymentService.callTossPayRefund(refundOrderRequest);
        return ResponseEntity.ok().build();
    }
}
