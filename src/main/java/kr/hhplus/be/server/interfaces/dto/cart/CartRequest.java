package kr.hhplus.be.server.interfaces.dto.cart;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CartRequest {

    @Getter
    @Builder
    @Schema(name = "CartRequest.Insert", description = "장바구니 추가 요청 객체")
    public static class Insert {
        @Schema(description = "상품 ID", example = "1")
        private Long productId;

        @Schema(description = "사용자 ID", example = "1")
        private Long userId;

        @Schema(description = "수량", example = "1")
        private int quantity;
    }

    @Getter
    @Builder
    @Schema(name = "CartRequest.Delete", description = "장바구니 삭제 요청 객체")
    public static class Delete {
        @Schema(description = "장바구니 ID", example = "1")
        private Long cartId;
    }

    @Getter
    @Builder
    @Schema(name = "CartRequest.Modify", description = "장바구니 수정 요청 객체")
    public static class Modify {
        @Schema(description = "장바구니 ID", example = "1")
        private Long cartId;

        @Schema(description = "수량", example = "2")
        private int quantity;
    }

}
