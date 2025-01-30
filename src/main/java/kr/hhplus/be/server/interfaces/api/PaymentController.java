package kr.hhplus.be.server.interfaces.api;

import kr.hhplus.be.server.interfaces.dto.payment.PaymentResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    // todo 결제 추가
    @PostMapping("/pay")
    public ResponseEntity<?> pay() {
        return ResponseEntity.ok().body(
                PaymentResponse.Info.builder().paymentId(1L).paymentAmount(15000).status("SUCCESS").build()
        );
    }

}
