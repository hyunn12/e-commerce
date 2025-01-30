package kr.hhplus.be.server.interfaces.dto.cart;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CartRequest {

    @Getter
    @Builder
    public static class Insert {
        private Long productId;
        private Long userId;
        private int quantity;
    }

    @Getter
    @Builder
    public static class Delete {
        private Long cartId;
    }

    @Getter
    @Builder
    public static class Modify {
        private Long cartId;
        private int quantity;
    }

}
