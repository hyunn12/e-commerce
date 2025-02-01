package kr.hhplus.be.server.interfaces.dto.coupon;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CouponRequest {

    @Getter
    @Builder
    @Schema(name = "CouponRequest.Issue", description = "쿠폰 발급 요청 객체")
    public static class Issue {
        @Schema(description = "쿠폰 ID", example = "1")
        private Long couponId;

        @Schema(description = "사용자 ID", example = "1")
        private Long userId;
    }

}
