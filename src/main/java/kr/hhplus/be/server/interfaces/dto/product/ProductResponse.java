package kr.hhplus.be.server.interfaces.dto.product;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductResponse {

    @Getter
    @Builder
    @Schema(name = "ProductResponse.Info", description = "상품 조회 결과 객체")
    public static class Info {
        @Schema(description = "상품 ID", example = "1")
        private Long productId;

        @Schema(description = "상품명", example = "Test Product A")
        private String name;

        @Schema(description = "가격", example = "5000")
        private int price;

        @Schema(description = "생성일", example = "2025-01-01 00:00:00")
        private LocalDateTime createdAt;

        @Schema(description = "수정일", example = "2025-01-01 00:00:00")
        private LocalDateTime updatedAt;

        public static Info of() {
            return Info.builder().build();
        }
    }

}
