package kr.hhplus.be.server.interfaces.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserRequest {

    @Getter
    @Builder
    @Schema(name = "UserRequest.ChargePoint", description = "사용자 포인트 충전 요청 객체")
    public static class ChargePoint {
        @Schema(description = "사용자 ID", example = "1")
        private Long userId;

        @Schema(description = "포인트", example = "10000")
        private int point;
    }

    @Getter
    @Builder
    @Schema(name = "UserRequest.IssueCoupon", description = "사용자 쿠폰 발급 요청 객체")
    public static class IssueCoupon {
        @Schema(description = "쿠폰 ID", example = "1")
        private Long couponId;

        @Schema(description = "사용자 ID", example = "1")
        private Long userId;
    }

    @Getter
    @Builder
    @Schema(name = "UserRequest.CreateCart", description = "사용자 장바구니 추가 요청 객체")
    public static class CreateCart {
        @Schema(description = "상품 ID", example = "1")
        private Long productId;

        @Schema(description = "사용자 ID", example = "1")
        private Long userId;

        @Schema(description = "수량", example = "1")
        private int quantity;
    }

    @Getter
    @Builder
    @Schema(name = "UserRequest.DeleteCart", description = "사용자 장바구니 삭제 요청 객체")
    public static class DeleteCart {
        @Schema(description = "장바구니 ID", example = "1")
        private Long cartId;
    }

    @Getter
    @Builder
    @Schema(name = "UserRequest.ModifyCart", description = "사용자 장바구니 수정 요청 객체")
    public static class ModifyCart {
        @Schema(description = "장바구니 ID", example = "1")
        private Long cartId;

        @Schema(description = "수량", example = "2")
        private int quantity;
    }
    
}
