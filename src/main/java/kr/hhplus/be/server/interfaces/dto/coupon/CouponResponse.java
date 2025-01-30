package kr.hhplus.be.server.interfaces.dto.coupon;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CouponResponse {

    @Getter
    @Builder
    public static class Info {
        private Long couponId;
        private Long userId;
    }

}
