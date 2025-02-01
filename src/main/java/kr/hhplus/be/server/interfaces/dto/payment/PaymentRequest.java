package kr.hhplus.be.server.interfaces.dto.payment;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PaymentRequest {

    @Getter
    @Builder
    @Schema(name = "PaymentRequest.Payment", description = "결제 요청 객체")
    public static class Payment {
        @Schema(description = "사용자 ID", example = "1")
        private Long userId;

        @Schema(description = "주문 ID", example = "1")
        private Long orderId;

        @Schema(description = "결제금액", example = "15000")
        private int paymentAmount;

        @Schema(description = "생성일", example = "2025-01-01 00:00:00")
        private LocalDateTime createdAt;

        @Schema(description = "수정일", example = "2025-01-01 00:00:00")
        private LocalDateTime updatedAt;
    }

}
