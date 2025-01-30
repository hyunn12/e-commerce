package kr.hhplus.be.server.interfaces.dto.product;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductResponse {

    @Getter
    @Builder
    public static class Info {
        private Long productId;
        private String name;
        private int price;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        public static Info of() {
            return Info.builder().build();
        }
    }

}
