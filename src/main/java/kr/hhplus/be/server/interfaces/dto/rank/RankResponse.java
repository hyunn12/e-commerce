package kr.hhplus.be.server.interfaces.dto.rank;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RankResponse {

    @Getter
    @Builder
    public static class Info {
        private Long rankId;
        private Long productId;
        private String productName;
        private int rank;
        private long salesCount;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        public static Info of() {
            return Info.builder().build();
        }
    }

}
