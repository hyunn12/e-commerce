package kr.hhplus.be.server.interfaces.dto.coupon;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CouponResponse {

    @Getter
    @Builder
    @Schema(name = "CouponResponse.Info", description = "쿠폰 조회 결과 객체")
    public static class Info {
        @Schema(description = "쿠폰 ID", example = "1")
        private Long couponId;

        @Schema(description = "쿠폰명", example = "Test Coupon A")
        private String name;

        @Schema(description = "할인유형", example = "PRICE")
        private String discountType;

        @Schema(description = "할인값", example = "5000")
        private int discountValue;

        @Schema(description = "최소금액", example = "10000")
        private int minAmount;

        @Schema(description = "쿠폰상태", example = "USED")
        private String status;

        @Schema(description = "사용일", example = "2025-01-01 00:00:00")
        private LocalDateTime usedAt;

        @Schema(description = "만료일", example = "2025-01-01 00:00:00")
        private LocalDateTime expiredAt;
    }

}
