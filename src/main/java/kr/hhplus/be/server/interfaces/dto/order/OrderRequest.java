package kr.hhplus.be.server.interfaces.dto.order;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderRequest {

    @Getter
    @Builder
    public static class Insert {
        private Long userId;
        private Long couponId;
        private List<OrderRequest.Item> items;
    }

    @Getter
    @Builder
    public static class Item {
        private Long productId;
        private int quantity;
    }

    @Getter
    @Builder
    public static class Cancel {
        private Long orderId;
    }

}
