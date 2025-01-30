package kr.hhplus.be.server.interfaces.dto.order;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderResponse {

    @Getter
    @Builder
    public static class Info {
        private Long orderId;
        private int totalAmount;
        private int finalAmount;
        private String status;
        private List<OrderResponse.ItemInfo> items;
    }

    @Getter
    @Builder
    public static class ItemInfo {
        private Long orderItemId;
        private Long orderId;
        private Long productId;
        private int quantity;
        private int subtotal;
    }

}
