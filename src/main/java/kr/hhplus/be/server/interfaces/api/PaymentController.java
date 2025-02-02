package kr.hhplus.be.server.interfaces.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.hhplus.be.server.interfaces.dto.payment.PaymentRequest;
import kr.hhplus.be.server.interfaces.dto.payment.PaymentResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payments")
@Tag(name = "payment", description = "결제 관련 API")
public class PaymentController {

    // todo 결제 추가
    @PostMapping
    @Operation(summary = "결제", description = "특정 주문의 결제 추가")
    public ResponseEntity<?> pay(
            @RequestBody PaymentRequest.Pay request
    ) {
        return ResponseEntity.ok().body(
                PaymentResponse.Info.builder().paymentId(1L).status("SUCCESS").build()
        );
    }

}
