package kr.hhplus.be.server.interfaces.dto.order;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderRequest {

    @Getter
    @Builder
    @Schema(name = "OrderRequest.Insert", description = "주문 추가 요청 객체")
    public static class Insert {
        @Schema(description = "사용자 ID", example = "1")
        private Long userId;

        @Schema(description = "쿠폰 ID", example = "1")
        private Long couponId;

        @Schema(description = "주문 상세 목록")
        private List<OrderRequest.Item> items;
    }

    @Getter
    @Builder
    @Schema(name = "OrderRequest.Item", description = "주문 상세 객체")
    public static class Item {
        @Schema(description = "상품 ID", example = "1")
        private Long productId;

        @Schema(description = "수량", example = "2")
        private int quantity;
    }

    @Getter
    @Builder
    @Schema(name = "OrderRequest.Cancel", description = "주문 취소 요청 객체")
    public static class Cancel {
        @Schema(description = "주문 ID", example = "1")
        private Long orderId;
    }

}
