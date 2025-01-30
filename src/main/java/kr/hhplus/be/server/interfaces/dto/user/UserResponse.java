package kr.hhplus.be.server.interfaces.dto.user;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserResponse {

    @Getter
    @Builder
    public static class PointInfo {
        private int point;
    }

    @Getter
    @Builder
    public static class CouponInfo {
        private Long couponId;
        private String name;
        private String discountType;
        private int discountValue;
        private int minAmount;
        private String status;
        private LocalDateTime usedAt;
        private LocalDateTime expiredAt;
    }

}
