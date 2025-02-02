package kr.hhplus.be.server.interfaces.dto.order;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderResponse {

    @Getter
    @Builder
    @Schema(name = "OrderResponse.Info", description = "주문 조회 결과 객체")
    public static class Info {
        @Schema(description = "주문 ID", example = "1")
        private Long orderId;

        @Schema(description = "총금액", example = "20000")
        private int totalAmount;

        @Schema(description = "최종금액", example = "15000")
        private int finalAmount;

        @Schema(description = "주문상태", example = "SUCCESS")
        private String status;

        @Schema(description = "생성일", example = "2025-01-01 00:00:00")
        private LocalDateTime createdAt;

        @Schema(description = "수정일", example = "2025-01-01 00:00:00")
        private LocalDateTime updatedAt;

        @Schema(description = "주문 상세 목록")
        private List<OrderResponse.ItemInfo> items;
    }

    @Getter
    @Builder
    @Schema(name = "OrderResponse.ItemInfo", description = "주문 상세 조회 결과 객체")
    public static class ItemInfo {
        @Schema(description = "주문상세 ID", example = "1")
        private Long orderItemId;

        @Schema(description = "주문 ID", example = "1")
        private Long orderId;

        @Schema(description = "상품 ID", example = "1")
        private Long productId;

        @Schema(description = "수량", example = "2")
        private int quantity;

        @Schema(description = "소계", example = "10000")
        private int subtotal;
    }

}
