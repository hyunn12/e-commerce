package kr.hhplus.be.server.interfaces.dto.payment;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PaymentResponse {

    @Getter
    @Builder
    @Schema(name = "PaymentResponse.Info", description = "결제 조회 결과 객체")
    public static class Info {
        @Schema(description = "결제 ID", example = "1")
        private Long paymentId;

        @Schema(description = "결제금액", example = "15000")
        private int paymentAmount;

        @Schema(description = "결제상태", example = "SUCCESS")
        private String status;
    }

}
