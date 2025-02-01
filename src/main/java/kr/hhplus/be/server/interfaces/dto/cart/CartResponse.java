package kr.hhplus.be.server.interfaces.dto.cart;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CartResponse {

    @Getter
    @Builder
    @Schema(name = "CartResponse.Info", description = "장바구니 조회 결과 객체")
    public static class Info {
        @Schema(description = "장바구니 ID", example = "1")
        private Long cartId;

        @Schema(description = "상품 ID", example = "1")
        private Long productId;

        @Schema(description = "사용자 ID", example = "1")
        private Long userId;

        @Schema(description = "수량", example = "1")
        private int quantity;
    }

}
