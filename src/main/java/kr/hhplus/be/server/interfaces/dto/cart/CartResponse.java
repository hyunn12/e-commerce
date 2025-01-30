package kr.hhplus.be.server.interfaces.dto.cart;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CartResponse {

    @Getter
    @Builder
    public static class Info {
        private Long cartId;
        private Long productId;
        private Long userId;
        private int quantity;
    }

}
