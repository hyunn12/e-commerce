package kr.hhplus.be.server.interfaces.dto.point;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PointResponse {

    @Getter
    @Builder
    @Schema(name = "PointResponse.Info", description = "포인트 조회 결과 객체")
    public static class Info {
        @Schema(description = "포인트", example = "10000")
        private int point;
    }

}
