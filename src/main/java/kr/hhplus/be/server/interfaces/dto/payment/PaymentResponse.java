package kr.hhplus.be.server.interfaces.dto.payment;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PaymentResponse {

    @Getter
    @Builder
    public static class Info {
        private Long paymentId;
        private int paymentAmount;
        private String status;
    }

}
