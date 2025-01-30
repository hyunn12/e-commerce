package kr.hhplus.be.server.interfaces.dto.point;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PointRequest {

    @Getter
    @Builder
    public static class Charge {
        private Long userId;
        private int point;
    }

    @Getter
    @Builder
    public static class Use {
        private Long userId;
        private int point;
    }

}
