package kr.hhplus.be.server.interfaces.dto.coupon;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CouponRequest {

    @Getter
    @Builder
    public static class Issue {
        private Long couponId;
        private Long userId;
    }

}
