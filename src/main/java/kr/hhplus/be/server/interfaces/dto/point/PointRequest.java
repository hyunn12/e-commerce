package kr.hhplus.be.server.interfaces.dto.point;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PointRequest {

    @Getter
    @Builder
    @Schema(name = "PointRequest.Charge", description = "포인트 충전 요청 객체")
    public static class Charge {
        @Schema(description = "사용자 ID", example = "1")
        private Long userId;

        @Schema(description = "포인트", example = "10000")
        private int point;
    }

    @Getter
    @Builder
    @Schema(name = "PointRequest.Use", description = "포인트 사용 요청 객체")
    public static class Use {
        @Schema(description = "사용자 ID", example = "1")
        private Long userId;

        @Schema(description = "포인트", example = "10000")
        private int point;
    }

}
