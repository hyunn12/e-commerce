package kr.hhplus.be.server.interfaces.dto.product;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductRequest {

    @Getter
    public static class Product {
        private Long productId;
        private String name;
        private int price;
    }

}
