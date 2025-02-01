package kr.hhplus.be.server.interfaces.dto.product;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductRequest {

    @Getter
    @Schema(name = "ProductRequest.Product", description = "상품 조회 요청 객체")
    public static class Product {
        @Schema(description = "상품 ID", example = "1")
        private Long productId;

        @Schema(description = "상품명", example = "Test Product A")
        private String name;

        @Schema(description = "가격", example = "5000")
        private int price;
    }

}
