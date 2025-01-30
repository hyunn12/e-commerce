package kr.hhplus.be.server.interfaces.dto.point;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PointResponse {

    @Getter
    @Builder
    public static class Info {
        private int point;
    }

}
