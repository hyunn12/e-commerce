package kr.hhplus.be.server.interfaces.dto.payment;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PaymentRequest {

    @Getter
    @Builder
    public static class Payment {
        private Long userId;
        private Long orderId;
        private int paymentAmount;
    }

}
