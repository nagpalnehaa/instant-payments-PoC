package com.poc.pps.controller;

import com.poc.pps.service.PaymentService;
import com.poc.common.model.PaymentRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping(consumes = {"application/json", "application/xml"})
    @Operation(summary = "Submit a payment")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "201", description = "Payment request accepted"),
    @ApiResponse(responseCode = "400", description = "Bad request due to invalid input"),
    @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<?> submitPayment(@Valid @RequestBody PaymentRequest request) {
        paymentService.process(request);
        return ResponseEntity.ok("Payment received and routed for fraud check");
    }
}
