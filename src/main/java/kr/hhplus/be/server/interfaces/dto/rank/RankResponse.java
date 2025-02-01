package kr.hhplus.be.server.interfaces.dto.rank;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RankResponse {

    @Getter
    @Builder
    @Schema(name = "RankResponse.Info", description = "인기 상품 조회 결과 객체")
    public static class Info {
        @Schema(description = "순위 ID", example = "1")
        private Long rankId;

        @Schema(description = "상품 ID", example = "1")
        private Long productId;

        @Schema(description = "상품명", example = "Test Product A")
        private String productName;

        @Schema(description = "순위", example = "1")
        private int rank;

        @Schema(description = "판매개수", example = "1000")
        private long salesCount;

        @Schema(description = "순위기준일", example = "2025-01-01 00:00:00")
        private LocalDateTime rankedAt;

        @Schema(description = "수정일", example = "2025-01-01 00:00:00")
        private LocalDateTime updatedAt;

        public static Info of() {
            return Info.builder().build();
        }
    }

}
