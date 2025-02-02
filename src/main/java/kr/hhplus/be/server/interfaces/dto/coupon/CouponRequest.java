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
    @Schema(name = "CouponRequest.Create", description = "쿠폰 생성 요청 객체")
    public static class Create {
        @Schema(description = "쿠폰명", example = "Coupon Example")
        private String name;

        @Schema(description = "최대개수", example = "100")
        private int maxCount;

        @Schema(description = "할인유형", example = "PRICE")
        private String discountType;

        @Schema(description = "할인값", example = "5000")
        private int discountValue;

        @Schema(description = "최소금액", example = "10000")
        private int minAmount;
    }

}
